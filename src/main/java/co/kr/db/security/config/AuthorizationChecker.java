package co.kr.db.security.config;

import co.kr.db.security.service.impl.UserMapper;
import co.kr.db.security.vo.UserVo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthorizationChecker {

  private UserMapper mapper;

  public boolean check(HttpServletRequest request, Authentication authentication) {
    System.out.println(request.getRequestURI());
    //URL은 전체 주소를 뱉음 ex)"http://localhost:8080/successPage"
    //System.out.println(request.getRequestURL());

/*  Object principal = authentication.getPrincipal();
    UserVo userVo = (UserVo)principal;*/

    /* 현재 UserVo타입으로의 형변환이 안되는 문제가 있음 */
    /* 형변환이 완료되면 로그인한 사용자의 USER_ID 꺼내오고 해당 USER_ID로 접근가능한 URL을 모두 DB에서 뽑아올거임 */
    /* 뽑아온 URL을 현재 요청된 URL과 일치하는게 있는지 반복문을 돌려서 확인하고 있으면 True 없으면 False로 Return */
    return true;
  }
}

/*
  @Component
  public class AuthorizationChecker {

    public boolean check(HttpServletRequest request, Authentication authentication) {
      UserVO user = (UserVO) authentication.getPrincipal();

      // user.get 를 사용하여 권한을 받아온다 권한을 auth 라고 지정
      String auth = "";

      // auth 가 사용자가 요청한 url 에 접근 권한이 있는지 디비에서 조회
      // 쿼리
      // SELECT count(*) FROM 메뉴 WHERE #{사용자 권한 } = 메뉴에 있는권한 AND #{사용자가 요청한 url} == 메뉴에 있는 url
      // 경과값을 cnt 라는 곳에담아다고 가정
      int cnt = 0;
      if(cnt > 1) {
        return true;
      } else{
        return false;
      }
    }
  }
*/

