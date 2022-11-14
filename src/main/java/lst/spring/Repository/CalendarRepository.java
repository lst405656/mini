package lst.spring.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import lst.spring.Entity.Plan;

public interface CalendarRepository extends CrudRepository<Plan, Long>, QuerydslPredicateExecutor<Plan>{
	@Query(value = "select * from plan", nativeQuery = true)
	Page<Plan> getPlanList(Pageable pageable);
}
