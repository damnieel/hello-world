package com.moon.vip.service.impl.sys;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.vip.service.sys.IProfessionSquenceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/root-test.xml"})
public class TestProfesscionSquenceServiceImple {

	@Autowired
	@Qualifier("professionSquenceService")
	private IProfessionSquenceService professionSquenceService;
	
	@Test
	public void testProduceSequence() {
		professionSquenceService.getStudentCode(new Date(), 266);
	}
}
