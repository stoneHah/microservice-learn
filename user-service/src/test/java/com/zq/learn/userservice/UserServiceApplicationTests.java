package com.zq.learn.userservice;

import com.netflix.discovery.converters.Auto;
import com.zq.learn.userservice.common.MyBean;
import com.zq.learn.userservice.service.IFileUploadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceApplicationTests {

	@Autowired
	private List<IFileUploadService> fileUploadServices = Collections.emptyList();

	@Test
	public void contextLoads() {
	}

	@Test
	public void testFileUploadServices(){
		System.out.println(fileUploadServices.size());
	}

}
