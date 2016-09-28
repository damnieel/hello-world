package com.moon.vip.service.impl.sys;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.moon.vip.service.sys.IUrlInfoService;
@Service("urlInfoService")
public class UrlInfoInfoServiceImpl implements IUrlInfoService{
	@Cacheable(value = "UrlInfomation")
	public List getUrlInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
