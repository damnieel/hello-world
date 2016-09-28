package com.moon.vip.infra.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class BeanUtil {

    private static final ConcurrentHashMap<Class<?>, ConcurrentHashMap<String, PropertyDescriptor>> cacheMap = new ConcurrentHashMap<Class<?>, ConcurrentHashMap<String, PropertyDescriptor>>();
	
    public static <T,S> List<T> copyList(List<S> source, Class<T> clazz, String... ignoreFields){
    	return copyList(source, clazz, true, ignoreFields);
    }
    
	public static <T,S> List<T> copyList(List<S> source, Class<T> clazz, boolean ignoreBlack, String... ignoreFields){
		List<T> list = new ArrayList<T>(source.size());
		for(S s:source){
			list.add(copy(s, clazz, ignoreBlack, ignoreFields));
		}
		return list;
	}

    private static Map<String, PropertyDescriptor> getPropertyDescriptorsMap(Class<?> clazz){
        synchronized (cacheMap) {
            ConcurrentHashMap < String, PropertyDescriptor > pdMap = cacheMap.get(clazz);
            if (pdMap == null) {
                try {
                    BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
                    PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
                    pdMap = new ConcurrentHashMap<String, PropertyDescriptor>();
                    for (PropertyDescriptor pd : pds) {
                        pdMap.put(pd.getName(), pd);
                    }
                    cacheMap.put(clazz, pdMap);
                } catch (IntrospectionException e) {
                    //nothing
                }
            }
            return pdMap;
        }
    }

    public static Collection<PropertyDescriptor> getPropertyDescriptors(Class<?> clazz){
        Map<String, PropertyDescriptor>  pdMap = getPropertyDescriptorsMap(clazz);
        return pdMap.values();
    }

    public static PropertyDescriptor getPropertyDescriptor(Class<?> clazz, String name){
        Map<String, PropertyDescriptor>  pdMap = getPropertyDescriptorsMap(clazz);
        return pdMap.get(name);
    }
    
    public static void copy(Object source, Object target, String... ignoreProperties){
    	copy(source, target, true, ignoreProperties);
    }

    public static void copy(Object source, Object target, boolean ignoreBlack, String... ignoreProperties){
        Collection<PropertyDescriptor> targetPds = getPropertyDescriptors(target.getClass());
        List<String> ignoreList = (ignoreProperties != null) ? Arrays.asList(ignoreProperties) : null;

        for (PropertyDescriptor targetPd : targetPds) {
            if (targetPd.getWriteMethod() != null &&
                    (ignoreProperties == null || (!ignoreList.contains(targetPd.getName())))) {
                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null && sourcePd.getReadMethod() != null) {
                    try {
                        Method readMethod = sourcePd.getReadMethod();
                        if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                            readMethod.setAccessible(true);
                        }
                        Object value = readMethod.invoke(source);
                        if(ignoreBlack) {
                            //if (value != null && (value instanceof String && ((String) value).trim().length() > 0)) {
                                Method writeMethod = targetPd.getWriteMethod();
                                if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                    writeMethod.setAccessible(true);
                                }
                                writeMethod.invoke(target, value);
                            //}
                        }else{
                            Method writeMethod = targetPd.getWriteMethod();
                            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                writeMethod.setAccessible(true);
                            }
                            writeMethod.invoke(target, value);
                        }
                    } catch (Throwable ex) {
						ex.printStackTrace();
                    }
                }
            }
        }
    }
    
    public static <T> T copy(Object source, Class<T> target, String... ignoreFields){
    	return copy(source, target, true, ignoreFields);
    }
	
	public static <T> T copy(Object source, Class<T> target, boolean ignoreBlack, String... ignoreFields){
		try {
			T newInstance = target.newInstance();
			copy(source, newInstance, ignoreBlack, ignoreFields);
			return newInstance;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
