package com.ax.common.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by kyy on 2017/9/8.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigSupport extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
    }

    @Value("${security.jwtSecret}")
    private String jwtSecret;
    @Value("${security.jwtExpiresTime}")
    private int jwtExpiresTime;

    @Bean
    public JwtTokenService jwtTokenService() {
        return new JwtTokenService(jwtSecret, jwtExpiresTime);
    }

    @Bean
    public JwtAuthFilter jwtAuthFilter() {
        return new JwtAuthFilter(jwtTokenService());
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new JwtAuthEntryPoint();
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return lookup(UserDetailsService.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
        customizeAuthenticationManager(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable() //关闭csrf
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint()).and()
                //由于基于token，故关闭session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll() //跨域请求
                //.antMatchers(HttpMethod.GET, "/*.html").permitAll() //静态资源
                .antMatchers("/session/**").permitAll() //登陆请求
                //去除以上请求外都需要鉴权
                .anyRequest().authenticated();

        http.headers().cacheControl(); //取消缓存
        http.addFilterBefore(jwtAuthFilter(), UsernamePasswordAuthenticationFilter.class);
        customizeFilters(http);

    }


    protected void customizeAuthenticationManager(AuthenticationManagerBuilder auth) {
    }


    protected void customizeFilters(HttpSecurity http) {
    }

    protected <T> T lookup(Class<T> tClass) {
        return (T) getApplicationContext().getBean(tClass);
    }


}
