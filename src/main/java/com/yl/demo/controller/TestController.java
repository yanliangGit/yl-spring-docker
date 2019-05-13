package com.yl.demo.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yl.demo.vo.User;

@RestController
public class TestController {

	@Resource
	private JdbcTemplate jdbcTemplate;

	@RequestMapping("/userlist")
    public List<User> getUserList(){
        String sql = "SELECT * FROM user";
        List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {
            User user = null;
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setSex(rs.getString("sex"));
                user.setAge(rs.getString("age"));
                return user;
            }
        });
		for(User user:userList){
				System.out.println(user.getName());
		}
			
		return userList;
	}
}
