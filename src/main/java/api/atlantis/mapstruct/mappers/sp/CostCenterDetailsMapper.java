package api.atlantis.mapstruct.mappers.sp;

import api.atlantis.domain.sp.CostCenterDetails;
import api.atlantis.mapstruct.dto.sp.CostCenterDetailsDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CostCenterDetailsMapper extends BaseMapper<CostCenterDetailsDto, CostCenterDetails> {
    @Override
    @Mapping(target = "costCenter.id", source = "costCenterId")
    @Mapping(target = "costCenter.code", source = "costCenterCode")
    @Mapping(target = "costCenter.name", source = "costCenterName")
    @Mapping(target = "costGroup.id", source = "costGroupId")
    @Mapping(target = "costGroup.name", source = "costGroupName")
    @Mapping(target = "costAccount.id", source = "accountId")
    @Mapping(target = "costAccount.accountNumber", source = "accountNumber")
    @Mapping(target = "costAccount.name", source = "accountName")
    CostCenterDetailsDto toDto(CostCenterDetails costCenterDetails);
}
