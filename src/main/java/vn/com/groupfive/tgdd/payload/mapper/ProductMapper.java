package vn.com.groupfive.tgdd.payload.mapper;

import org.mapstruct.Mapper;

import vn.com.groupfive.tgdd.payload.dto.ProductSlimDTO;
import vn.com.groupfive.tgdd.payload.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	ProductSlimDTO productToProductSlimDTO (Product product);
}
