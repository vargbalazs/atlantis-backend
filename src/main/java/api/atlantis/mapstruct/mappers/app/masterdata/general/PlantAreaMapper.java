package api.atlantis.mapstruct.mappers.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.PlantArea;
import api.atlantis.mapstruct.dto.app.masterdata.general.PlantAreaDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlantAreaMapper extends BaseMapper<PlantAreaDto, PlantArea> {
    @Override
    @Mapping(target = "company", source = "plant.company")
    @Mapping(target = "plantId", source = "plant.id")
    PlantAreaDto toDto(PlantArea plantArea);
}
