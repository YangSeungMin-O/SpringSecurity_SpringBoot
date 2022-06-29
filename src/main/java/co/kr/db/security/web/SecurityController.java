package co.kr.db.security.web;

import co.kr.db.security.vo.UserVo;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

  @RequestMapping(value = "/loginPage")
  public String loginPage() {
    return "/loginPage.html";
  }
  @RequestMapping(value = "/")
  public String mainPage() {
    return "/mainPage.html";
  }
  @RequestMapping(value = "/successPage")
  public String successPage(Model model, Authentication authentication) {
    //Authentication 객체를 통해 유저 정보를 가져올 수 있다.
    UserVo userVo = (UserVo) authentication.getPrincipal();  //userDetail 객체를 가져옴
    model.addAttribute("info", userVo.getUserId() +"의 "+ userVo.getUserName()+ "님");      //유저 아이디
    return "/successPage.html";
  }
  @RequestMapping(value = "/failurePage")
  public String failurePage() {
    return "/failurePage.html";
  }
}
