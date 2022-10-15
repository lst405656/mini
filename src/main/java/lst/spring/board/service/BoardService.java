package lst.spring.board.service;

import org.springframework.data.domain.Page;

import lst.spring.Entity.Board;
import lst.spring.Entity.Search;

public interface BoardService {
	void insertBoard(Board board);
	void updateBoard(Board board);
	void deleteBoard(Board board);
	Board getBoard(Board board);
	Page<Board> getBoardList(Board board);
	Page<Board> getBoardList(Search search);
}