package com.yh;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * 启动类
 */
@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {

    /**
     * @param args
     */
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

        FastJsonConfig config = new FastJsonConfig();

        config.setSerializerFeatures(SerializerFeature.PrettyFormat);

        converter.setFastJsonConfig(config);

        converters.add(converter);
    }
}
