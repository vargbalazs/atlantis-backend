package api.atlantis.mapstruct.mappers.app.plantresult;

import api.atlantis.domain.app.plantresult.Booking;
import api.atlantis.mapstruct.dto.app.plantresult.BookingDto;
import api.atlantis.mapstruct.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper extends BaseMapper<BookingDto, Booking> {
    @Override
    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "plantId", source = "plant.id")
    BookingDto toDto(Booking booking);
}
