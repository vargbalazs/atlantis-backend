package api.atlantis.mapstruct.mappers.sp;

import api.atlantis.domain.sp.SalesDetailPerSalesProduct;
import api.atlantis.mapstruct.dto.sp.SalesDetailPerSalesProductDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SalesDetailPerSalesProductMapper extends BaseMapper<SalesDetailPerSalesProductDto, SalesDetailPerSalesProduct> {
}
