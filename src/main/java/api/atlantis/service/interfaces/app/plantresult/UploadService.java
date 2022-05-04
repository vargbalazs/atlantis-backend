package api.atlantis.service.interfaces.app.plantresult;

import api.atlantis.domain.app.plantresult.Booking;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UploadService {
    void save(MultipartFile file, Long companyId, Long plantId, int year, int month) throws IOException;
    List<Booking> getBookings(Long plantId, int year, int month);
}
