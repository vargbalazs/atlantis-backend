package api.atlantis.resource.app.plantresult;

import api.atlantis.domain.app.plantresult.Booking;
import api.atlantis.exception.domain.ExceptionHandling;
import api.atlantis.exception.domain.NotOfficeXmlFileException;
import api.atlantis.mapstruct.dto.app.plantresult.BookingDto;
import api.atlantis.mapstruct.mappers.app.plantresult.BookingMapper;
import api.atlantis.service.interfaces.app.plantresult.BookingService;
import api.atlantis.service.interfaces.app.plantresult.UploadService;
import api.atlantis.utility.ExcelHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/api/plantresult")
public class PlantResultResource extends ExceptionHandling {
    private UploadService uploadService;
    private BookingService bookingService;
    private BookingMapper bookingMapper;

    public PlantResultResource(UploadService uploadService, BookingService bookingService, BookingMapper bookingMapper) {
        this.uploadService = uploadService;
        this.bookingService = bookingService;
        this.bookingMapper = bookingMapper;
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<BookingDto>> getBookings(@RequestParam(name = "plantId") Long plantId,
                                                        @RequestParam(name = "year") int year,
                                                        @RequestParam(name = "month") int month) {
        List<Booking> bookings = bookingService.getBookings(plantId, year, month);
        List<BookingDto> bookingDtos = bookingMapper.toListDto(bookings);

        return new ResponseEntity<>(bookingDtos, HttpStatus.OK);
    }

    @GetMapping("/bookingsforcostcenter")
    public ResponseEntity<List<BookingDto>> getBookingsForCostCenter(@RequestParam(name = "costCenter") String costCenter,
                                                                     @RequestParam(name = "plantId") Long plantId,
                                                                     @RequestParam(name = "year") int year,
                                                                     @RequestParam(name = "month") int month,
                                                                     @RequestParam(name = "accountNumber") String accountNumber) {
        List<Booking> bookings = bookingService.getBookingsForCostCenter(costCenter, plantId, year, month, accountNumber);
        List<BookingDto> bookingDtos = bookingMapper.toListDto(bookings);

        return new ResponseEntity<>(bookingDtos, HttpStatus.OK);
    }

    @GetMapping("/bookingsforaccnumb")
    public ResponseEntity<List<BookingDto>> getBookingsForAccountNumber(@RequestParam(name = "accountNumber") String accountNumber,
                                                                        @RequestParam(name = "plantId") Long plantId,
                                                                        @RequestParam(name = "year") int year,
                                                                        @RequestParam(name = "month") int month) {
        List<Booking> bookings = bookingService.getBookingsForAccountNumber(accountNumber, plantId, year, month);
        List<BookingDto> bookingDtos = bookingMapper.toListDto(bookings);

        return new ResponseEntity<>(bookingDtos, HttpStatus.OK);
    }

    @PostMapping(value = "/uploadbookings", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity uploadBookings(@RequestParam(name = "companyId") Long companyId,
                                         @RequestParam(name = "plantId") Long plantId,
                                         @RequestParam(name = "year") int year,
                                         @RequestParam(name = "month") int month,
                                         @RequestParam(name = "files") MultipartFile[] files)
            throws IOException, NotOfficeXmlFileException {
        ExcelHelper.hasExcelFormat(files[0]);
        uploadService.save(files[0], companyId, plantId, year, month);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
