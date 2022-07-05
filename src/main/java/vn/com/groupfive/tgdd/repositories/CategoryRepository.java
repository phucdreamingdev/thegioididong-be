package vn.com.groupfive.tgdd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.groupfive.tgdd.payload.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
}
