package api.atlantis.mapstruct.mappers.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.Company;
import api.atlantis.mapstruct.dto.app.masterdata.general.CompanyDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends BaseMapper<CompanyDto, Company> {

}
