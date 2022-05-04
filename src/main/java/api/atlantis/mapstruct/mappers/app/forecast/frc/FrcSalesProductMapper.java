package api.atlantis.mapstruct.mappers.app.forecast.frc;

import api.atlantis.domain.app.forecast.frc.FrcSalesProduct;
import api.atlantis.mapstruct.dto.app.forecast.frc.FrcSalesProductDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FrcSalesProductMapper extends BaseMapper<FrcSalesProductDto, FrcSalesProduct> {
    @Override
    @Mapping(target = "frc.id", source = "frcId")
    @Mapping(target = "salesProduct.id", source = "salesProductId")
    FrcSalesProduct toEntity(FrcSalesProductDto frcSalesProductDto);
}
