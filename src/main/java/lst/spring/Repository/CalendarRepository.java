package lst.spring.Repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import lst.spring.Entity.Plan;

public interface CalendarRepository extends CrudRepository<Plan, Long>, QuerydslPredicateExecutor<Plan>{
	@Query(value = "select * from plan where plan_date = ?", nativeQuery = true)
	Page<Plan> findbyPlanDate(Pageable pageable, Date date);
	@Query(value = "select * from plan where plan_date = ? and family_code =?", nativeQuery = true)
	Page<Plan> findbyPlanDate(Pageable pageable, Date date, String familyCode);
}
