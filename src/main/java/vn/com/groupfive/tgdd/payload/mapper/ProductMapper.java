package vn.com.groupfive.tgdd.payload.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import vn.com.groupfive.tgdd.payload.dto.ProductDTO;
import vn.com.groupfive.tgdd.payload.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	ProductDTO productToProductDto (Product product);
	List<ProductDTO> productsToProductDtos(List<Product> products);
	
}
