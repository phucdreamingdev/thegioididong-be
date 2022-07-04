package vn.com.groupfive.tgdd.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.com.groupfive.tgdd.entities.Manufacturer;

@Repository
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long>{
	
}
