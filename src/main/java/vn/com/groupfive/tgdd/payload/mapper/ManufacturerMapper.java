package vn.com.groupfive.tgdd.payload.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import vn.com.groupfive.tgdd.payload.dto.CategorySlimDTO;
import vn.com.groupfive.tgdd.payload.dto.ManufacturerDTO;
import vn.com.groupfive.tgdd.payload.entities.Category;
import vn.com.groupfive.tgdd.payload.entities.Manufacturer;

@Mapper(componentModel = "spring")
public interface ManufacturerMapper {
	ManufacturerDTO manufacturerToManufacturerDTO(Manufacturer manufacturer);

	List<ManufacturerDTO> manufacturersToManufacturerDTOs(List<Manufacturer> manufacturers);
}
