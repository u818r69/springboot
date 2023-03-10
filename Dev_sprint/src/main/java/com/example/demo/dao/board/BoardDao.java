package com.example.demo.dao.board;

import java.util.List;

import com.example.demo.entity.Board;

/**
 * つぶやきDaoインターフェース
 */
public interface BoardDao {

	/**
	 * つぶやき情報全件取得
	 * 
	 * @return つぶやき情報リスト
	 */
	List<Board> findAll();
	
	/**
	 * つぶやきレコード1件取得
	 * 
	 * @return つぶやき情報リスト
	 */
	Board findById(int intInput);
}
