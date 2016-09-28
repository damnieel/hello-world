package com.moon.vip.service.impl.makeTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.vip.service.attend.IAttendXslMakerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/root-test.xml"})
public class TestMakeTest {
 @Autowired
 private  IAttendXslMakerService attendXslMakerService;
 
 @Test
 public void getExcel(){
	 attendXslMakerService.getExcel(12);
 }
}
