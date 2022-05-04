package api.atlantis.mapstruct.mappers.app.masterdata.planning;

import api.atlantis.domain.app.masterdata.planning.CostResp;
import api.atlantis.mapstruct.dto.app.masterdata.planning.CostRespDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CostRespMapper extends BaseMapper<CostRespDto, CostResp> {
    @Override
    @Mapping(target = "langId", source = "lang.id")
    @Mapping(target = "depId", source = "department.id")
    @Mapping(target = "jobId", source = "job.id")
    @Mapping(target = "costCenterId", source = "costCenter.id")
    CostRespDto toDto(CostResp costResp);
}
