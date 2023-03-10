package com.example.demo.service.board;

import java.util.List;

import com.example.demo.entity.Board;

/**
 * つぶやきサービスインターフェース
 */
public interface BoardService {
	/**
	 * つぶやき情報全件取得
	 * 
	 * @return つぶやき情報情報リスト
	 */
	List<Board> getAll();
	
	/**
	 * つぶやきレコード1件取得
	 * 
	 * @return つぶやき情報情報リスト
	 */	
	Board getBoard(int intInput);
}
