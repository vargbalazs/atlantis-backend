package api.atlantis.mapstruct.mappers.app.production;

import api.atlantis.domain.app.production.ActualCapacity;
import api.atlantis.mapstruct.dto.app.production.ActualCapacityDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ActualCapacityMapper extends BaseMapper<ActualCapacityDto, ActualCapacity> {
    @Override
    @Mapping(target = "company.id", source = "companyId")
    @Mapping(target = "plant.id", source = "plantId")
    @Mapping(target = "capGroup.id", source = "capGroupId")
    ActualCapacity toEntity(ActualCapacityDto actualCapacityDto);
}
