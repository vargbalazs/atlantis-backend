package api.atlantis.mapstruct.mappers.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostAccount;
import api.atlantis.mapstruct.dto.app.masterdata.planning.CostAccountDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CostAccountMapper extends BaseMapper<CostAccountDto, CostAccount> {
    @Override
    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "costGroupId", source = "costGroup.id")
    CostAccountDto toDto(CostAccount costAccount);
}
