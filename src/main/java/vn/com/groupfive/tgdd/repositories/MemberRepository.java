package vn.com.groupfive.tgdd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.groupfive.tgdd.payload.entities.Member;

@Repository

public interface MemberRepository extends JpaRepository<Member, Long>{

	@Query("SELECT m FROM Member m WHERE m.phone = :phone")
	Member getByPhone(@Param("phone") String phone);	
	
	@Query("SELECT CASE WHEN (count(m) > 0) THEN true ELSE false END FROM Member m WHERE m.phone = :phone")
	boolean existsByPhone(@Param("phone") String phone);
	
	
	@Query("SELECT m FROM Member m WHERE m.id = :id")
	Member findMemberById(@Param("id") Long id);
	
}
