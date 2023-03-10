package com.example.demo.dao.board;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Board;

/**
 * つぶやきDaoクラス
 */
@Repository
public class BoardDaoImpl implements BoardDao {

	// JdbcTemplate
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public BoardDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Board> findAll() {
		// sql定義
		String sql = "select id, title, content, updated_at from boards order by updated_at desc";
		// sql実行
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);

		// sql実行結果をBoardエンティティへ詰め替え
		List<Board> list = new ArrayList<Board>();
		for (Map<String, Object> result : resultList) {
			Board board = new Board();
			board.setId((int) result.get("id")); // id
			board.setTitle((String) result.get("title")); // タイトル
			board.setContent((String) result.get("content")); // つぶやき
			board.setUpdatedAt(((Timestamp) result.get("updated_at")).toLocalDateTime()); // 更新日

			list.add(board);
		}

		return list;
	}
	
	@Override
	public Board findById(int intInput) {
		// sql定義
		String sql = "select id, title, content from boards where id = 3";
		// sql実行
		Map<String, Object> resultList = jdbcTemplate.queryForMap(sql);	
		
		// sql実行結果をBoardエンティティへ詰め替え
		Map<Board> board = new ArrayList<Board>();
		for (Map<String, Object> result : resultList) {
			Board board = new Board();
			board.setId((int) result.get("id")); // id
			board.setTitle((String) result.get("title")); // タイトル
			board.setContent((String) result.get("content")); // つぶやき

			list2.add(board);
		}

		return list2;
	}
}
