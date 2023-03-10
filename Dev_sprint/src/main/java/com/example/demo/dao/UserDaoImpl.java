package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
	public UserDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

    @Override
    public List<User> findAll() {
		String sql = "SELECT id, name, email FROM users";

		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);

		// Userリスト定義
		List<User> userList = new ArrayList<User>();
		// resultListをUserリストへ詰め替え
		for (Map<String, Object> map : resultList) {
			// Userインタンス定義
			User user = new User();
			// Userインタンスへ取得データ設定
			user.setId((int) map.get("id"));
			user.setName((String) map.get("name"));
			user.setEmail((String) map.get("email"));
			// UserインタンスをUserリストへ追加
			userList.add(user);
		}

        return userList;
    };
}
