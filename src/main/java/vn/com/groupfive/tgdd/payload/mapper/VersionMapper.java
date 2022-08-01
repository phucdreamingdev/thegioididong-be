package vn.com.groupfive.tgdd.payload.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import vn.com.groupfive.tgdd.payload.dto.ColorDTO;
import vn.com.groupfive.tgdd.payload.dto.ColorItemDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductSlimDTO;
import vn.com.groupfive.tgdd.payload.dto.VersionColorItemDTO;
import vn.com.groupfive.tgdd.payload.dto.VersionColorSlimDTO;
import vn.com.groupfive.tgdd.payload.dto.VersionSlimDTO;
import vn.com.groupfive.tgdd.payload.dto.VersionItemDTO;
import vn.com.groupfive.tgdd.payload.entities.Color;
import vn.com.groupfive.tgdd.payload.entities.Product;
import vn.com.groupfive.tgdd.payload.entities.Version;
import vn.com.groupfive.tgdd.payload.entities.VersionColor;

@Mapper(componentModel = "spring")
public interface VersionMapper {
	ColorDTO colorToColorDto(Color color);

	List<ColorDTO> colorsToColorDtos(List<Color> colors);

	VersionColorSlimDTO versionColorToVersionColorSlimDto(VersionColor versionColor);

	List<VersionColorSlimDTO> verionColorsToVersionColorSlimDtos(List<VersionColor> versionColors);

	VersionSlimDTO versionToVersionSlimDto(Version version);

	List<VersionSlimDTO> verionsToVersionSlimDtos(List<Version> versions);

	ColorItemDTO colorToColorSlimDto(Color color);

	List<ColorItemDTO> colorsToColorSlimDtos(List<ColorItemDTO> colors);

	VersionItemDTO versionToVersionItemDto(Version version);

	List<VersionItemDTO> versionsToVersionSlimItemDtos(List<Version> versions);

	VersionColorItemDTO versionColorToVersionColorItemDto(VersionColor versionColor);

	List<VersionColorItemDTO> versionColorsToVersionColorItemDtos(List<VersionColor> versionColors);
	
	ProductSlimDTO productToProductSlimDto(Product product);
	
	List<ProductSlimDTO> productsToProductSlimDtos(List<Product> products);

}
