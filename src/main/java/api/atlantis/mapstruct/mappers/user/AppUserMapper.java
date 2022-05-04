package api.atlantis.mapstruct.mappers.user;

import api.atlantis.domain.user.AppUser;
import api.atlantis.mapstruct.dto.user.AppUserDto;
import api.atlantis.mapstruct.dto.user.AppUserLoginDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppUserMapper extends BaseMapper<AppUserDto, AppUser> {
    AppUser toLoginUser(AppUserLoginDto appUserLoginDto);
}
