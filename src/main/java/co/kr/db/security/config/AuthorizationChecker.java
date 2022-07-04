package co.kr.db.security.config;

import co.kr.db.security.service.impl.UserMapper;
import co.kr.db.security.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
  public class AuthorizationChecker {

    @Autowired
    private UserMapper mapper;

    public boolean check(HttpServletRequest request, Authentication authentication)
        throws IOException {
      try {
        UserVo user = (UserVo) authentication.getPrincipal();
        String userAuth = user.getUserAuth().toString();
        String userUrl = request.getRequestURI().toString();
        System.out.println(userUrl);
        int cnt = mapper.getCount(userAuth, userUrl);
        if(cnt >= 1) {
          return true;
        }
      }catch(Exception e){
        return false;
      }
      return false;

      // user.get 를 사용하여 권한을 받아온다 권한을 auth 라고 지정
      //String auth = "";

      // auth 가 사용자가 요청한 url 에 접근 권한이 있는지 디비에서 조회
      // 쿼리
      // SELECT count(*) FROM 메뉴 WHERE #{사용자 권한 } = 메뉴에 있는권한 AND #{사용자가 요청한 url} == 메뉴에 있는 url
      // 경과값을 cnt 라는 곳에담아다고 가정

    }
  }

