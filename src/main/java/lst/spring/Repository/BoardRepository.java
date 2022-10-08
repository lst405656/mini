package lst.spring.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lst.spring.Entity.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{
	@Query(value = "select b from board b", nativeQuery = true)
	Page<Board> getBoardList(Pageable pageable);
}
