package co.kr.db.security.config;

import co.kr.db.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  private UserService userService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests()
        .and()
        .authorizeRequests()
        .antMatchers("/loginPage").permitAll() // 누구나 접근 허용
        .antMatchers("/failurePage").permitAll() // 누구나 접근 허용
        .antMatchers("/*").authenticated() // 일반사용자 접근 가능
        //.anyRequest().authenticated() // 나머지 요청들은 권한의 종류에 상관 없이 권한이 있어야 접근
        .and()
        .formLogin()
        .loginPage("/loginPage")
        .usernameParameter("username")
        .passwordParameter("password")
        .loginProcessingUrl("/loginProcess")
        .defaultSuccessUrl("/successPage")
        .failureUrl("/failurePage");
/*      .and()
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/loginPage")
        .deleteCookies("JSESSIONID", "remember - me");*/
  }

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    // BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    // System.out.println("암호화할 비밀번호 작성 : " + passwordEncoder.encode("1234"));
    // 암호화를 대입할때 해당 암호화방식을 대입하라는 의미
    auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
  }
}