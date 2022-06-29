package co.kr.db.test.service.impl;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface TestMapper {
  public int getCount();
}
