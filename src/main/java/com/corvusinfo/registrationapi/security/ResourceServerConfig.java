package com.corvusinfo.registrationapi.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    //private final DefaultTokenServices tokenServices;

   /* public ResourceServerConfig(DefaultTokenServices tokenServices) {
        this.tokenServices = tokenServices;
    }*/

   /* @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenServices(tokenServices);
    }*/

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().sameOrigin();
        http.anonymous().and().authorizeRequests()
                .antMatchers("/register").authenticated()
                .antMatchers("/account").permitAll()
                .antMatchers("/oauth/token*").permitAll()
              //  .antMatchers("/console/**").permitAll()
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}
