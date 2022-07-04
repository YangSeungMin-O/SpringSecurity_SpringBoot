package co.kr.db.security.service.impl;

import co.kr.db.security.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserMapper {
  // 로그인
  UserVo getUserAccount(String userId);
  public int getCount(String userAuth, String userUrl);
}
