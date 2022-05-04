package api.atlantis.mapstruct.mappers.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostAccountingType;
import api.atlantis.mapstruct.dto.app.masterdata.planning.CostAccountingTypeDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CostAccountingTypeMapper extends BaseMapper<CostAccountingTypeDto, CostAccountingType> {
}
