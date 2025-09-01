forEach: BoundedContext
path: {{nameCamelCase}}/{{nameCamelCase}}-boot/src/main/java/com/poscodx/{{options.serviceId}}/{{nameCamelCase}}/config
fileName: GsonHttpMessageConverterConfiguration.java
---
package com.poscodx.{{options.serviceId}}.{{nameCamelCase}}.config;

import java.util.List;
import com.poscodx.base.share.util.json.JsonUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Auto generated class
 * 
 * 자동생성 프로그램 버전 : 1.0.0
 * 생성일시 :  {{currentTimeStamp}}
 * @FileName : 클래스에 대한 한글 명칭
 * Change history
 * @수정날짜;SCR_NO;수정자;수정내용
 * @{{currentTimeStamp}};00000;홍길동;최초생성
 * 
 */
@Configuration
public class GsonHttpMessageConverterConfiguration
    implements WebMvcConfigurer
{

    @Bean
    public GsonHttpMessageConverter gsonHttpMessageConverter() {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(JsonUtil.getGson());
        return converter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(this.gsonHttpMessageConverter());
        WebMvcConfigurer.super.configureMessageConverters(converters);
    }
}
