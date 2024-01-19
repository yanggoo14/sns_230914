package com.sns.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sns.common.FileManagerService;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/images/**") // 웹 이미지 패스 http://localhost:8080/images/aaaa_17834781147/sun.png
		.addResourceLocations("file:///" + FileManagerService.FILE_UPLOAD_PATH); // 실제 파일 위치
	}
}
