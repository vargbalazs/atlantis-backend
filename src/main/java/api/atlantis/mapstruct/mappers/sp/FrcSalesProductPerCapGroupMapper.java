package api.atlantis.mapstruct.mappers.sp;

import api.atlantis.domain.sp.FrcSalesProductPerCapGroup;
import api.atlantis.mapstruct.dto.sp.FrcSalesProductPerCapGroupDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FrcSalesProductPerCapGroupMapper extends BaseMapper<FrcSalesProductPerCapGroupDto, FrcSalesProductPerCapGroup> {
}
