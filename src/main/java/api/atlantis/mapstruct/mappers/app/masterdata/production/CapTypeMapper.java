package api.atlantis.mapstruct.mappers.app.masterdata.production;

import api.atlantis.domain.app.masterdata.production.CapType;
import api.atlantis.mapstruct.dto.app.masterdata.production.CapTypeDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CapTypeMapper extends BaseMapper<CapTypeDto, CapType> {
    @Override
    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "plantId", source = "plant.id")
    CapTypeDto toDto(CapType capType);
}
