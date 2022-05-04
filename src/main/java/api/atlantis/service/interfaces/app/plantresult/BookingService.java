package api.atlantis.service.interfaces.app.plantresult;

import api.atlantis.domain.app.plantresult.Booking;
import api.atlantis.service.interfaces.BaseCrudService;

import java.util.List;

public interface BookingService extends BaseCrudService<Booking> {
    List<Booking> getBookings(Long plantId, int year, int month);
    List<Booking> getBookingsForCostCenter(String costCenter, Long plantId, int year, int month, String accountNumber);
    List<Booking> getBookingsForAccountNumber(String accountNumber, Long plantId, int year, int month);
}
