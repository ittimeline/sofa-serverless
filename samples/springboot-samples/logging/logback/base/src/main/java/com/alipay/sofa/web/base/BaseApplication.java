package com.alipay.sofa.web.base;

import ch.qos.logback.classic.ClassicConstants;
import com.alipay.sofa.serverless.logback.SOFAServerlessLogbackLogContextSelector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource({ "classpath*:META-INF/spring/service.xml"})
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
public class BaseApplication {
	private static Logger LOGGER ;

	public static void main(String[] args) {
		//建议加到jvm 参数中
		System.setProperty(ClassicConstants.LOGBACK_CONTEXT_SELECTOR,
				SOFAServerlessLogbackLogContextSelector.class.getName());
		LOGGER = LoggerFactory.getLogger(BaseApplication.class);
		ConfigurableApplicationContext context = SpringApplication.run(
				BaseApplication.class, args);
		context.getBean("sampleService");
		LOGGER.info("BaseApplication start!");
		LOGGER.info("Spring Boot Version: " + SpringApplication.class.getPackage().getImplementationVersion());
		LOGGER.info("BaseApplication classLoader: " + BaseApplication.class.getClassLoader());
	}
}