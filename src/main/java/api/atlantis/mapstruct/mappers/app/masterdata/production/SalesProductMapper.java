package api.atlantis.mapstruct.mappers.app.masterdata.production;

import api.atlantis.domain.app.masterdata.production.SalesProduct;
import api.atlantis.mapstruct.dto.app.masterdata.production.SalesProductDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SalesProductMapper extends BaseMapper<SalesProductDto, SalesProduct> {
    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "plantId", source = "plant.id")
    @Mapping(target = "capGroupId", source = "capGroup.id")
    @Mapping(target = "unitId", source = "unit.id")
    SalesProductDto toDto(SalesProduct salesProduct);
}
