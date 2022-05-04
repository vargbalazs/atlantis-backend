package api.atlantis.service.impl.app.plantresult;

import api.atlantis.domain.app.plantresult.Booking;
import api.atlantis.repository.interfaces.app.plantresult.BookingRepository;
import api.atlantis.service.interfaces.app.plantresult.BookingService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Long addNew(Booking entity) {
        return null;
    }

    @Override
    public Long update(Booking entity) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }

    @Override
    public List<Booking> getAll() {
        return null;
    }

    @Override
    public List<Booking> getBookings(Long plantId, int year, int month) {
        return bookingRepository.getBookingsByPlantIdAndYearAndMonth(plantId, year, month);
    }

    @Override
    public List<Booking> getBookingsForCostCenter(String costCenter, Long plantId, int year, int month, String accountNumber) {
        return bookingRepository.getBookingsForCostCenter(costCenter, plantId, year, month, accountNumber);
    }

    @Override
    public List<Booking> getBookingsForAccountNumber(String accountNumber, Long plantId, int year, int month) {
        return bookingRepository.getBookingsForAccountNumber(accountNumber, plantId, year, month);
    }
}
