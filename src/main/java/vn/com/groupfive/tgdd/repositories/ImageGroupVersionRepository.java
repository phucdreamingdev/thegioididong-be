package vn.com.groupfive.tgdd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.groupfive.tgdd.payload.entities.ImageGroup;
import vn.com.groupfive.tgdd.payload.entities.ImageGroupVersion;

@Repository
public interface ImageGroupVersionRepository extends JpaRepository<ImageGroupVersion, Long>{
	
	ImageGroupVersion findByImageGroupIdAndVersionId(Long groupId, Long versionId);
}
