package api.atlantis.mapstruct.mappers.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostGroup;
import api.atlantis.mapstruct.dto.app.masterdata.planning.CostGroupDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CostGroupMapper extends BaseMapper<CostGroupDto, CostGroup> {
    @Override
    @Mapping(target = "companyId", source = "company.id")
    CostGroupDto toDto(CostGroup costGroup);
}
