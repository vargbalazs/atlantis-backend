package api.atlantis.mapstruct.mappers.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.Plant;
import api.atlantis.mapstruct.dto.app.masterdata.general.PlantDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlantMapper extends BaseMapper<PlantDto, Plant> {
    @Override
    @Mapping(target = "companyId", source = "company.id")
    PlantDto toDto(Plant plant);
}
