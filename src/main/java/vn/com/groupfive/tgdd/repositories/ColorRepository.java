package vn.com.groupfive.tgdd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.groupfive.tgdd.payload.entities.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {
	Color findByName(String name);
}
