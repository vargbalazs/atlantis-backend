package api.atlantis.mapstruct.mappers.app.forecast.frc;

import api.atlantis.domain.app.forecast.frc.Frc;
import api.atlantis.mapstruct.dto.app.forecast.frc.FrcDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FrcMapper extends BaseMapper<FrcDto, Frc> {
    @Override
    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "plantId", source = "plant.id")
    @Mapping(target = "costAccTypeId", source = "costAccType.id")
    FrcDto toDto(Frc frc);
}
