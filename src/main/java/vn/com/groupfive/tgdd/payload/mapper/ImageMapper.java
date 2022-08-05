package vn.com.groupfive.tgdd.payload.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import vn.com.groupfive.tgdd.payload.dto.ImageDTO;
import vn.com.groupfive.tgdd.payload.dto.ImageGroupDTO;
import vn.com.groupfive.tgdd.payload.dto.ImageGroupItemDTO;
import vn.com.groupfive.tgdd.payload.dto.ImageGroupVersionDTO;
import vn.com.groupfive.tgdd.payload.entities.Image;
import vn.com.groupfive.tgdd.payload.entities.ImageGroup;
import vn.com.groupfive.tgdd.payload.entities.ImageGroupVersion;

@Mapper(componentModel = "spring")
public interface ImageMapper {
	ImageGroupVersionDTO imageGroupVersionToImageGroupVersionDto (ImageGroupVersion imageGroupVersion);
	
	List<ImageGroupVersionDTO> imageGroupVersionsToImageGroupVersionDtos (List<ImageGroupVersion> imageGroupVersions);
	
	ImageDTO imageToImagDto (Image image);
	
	List<ImageDTO> imagesToImageDtos(List<Image> images);
	
	ImageGroupItemDTO imageGroupToImageGroupItemDto (ImageGroup imageGroup);
	
	List<ImageGroupItemDTO> imageGroupsToImageGroupItemDtos(List<ImageGroup> imageGroups);
	
	ImageGroupDTO imageGroupToImageGroupDto(ImageGroup imageGroup);
	
	List<ImageGroupDTO> imageGroupsToImageGroupDtos(List<ImageGroup> imageGroups);
}
