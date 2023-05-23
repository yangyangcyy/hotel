package com.example.hotel.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 配置WebMvcConfigurer
 *
 * @author created by wutong li on 2021/04/29
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	/**
	 * 图片保存路径，自动从yml文件中获取数据
	 * 示例： E:/images/
	 */
	@Value ("${file-save-path}")
	private String fileSavePath;
	
	@Bean
	public HttpMessageConverter<String> responseBodyConverter () {
		return new StringHttpMessageConverter (StandardCharsets.UTF_8);
	}
	
	@Override
	public void configureMessageConverters (List<HttpMessageConverter<?>> converters) {
		WebMvcConfigurer.super.configureMessageConverters (converters);
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter ();
		//设置日期格式
		ObjectMapper objectMapper = new ObjectMapper ();
		SimpleDateFormat smt = new SimpleDateFormat ("yyyy-MM-dd");
		objectMapper.setDateFormat (smt);
		mappingJackson2HttpMessageConverter.setObjectMapper (objectMapper);
		//设置中文编码格式
		List<MediaType> list = new ArrayList<> ();
		list.add (MediaType.valueOf ("application/json;charset=UTF-8"));
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes (list);
		converters.add (responseBodyConverter ());
		converters.add (mappingJackson2HttpMessageConverter);
	}
	
	@Override
	public void addResourceHandlers (ResourceHandlerRegistry registry) {
		/**
		 * 配置资源映射
		 * 意思是：如果访问的资源路径是以“/images/”开头的，
		 * 就给我映射到本机的“E:/images/”这个文件夹内，去找你要的资源
		 * 注意：E:/images/ 后面的 “/”一定要带上
		 */
		registry.addResourceHandler ("/img/**")
				.addResourceLocations ("file:" + fileSavePath);
	}
}