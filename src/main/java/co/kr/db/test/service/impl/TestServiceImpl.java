package co.kr.db.test.service.impl;

import co.kr.db.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
  @Autowired
  TestMapper mapper;
  @Override
  public int getCount() {
    return mapper.getCount();
  }
}
