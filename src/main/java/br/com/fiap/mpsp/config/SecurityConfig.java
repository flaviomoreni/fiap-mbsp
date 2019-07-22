package br.com.fiap.mpsp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("fiap").password(encoder.encode("mpsp")).roles("USER");
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.
        	ignoring().antMatchers("/arisp/**")
        	.and().ignoring().antMatchers("/arpensp/**")
        	.and().ignoring().antMatchers("/cadesp/**")
        	.and().ignoring().antMatchers("/caged/**")
        	.and().ignoring().antMatchers("/jucesp/**")
        	.and().ignoring().antMatchers("/sivec/**");
    }
	
}
