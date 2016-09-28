package com.moon.vip.service.impl.rules;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.constants.EnumReference;
import com.moon.vip.infra.constants.EnumReplaceType;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.rules.Body;
import com.moon.vip.service.rules.IReplaceService;
import com.moon.vip.service.rules.ISubscriberReplaceService;
import com.moon.vip.service.rules.ResourceSubscriber;

@Service("subscriberReplaceService")
@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
public class SubscriberReplaceImpl implements ISubscriberReplaceService {
	
	@Autowired
	@Qualifier("adviserReplaceService")
	private IReplaceService adviserReplaceService;
	
	@Autowired
	@Qualifier("teacherReplaceService")
	private IReplaceService teacherReplaceService;
	
	@Autowired
	@Qualifier("employeeReplaceService")
	private IReplaceService employeeReplaceService;
	
	@Autowired
	@Qualifier("costomReplaceService")
	private IReplaceService costomReplaceService;
	
	@Autowired
	@Qualifier("subNodeReplaceService")
	private IReplaceService subNodeReplaceService;

	private List<ResourceSubscriber> resourceList = new ArrayList<ResourceSubscriber>();
	private String content;

	public ISubscriberReplaceService setInteger(EnumReference reference, Integer... values) {
		Body body = new Body();
		body.setType(EnumReplaceType.STRING);
		for(Integer val : values) {
			body.addValues(val);
		}
		createResourceList(reference, body);
		return this;
	}

	public ISubscriberReplaceService setString(EnumReference reference, String... values) {
		Body body = new Body();
		body.setType(EnumReplaceType.STRING);
		for(String val : values) {
			body.addValues(val); 
		}
		createResourceList(reference, body);
		return this;
	}

	private void createResourceList(EnumReference reference, Body body) {
		ResourceSubscriber resource = new ResourceSubscriber();
		body.setReference(reference);
		resource.setBody(body);
		switch (reference) {
		case CURRENT_TEACHER:
			resource.setReplaceService(teacherReplaceService);
			break;
		case CURRENT_ADVISER:
			resource.setReplaceService(adviserReplaceService);
			break;
		case CURRENT_EMPLOYEE:
			resource.setReplaceService(employeeReplaceService);
			break;
		case SUB_NODE:
			resource.setReplaceService(subNodeReplaceService);
			break;
		case CUSTOM:
			resource.setReplaceService(costomReplaceService);
			break;
		case ALL:
			throw new BusinessException(EnumCodeException.E0114);
		default:
			throw new BusinessException(EnumCodeException.E0113);
		}
		resourceList.add(resource);
	}

	public ISubscriberReplaceService createReplaceContent(String content) {
		this.content = content;
		return this;
	}

	public String excute() {
		for(ResourceSubscriber resource : resourceList) {
			content = resource.getReplaceService().replace(resource.getBody(), content);
		}
		return content;
	}
	
}
