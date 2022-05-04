package api.atlantis.mapstruct.mappers;

import java.util.List;

public interface BaseMapper<Dto, Entity> {
    Dto toDto(Entity entity);
    Entity toEntity(Dto dto);
    List<Dto> toListDto(List<Entity> entities);
    List<Entity> toListEntity(List<Dto> dtos);
}
