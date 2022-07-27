package vn.com.groupfive.tgdd.payload.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import vn.com.groupfive.tgdd.payload.dto.BranchSlimResponeDTO;
import vn.com.groupfive.tgdd.payload.dto.DistrictDTO;
import vn.com.groupfive.tgdd.payload.dto.ProvinceDTO;
import vn.com.groupfive.tgdd.payload.dto.WardDTO;
import vn.com.groupfive.tgdd.payload.entities.Branch;
import vn.com.groupfive.tgdd.payload.entities.District;
import vn.com.groupfive.tgdd.payload.entities.Province;
import vn.com.groupfive.tgdd.payload.entities.Ward;

@Mapper(componentModel = "spring")
public interface BranchMapper {
	ProvinceDTO provinceToProvinceDto(Province province);
	List<ProvinceDTO> provincesToProvinceDtos(List<ProvinceDTO> provinces);
	
	DistrictDTO districtTDistrictDto(District district);
	List<DistrictDTO> districtsToDistrictDtos(List<DistrictDTO> districts);
	
	WardDTO wardToWardDto(Ward ward);
	List<WardDTO> wardsToWardDtos(List<WardDTO> wards);
	
	BranchSlimResponeDTO branchToBranchSlimResponeDto(Branch branch);
	List<BranchSlimResponeDTO> branchsToBranchSlimResponeDtos(List<Branch> branchs);
}