package api.atlantis.mapstruct.mappers.app.forecast.provk;

import api.atlantis.domain.app.forecast.provk.SalesDetail;
import api.atlantis.mapstruct.dto.app.forecast.provk.SalesDetailDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SalesDetailMapper extends BaseMapper<SalesDetailDto, SalesDetail> {
    @Override
    @Mapping(target = "capGroup.id", source = "capGroupId")
    @Mapping(target = "salesProduct.id", source = "salesProductId")
    @Mapping(target = "provk.id", source = "provkId")
    SalesDetail toEntity(SalesDetailDto salesDetailDto);
}
