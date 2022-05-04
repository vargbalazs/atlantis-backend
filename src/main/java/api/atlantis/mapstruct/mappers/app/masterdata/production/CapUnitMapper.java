package api.atlantis.mapstruct.mappers.app.masterdata.production;

import api.atlantis.domain.app.masterdata.production.CapUnit;
import api.atlantis.mapstruct.dto.app.masterdata.production.CapUnitDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CapUnitMapper extends BaseMapper<CapUnitDto, CapUnit> {
    @Override
    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "plantId", source = "plant.id")
    CapUnitDto toDto(CapUnit capUnit);
}
