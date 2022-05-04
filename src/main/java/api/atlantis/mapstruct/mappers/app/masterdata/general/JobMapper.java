package api.atlantis.mapstruct.mappers.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.Job;
import api.atlantis.mapstruct.dto.app.masterdata.general.JobDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JobMapper extends BaseMapper<JobDto, Job> {
    @Override
    @Mapping(target = "plant", source = "department.plant")
    @Mapping(target = "company", source = "department.plant.company")
    @Mapping(target = "depId", source = "department.id")
    JobDto toDto(Job job);
}
