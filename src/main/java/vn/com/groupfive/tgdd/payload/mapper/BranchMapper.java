package vn.com.groupfive.tgdd.payload.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import vn.com.groupfive.tgdd.payload.dto.BranchSlimResponeDTO;
import vn.com.groupfive.tgdd.payload.entities.Branch;

@Mapper(componentModel = "spring")
public interface BranchMapper {
	
	BranchSlimResponeDTO branchToBranchSlimResponeDto(Branch branch);

	List<BranchSlimResponeDTO> branchsToBranchSlimResponeDtos(List<Branch> branchs);
}
