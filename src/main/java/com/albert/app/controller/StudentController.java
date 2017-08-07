package com.albert.app.controller;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albert.app.model.Girl;
import com.albert.app.service.GirlService;

@RestController
@RefreshScope
public class StudentController {

	@Autowired
	private GirlService girlService;
	
	@Value("${testp}")
	String url;
	@Value("${config.client.version}")
	String ver;
	@Value("${server.port}")
	String port;

	@RequestMapping("/getStudent/{id}")
	public String getStudent(@PathVariable String id) {
		if (id != null && StringUtils.isNumeric(id)) {
			Girl g = girlService.getGirlById(Long.parseLong(id));
			return "age:"+g.getAge()+"  cup size:" + g.getCupSize()+"   . test: "+url + " port:" +port ;
		}
		String errStr = url + "----the parameter must be a number"+"___config.client.version:"+ver + " port:" +port;
		System.out.println(errStr);
		return errStr;
	}

}
