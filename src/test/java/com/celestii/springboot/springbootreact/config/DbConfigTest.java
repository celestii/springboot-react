package com.celestii.springboot.springbootreact.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DbConfigTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testConnection() {
        try (Connection con = dataSource.getConnection()) {
            log.info("success testConnection");
            log.info(String.valueOf(con));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testMyBatis() {
        try(SqlSession session = sqlSessionFactory.openSession();
        Connection con = session.getConnection();) {
            log.info(session.toString());
            log.info(con.toString());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
