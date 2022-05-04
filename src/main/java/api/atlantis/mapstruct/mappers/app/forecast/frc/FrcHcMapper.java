package api.atlantis.mapstruct.mappers.app.forecast.frc;

import api.atlantis.domain.app.forecast.frc.FrcHc;
import api.atlantis.mapstruct.dto.app.forecast.frc.FrcHcDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FrcHcMapper extends BaseMapper<FrcHcDto, FrcHc> {
    @Override
    @Mapping(target = "frc.id", source = "frcId")
    @Mapping(target = "hcPlanningItem.id", source = "hcPlanningItemId")
    FrcHc toEntity(FrcHcDto frcHcDto);
}
