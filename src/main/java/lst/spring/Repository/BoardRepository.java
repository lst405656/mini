package lst.spring.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import lst.spring.Entity.Board;

public interface BoardRepository extends CrudRepository<Board, Long>, QuerydslPredicateExecutor<Board>{
	@Query(value = "select * from board", nativeQuery = true)
	Page<Board> getBoardList(Pageable pageable);
}
