package api.atlantis.mapstruct.mappers.sp;

import api.atlantis.domain.sp.PlantPl;
import api.atlantis.mapstruct.dto.sp.PlantPlDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlantPlMapper extends BaseMapper<PlantPlDto, PlantPl> {
    @Override
    @Mapping(target = "costGroup.id", source = "costGroupId")
    @Mapping(target = "costGroup.name", source = "costGroupName")
    @Mapping(target = "costGroup.rowIndex", source = "rowIndex")
    @Mapping(target = "costAccount.id", source = "accountId")
    @Mapping(target = "costAccount.accountNumber", source = "accountNumber")
    @Mapping(target = "costAccount.name", source = "accountName")
    PlantPlDto toDto(PlantPl plantPl);
}
