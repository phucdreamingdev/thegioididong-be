package vn.com.groupfive.tgdd.payload.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import vn.com.groupfive.tgdd.payload.dto.DistrictDTO;
import vn.com.groupfive.tgdd.payload.dto.ProvinceDTO;
import vn.com.groupfive.tgdd.payload.dto.WardDTO;
import vn.com.groupfive.tgdd.payload.entities.District;
import vn.com.groupfive.tgdd.payload.entities.Province;
import vn.com.groupfive.tgdd.payload.entities.Ward;

@Mapper(componentModel = "spring")
public interface AddressMapper {
	ProvinceDTO provinceToProvinceDto(Province province);

	List<ProvinceDTO> provincesToProvinceDtos(List<Province> provinces);

	DistrictDTO districtTDistrictDto(District district);

	List<DistrictDTO> districtsToDistrictDtos(List<District> districts);

	WardDTO wardToWardDto(Ward ward);

	List<WardDTO> wardsToWardDtos(List<Ward> wards);
}
