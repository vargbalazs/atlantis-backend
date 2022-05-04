package api.atlantis.mapstruct.mappers.user;

import api.atlantis.domain.user.ChangePassword;
import api.atlantis.mapstruct.dto.user.ChangePasswordDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChangePasswordMapper extends BaseMapper<ChangePasswordDto, ChangePassword> {
}
