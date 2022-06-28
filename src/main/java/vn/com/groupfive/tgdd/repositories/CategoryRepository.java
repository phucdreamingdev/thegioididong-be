package vn.com.groupfive.tgdd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.com.groupfive.tgdd.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>, CrudRepository<Category, Integer>{
}
