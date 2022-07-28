package vn.com.groupfive.tgdd.payload.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import vn.com.groupfive.tgdd.payload.dto.PromotionDTO;
import vn.com.groupfive.tgdd.payload.entities.Promotion;

@Mapper(componentModel = "spring")
public interface PromotionMapper {
	PromotionDTO promotionToPromotionDto (Promotion promotion);
	
	List<PromotionDTO> promotionToPromotionDtos (List<Promotion> promotions);
}
