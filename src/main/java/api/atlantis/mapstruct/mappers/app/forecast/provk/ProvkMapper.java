package api.atlantis.mapstruct.mappers.app.forecast.provk;

import api.atlantis.domain.app.forecast.provk.Provk;
import api.atlantis.mapstruct.dto.app.forecast.provk.ProvkDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProvkMapper extends BaseMapper<ProvkDto, Provk> {
    @Override
    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "plantId", source = "plant.id")
    ProvkDto toDto(Provk provk);

    @Override
    @Mapping(target = "company.id", source = "companyId")
    @Mapping(target = "plant.id", source = "plantId")
    Provk toEntity(ProvkDto provkDto);
}
