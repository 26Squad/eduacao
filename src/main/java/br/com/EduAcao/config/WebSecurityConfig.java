package br.com.EduAcao.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.EduAcao.servicos.UserDetailsServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/adminlte/**").permitAll() .antMatchers("/static/**").permitAll().antMatchers("/**").permitAll().antMatchers("/img/**").permitAll().antMatchers("/Imagens/**").permitAll()
				.antMatchers("/js/**").permitAll().antMatchers("/plugins/**").permitAll().anyRequest().authenticated();
		

        http.formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/cliente")
        .permitAll();

    http.logout()
        .logoutRequestMatcher(
            new AntPathRequestMatcher("/logout", "GET")
        )
        .logoutSuccessUrl("/login");

    http.rememberMe()
        .key("chaverememberMe");
	
	//@Override
   // protected void configure(HttpSecurity httpSecurity) throws Exception {
   //     httpSecurity.authorizeRequests().antMatchers("/").permitAll();
     }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new BCryptPasswordEncoder());

	}

}
