// package com.example.demo.conf;
//
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.builders.WebSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
// @EnableWebSecurity
// @Configuration
// public class CustomWebSecurityConfigurerAdapter extends
// WebSecurityConfigurerAdapter {

// /**
// * 在内存在设置角色User(名称：user，密码：password)
// *
// * @param auth
// * @throws Exception
// */
// protected void registerAuthentication(AuthenticationManagerBuilder auth)
// throws Exception {
// auth.inMemoryAuthentication().withUser("user") // #1
// .password("user").roles("USER").and().withUser("admin") // #2
// .password("admin").roles("ADMIN", "USER");
// }
//
// /**
// * 所有URL只有登录认证后才能跳转
// */
// protected void configure(HttpSecurity http) throws Exception {
// http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
// }
// /**
// * 跳过css，js，img等资源的认证
// */
// @Override
// public void configure(WebSecurity web) throws Exception {
// web.ignoring().antMatchers("/resources/**"); // #3
// }
//
// /**
// *
// */
// @Override
// protected void configure(HttpSecurity http) throws Exception {
// http.authorizeRequests().antMatchers("/signup", "/about").permitAll()
// //#4跳过/signup和/about的认证
// .antMatchers("/admin/**").hasRole("ADMIN") // #6只有ADMIN角色才能请求/admin/**
// .anyRequest().authenticated() // #7所有请求都要认证
// .and().formLogin() // #8使用表单登录
// .loginPage("/login") // #9由login登录认证（需要定义mapping，如果没有则使用默认的登录页面）
// .permitAll(); // #5
//
// http.csrf().disable();//关闭csrf
// }
// }
