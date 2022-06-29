package co.kr.db.security.service.impl;

import co.kr.db.security.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
  // 로그인
  UserVo getUserAccount(String userId);
  // 회원가입
  // void saveUser(UserVo userVo);

  public int getCount(String userId);
}
