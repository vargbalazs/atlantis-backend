package api.atlantis.mapstruct.mappers.app.masterdata.general;

import api.atlantis.domain.app.masterdata.general.Language;
import api.atlantis.mapstruct.dto.app.masterdata.general.LanguageDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LanguageMapper extends BaseMapper<LanguageDto, Language> {
}
