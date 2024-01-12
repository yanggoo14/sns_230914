package com.sns.test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sns.mapper.PostMapper;

@Controller
public class TestController {
	
	@Autowired
	private PostMapper postMapper;
	
	@GetMapping("/test1")
	@ResponseBody
	public String test1() {
		return "Hello world";
	}
	@GetMapping("/test3")
	public String test3() {
		return "test/test";
	}
	@GetMapping("/test4")
	@ResponseBody
	public List<Map<String, Object>> test4(){
		return postMapper.selectPostList();
	}
}
