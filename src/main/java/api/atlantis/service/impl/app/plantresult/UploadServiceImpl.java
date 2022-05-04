package api.atlantis.service.impl.app.plantresult;

import api.atlantis.domain.app.masterdata.general.Company;
import api.atlantis.domain.app.masterdata.general.Plant;
import api.atlantis.domain.app.plantresult.Booking;
import api.atlantis.repository.interfaces.app.masterdata.general.CompanyRepository;
import api.atlantis.repository.interfaces.app.masterdata.general.PlantRepository;
import api.atlantis.repository.interfaces.app.plantresult.BookingRepository;
import api.atlantis.service.interfaces.app.plantresult.UploadService;
import api.atlantis.utility.ExcelHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class UploadServiceImpl implements UploadService {
    private BookingRepository bookingRepository;
    private CompanyRepository companyRepository;
    private PlantRepository plantRepository;

    public UploadServiceImpl(BookingRepository bookingRepository, CompanyRepository companyRepository,
                             PlantRepository plantRepository) {
        this.bookingRepository = bookingRepository;
        this.companyRepository = companyRepository;
        this.plantRepository = plantRepository;
    }

    @Override
    public void save(MultipartFile file, Long companyId, Long plantId, int year, int month) throws IOException {
        Company company = companyRepository.getById(companyId);
        Plant plant = plantRepository.getById(plantId);
        List<Booking> bookings = ExcelHelper.createBookings(file.getInputStream(), company, plant, year, month);
        bookingRepository.saveAll(bookings);
    }

    @Override
    public List<Booking> getBookings(Long plantId, int year, int month) {
        return bookingRepository.getBookingsByPlantIdAndYearAndMonth(plantId, year, month);
    }
}
