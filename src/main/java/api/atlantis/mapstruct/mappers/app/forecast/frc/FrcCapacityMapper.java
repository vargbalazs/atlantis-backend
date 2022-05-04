package api.atlantis.mapstruct.mappers.app.forecast.frc;

import api.atlantis.domain.app.forecast.frc.FrcCapacity;
import api.atlantis.mapstruct.dto.app.forecast.frc.FrcCapacityDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FrcCapacityMapper extends BaseMapper<FrcCapacityDto, FrcCapacity> {
    @Override
    @Mapping(target = "frc.id", source = "frcId")
    @Mapping(target = "capGroup.id", source = "capGroupId")
    FrcCapacity toEntity(FrcCapacityDto frcCapacityDto);
}
