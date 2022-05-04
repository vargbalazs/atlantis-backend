package api.atlantis.mapstruct.mappers.app.forecast.provk;

import api.atlantis.domain.app.forecast.provk.ProvkVersion;
import api.atlantis.mapstruct.dto.app.forecast.provk.ProvkVersionDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProvkVersionMapper extends BaseMapper<ProvkVersionDto, ProvkVersion> {
    @Override
    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "plantId", source = "plant.id")
    @Mapping(target = "provkId", source = "provk.id")
    ProvkVersionDto toDto(ProvkVersion provkVersion);

    @Override
    @Mapping(target = "company.id", source = "companyId")
    @Mapping(target = "plant.id", source = "plantId")
    @Mapping(target = "provk.id", source = "provkId")
    ProvkVersion toEntity(ProvkVersionDto provkVersionDto);
}
