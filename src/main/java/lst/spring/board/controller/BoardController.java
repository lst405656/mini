package lst.spring.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lst.spring.Entity.Board;
import lst.spring.Entity.Search;
import lst.spring.board.service.BoardService;
import lst.spring.security.SecurityUser;

@Controller
@RequestMapping("/board/")
public class BoardController {
	@Autowired
	private BoardService boardService;
	@GetMapping("/getBoardList")
	public String getBoardList(Model model, Board board, Search search, @RequestParam(value="page", defaultValue="0")int page) {
		Page<Board> boardList = boardService.getBoardList(board, page);
		model.addAttribute("boardList", boardList);
		return "board/getBoardList";
	}
	@PostMapping("/getBoardList")
	public String getSearchList(Model model, Search search) {
		Page<Board> searchList = boardService.getBoardList(search);
		model.addAttribute("boardList", searchList);
		return "board/getBoardList";
	}
	
	@RequestMapping("/getBoard")
	public String getBoard(Model model, Board board) {
		model.addAttribute("board", boardService.getBoard(board));
		return "board/getBoard";
	}
	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "board/insertBoard";
	}
	@PostMapping("/insertBoard")
	public String insertBoard(Board board, @AuthenticationPrincipal SecurityUser principal) {
		board.setUser(principal.getUser());
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
}