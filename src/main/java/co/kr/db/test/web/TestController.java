package co.kr.db.test.web;

import co.kr.db.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {
  @Autowired
  TestService service;

/*  @GetMapping(value = "/")
  public void Test() {
    int a = service.getCount();
    System.out.println(a);
  }*/
}
