package org.superbiz.struts;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class Application {
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean filterSiteMesh(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new com.opensymphony.module.sitemesh.filter.PageFilter());
        //registrationBean.setInitParameters(initParams);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean filterStrutsCleanup(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new org.apache.struts2.dispatcher.ActionContextCleanUp());
        //registrationBean.setInitParameters(initParams);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean filterStruts() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new org.apache.struts2.dispatcher.FilterDispatcher());
        Map<String, String> initParams = new HashMap<String, String>();
        initParams.put("actionPackages", "com.lq");
        registrationBean.setInitParameters(initParams);
        registrationBean.addUrlPatterns();
        return registrationBean;
    }


}
