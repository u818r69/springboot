package com.example.demo.controller.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Board;
import com.example.demo.service.board.BoardService;

/**
 * つぶやきコントローラクラス
 */
@Controller
@RequestMapping("/board")
public class BoardController {

	// つぶやきサービス
	private final BoardService boardService;

	/**
	 * コンストラクタ
	 */
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	/**
	 * タイムライン画面表示
	 * @param model モデル
	 * @return タイムライン画面
	 */
	@GetMapping("/index")
	public String index(Model model) {
		// つぶやき情報全件取得
		List<Board> boardList = boardService.getAll();
		// ページタイトル設定
		model.addAttribute("title", "タイムライン");
		// つぶやき情報リスト設定
		model.addAttribute("boardList", boardList);

		// タイムライン画面呼び出し
		return "board/index";
	}
	
	/**
	 * つぶやき詳細画面表示
	 * @param model モデル
	 * @return タイムライン画面
	 */
	@GetMapping("/show")
	public String show(int intInput, Model model) {
		// 選択されたつぶやき情報取得
		Board boardList = boardService.getBoard(1);
		// ページタイトル設定
		model.addAttribute("title", "つぶやき詳細");
		// つぶやき情報リスト設定
		model.addAttribute("boardList", boardList);

		// 呟き詳細画面呼び出し
		return "board/show";
		
	}
	

}
