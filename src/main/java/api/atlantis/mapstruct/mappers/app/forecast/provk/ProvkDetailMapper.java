package api.atlantis.mapstruct.mappers.app.forecast.provk;

import api.atlantis.domain.app.forecast.provk.ProvkDetail;
import api.atlantis.mapstruct.dto.app.forecast.provk.ProvkDetailDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProvkDetailMapper extends BaseMapper<ProvkDetailDto, ProvkDetail> {
    @Override
    @Mapping(target = "capGroup.id", source = "capGroupId")
    @Mapping(target = "provk.id", source = "provkId")
    ProvkDetail toEntity(ProvkDetailDto provkDetailDto);
}
