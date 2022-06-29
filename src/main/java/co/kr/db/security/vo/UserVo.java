package co.kr.db.security.vo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
public class UserVo implements UserDetails {
  private int userNo;
  private String userId;
  private String userPw;
  private String userName;
  private String userAuth;
  private String appendDate;
  private String updateDate;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singletonList(new SimpleGrantedAuthority(this.userAuth));
  }

  @Override
  public String getPassword() {
    System.out.println("DB에 존재하는 비밀번호 : " + userPw);
    return this.userPw;
  }

  // 시큐리티의 userName
  // -> 따라서 얘는 인증할 때 id를 봄
  @Override
  public String getUsername() {
    return this.userId;
  }

  // Vo의 userName !
  public String getUserName(){
    return this.userName;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
