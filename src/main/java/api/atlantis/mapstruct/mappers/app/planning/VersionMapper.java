package api.atlantis.mapstruct.mappers.app.planning;

import api.atlantis.domain.app.planning.Version;
import api.atlantis.mapstruct.dto.app.planning.VersionDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VersionMapper extends BaseMapper<VersionDto, Version> {
    @Override
    @Mapping(target = "costAccTypeId", source = "costAccType.id")
    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "plantId", source = "plant.id")
    VersionDto toDto(Version version);
}
