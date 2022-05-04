package api.atlantis.mapstruct.mappers.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.Department;
import api.atlantis.mapstruct.dto.app.masterdata.general.DepartmentDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepartmentMapper extends BaseMapper<DepartmentDto, Department> {
    @Override
    @Mapping(target = "company", source = "plant.company")
    @Mapping(target = "plantId", source = "plant.id")
    DepartmentDto toDto(Department department);
}
