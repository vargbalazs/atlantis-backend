package api.atlantis.mapstruct.mappers.app.forecast.frc;

import api.atlantis.domain.app.forecast.frc.FrcOtherCost;
import api.atlantis.mapstruct.dto.app.forecast.frc.FrcOtherCostDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FrcOtherCostMapper extends BaseMapper<FrcOtherCostDto, FrcOtherCost> {
    @Override
    @Mapping(target = "costAccId", source = "costAccount.id")
    @Mapping(target = "costAccName", source = "costAccount.name")
    @Mapping(target = "costCenterId", source = "costCenter.id")
    @Mapping(target = "frcId", source = "frc.id")
    @Mapping(target = "costAccountReducedDto", source = "costAccount")
    @Mapping(target = "costCenterReducedDto", source = "costCenter")
    FrcOtherCostDto toDto(FrcOtherCost frcOtherCost);

    @Override
    @Mapping(target = "costAccount.id", source = "costAccId")
    @Mapping(target = "costCenter.id",source = "costCenterId")
    @Mapping(target = "frc.id", source = "frcId")
    FrcOtherCost toEntity(FrcOtherCostDto frcOtherCostDto);
}
