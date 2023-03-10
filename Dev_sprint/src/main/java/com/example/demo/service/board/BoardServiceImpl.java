package com.example.demo.service.board;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.board.BoardDao;
import com.example.demo.entity.Board;

/**
 * つぶやきサービスクラス
 */
@Service
public class BoardServiceImpl implements BoardService {

	// つぶやきDao
	private BoardDao boardDao;

	/**
	 * コンストラクタ
	 * 
	 * @param boardDao つぶやきDao
	 */
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<Board> getAll() {
		return boardDao.findAll();
	};
	
	/**
	 * コンストラクタ
	 * 
	 * @param boardDao つぶやきDao
	 */
	@Override
	public Board getBoard(int intInput) {
		return boardDao.findById(1);
	}
	
}
