package com.coder.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@EnableScheduling
public class SpringMvcXmlConfig implements WebMvcConfigurer{ 

	//<bean class="---InternalResourceViewResolver <prefix><suffix><viewClass
		@Bean(name="viewResolver")//<bean>
		public InternalResourceViewResolver getViewResolver(){
			System.out.println("SpringMVCXML COnifg--->prepare view resolver");
			InternalResourceViewResolver rv=new InternalResourceViewResolver();// class
				rv.setPrefix("/WEB-INF/views/");//<prefix
				rv.setSuffix(".jsp");//<suffix
				rv.setViewClass(JstlView.class);//viewClass
			return rv;
		}

		@Bean(name = "multipartResolver")
		public CommonsMultipartResolver multipartResolver() {
		    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		    multipartResolver.setMaxUploadSize(500000000);
		    return multipartResolver;
		}
		
		@Bean
		public MessageSource messageSource() {
		    ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		    source.setBasename("i18n/messages");
		    source.setDefaultEncoding("UTF-8");
		    return source;
		}
		
		@Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry
	          .addResourceHandler("/resources/**")
	          .addResourceLocations("/resources/"); 
	    }
		@Bean
	    HandlerExceptionResolver customExceptionResolver () {
	        CustomSimpleMappingExceptionResolver resolver = new CustomSimpleMappingExceptionResolver();
	        Properties mappings = new Properties();
	        // Mapping Spring internal error NoHandlerFoundException to a view name
	        mappings.setProperty(NoHandlerFoundException.class.getName(), "/error/404");
	        mappings.setProperty(IllegalStateException.class.getName(), "/error/500");
	        mappings.setProperty(NullPointerException.class.getName(), "/error/500");
	        mappings.setProperty(ClassNotFoundException.class.getName(), "/error/500");
	        mappings.setProperty(Exception.class.getName(), "/error/generic");
	        resolver.setExceptionMappings(mappings);
	        // Set specific HTTP codes
	        resolver.addStatusCode("404", HttpStatus.NOT_FOUND.value());
	        resolver.addStatusCode("500", HttpStatus.INTERNAL_SERVER_ERROR.value());
	        resolver.setDefaultErrorView("/error/generic");
	        resolver.setDefaultStatusCode(200);
	        // This resolver will be processed before the default ones
	        resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
	        resolver.setExceptionAttribute("exception");
	        return resolver;
	    }
}
