package com.leftiejy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@SpringBootApplication
@EnableAutoConfiguration
public class UrlshortenerApplication implements WebApplicationInitializer {

	public static void main(String[] args) {
		SpringApplication.run(UrlshortenerApplication.class, args);
	}

    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext servletContext = new AnnotationConfigWebApplicationContext();

        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(servletContext));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");

    }
}
