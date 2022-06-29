package co.kr.db.security.service;

import co.kr.db.security.service.impl.UserMapper;
import co.kr.db.security.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService{
/*  SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:sss");
  Date time = new Date();
  String localTime = format.format(time);*/

  private final UserMapper userMapper;

/*  @Transactional
  public void joinUser(UserVo userVo){
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    userVo.setUserPw(passwordEncoder.encode(userVo.getPassword()));
    userVo.setUserAuth("USER");
    userVo.setAppendDate(localTime);
    userVo.setUpdateDate(localTime);
    userMapper.saveUser(userVo);
  }*/

  @Override
  public UserVo loadUserByUsername(String userId) throws UsernameNotFoundException {
    int a = userMapper.getCount(userId);
    System.out.println("일치하는 계정 갯수 : " + a);
    //여기서 받은 유저 패스워드와 비교하여 로그인 인증
    UserVo userVo = userMapper.getUserAccount(userId);
    System.out.println("로그인 시도 : " + userId);
    if (userVo == null){
      System.out.println("없는 아이디 : " + userId);
      throw new UsernameNotFoundException("User not authorized.");
    }
    return userVo;
  }
}
