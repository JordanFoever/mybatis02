package com.softeem.mybatis;

import com.softeem.mybatis.entity.User;
import com.softeem.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    public static void main(String[] args) throws IOException {
        //        从 XML 中构建 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlsession
        SqlSession session = sqlSessionFactory.openSession(true);

        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> list = mapper.selectAll();
        list.forEach(System.out::println);
    }
}
