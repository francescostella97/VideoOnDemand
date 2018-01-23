package com.conf;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class HelloWorldInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(javax.servlet.ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext servletContext = new AnnotationConfigWebApplicationContext();
        servletContext.register(HelloWorldConfiguration.class);
        servletContext.setServletContext(container);

        ServletRegistration.Dynamic servlet = container.addServlet("springDispatcher",new DispatcherServlet(servletContext));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}
