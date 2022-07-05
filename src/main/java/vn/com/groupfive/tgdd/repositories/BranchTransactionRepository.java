package vn.com.groupfive.tgdd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.groupfive.tgdd.payload.entities.BranchTransaction;

@Repository
public interface BranchTransactionRepository extends JpaRepository<BranchTransaction, Long>{

}
