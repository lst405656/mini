package lst.spring.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private SecurityUserDetailsService userDetailsService;
	
	@Bean
	protected SecurityFilterChain configure(HttpSecurity security) throws Exception{
		security.userDetailsService(userDetailsService);
		security.authorizeRequests().antMatchers("/", "/system/**").permitAll();
		security.authorizeRequests().antMatchers("/board/**").authenticated();
		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		security.csrf().disable();
		security.formLogin().loginPage("/system/login")
		.defaultSuccessUrl("/board/getBoardList", true);
		security.exceptionHandling().accessDeniedPage("/system/accessDenied");
		security.logout().logoutUrl("/system/logout").invalidateHttpSession(true).logoutSuccessUrl("/");
		return security.build();
	}
}