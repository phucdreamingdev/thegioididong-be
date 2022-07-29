package vn.com.groupfive.tgdd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.groupfive.tgdd.payload.entities.AdminAccount;

@Repository
public interface AdminAccountRepository extends JpaRepository<AdminAccount, Long>{
	AdminAccount getAdminAccountByUserName(@Param("username") String username);
	
	AdminAccount getAdminAccountByUserNameAndPassword(@Param("username") String username, @Param("password") String password);
}
