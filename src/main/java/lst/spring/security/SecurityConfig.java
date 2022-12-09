package lst.spring.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private SecurityUserDetailsService userDetailsService;
	
	@Autowired
	private CustomOAuth2UserService Oauth2UserService;
	
	@Bean
	protected SecurityFilterChain configure(HttpSecurity security) throws Exception{
		security.userDetailsService(userDetailsService);
		security.authorizeRequests().antMatchers("/", "/system/**").permitAll();
		security.authorizeRequests().antMatchers("/board/**").authenticated();
		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		security.csrf().disable();
		security.formLogin().loginPage("/system/login")
		.defaultSuccessUrl("/system/main", true);
		security.exceptionHandling().accessDeniedPage("/system/accessDenied");
		security.logout().logoutUrl("/system/logout").invalidateHttpSession(true).logoutSuccessUrl("/");
		
		security.oauth2Login().loginPage("/system/login")// OAuth2기반의 로그인인 경우
		.loginPage("/loginForm")		// 인증이 필요한 URL에 접근하면 /loginForm으로 이동
		.defaultSuccessUrl("/system/main", true)// 로그인 성공하면 "/" 으로 이동
		.failureUrl("/system/login") // 로그인 실패 시 /loginForm으로 이동
		.userInfoEndpoint() // 로그인 성공 후 사용자정보를 가져온다
		.userService(Oauth2UserService)
		;
		return security.build();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		}
	
}