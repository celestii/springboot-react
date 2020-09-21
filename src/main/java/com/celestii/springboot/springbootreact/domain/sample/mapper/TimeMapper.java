package com.celestii.springboot.springbootreact.domain.sample.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
    @Select("SELECT NOW() FROM DUAL")
    public String getTime();
    public String getTime2();
}
