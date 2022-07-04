package vn.com.groupfive.tgdd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.groupfive.tgdd.entities.AdminAccount;

@Repository
public interface AdminAccountRepository extends JpaRepository<AdminAccount, Long>{

}
