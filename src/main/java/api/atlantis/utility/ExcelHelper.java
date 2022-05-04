package api.atlantis.utility;

import api.atlantis.domain.app.masterdata.general.Company;
import api.atlantis.domain.app.masterdata.general.Plant;
import api.atlantis.domain.app.plantresult.Booking;
import api.atlantis.exception.domain.NotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelHelper {
    public static final String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    public static void hasExcelFormat(MultipartFile file) throws NotOfficeXmlFileException {
        if (!TYPE.equals(file.getContentType())) { throw new NotOfficeXmlFileException(""); }
    }

    public static List<Booking> createBookings(InputStream inputStream, Company company, Plant plant, int year,
                                               int month) throws IOException {
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        List<Booking> bookings = new ArrayList<Booking>();

        int rowNumber = sheet.getLastRowNum();

        for (int i = 1; i <= rowNumber; i++) {
            Row row = sheet.getRow(i);
            if (!row.getCell(0).getStringCellValue().isEmpty()) {
                Booking booking = new Booking();
                booking.setCompany(company);
                booking.setPlant(plant);
                booking.setYear(year);
                booking.setMonth(month);
                booking.setCostCenter(row.getCell(0).getStringCellValue());
                booking.setAccountNumber(row.getCell(2).getStringCellValue());
                booking.setAccountName(row.getCell(3).getStringCellValue());
                booking.setAmount(row.getCell(4).getNumericCellValue());
                booking.setCurrency(row.getCell(5).getStringCellValue());
                booking.setTransAmount(row.getCell(6).getNumericCellValue());
                booking.setTransCur(row.getCell(7).getStringCellValue());
                booking.setBookingNr(row.getCell(11).getStringCellValue());
                booking.setRefNr(row.getCell(12).getStringCellValue());
                booking.setBookingText("");
                if (!row.getCell(13).getStringCellValue().isEmpty()) booking.setBookingText(row.getCell(13).getStringCellValue());
                if (!row.getCell(16).getStringCellValue().isEmpty()) booking.setBookingText(row.getCell(16).getStringCellValue());
                if (!row.getCell(17).getStringCellValue().isEmpty()) booking.setBookingText(row.getCell(17).getStringCellValue());
                booking.setPartnerObj(row.getCell(18).getStringCellValue());
                booking.setPartnerObjName(row.getCell(19).getStringCellValue());
                booking.setContAccNumb(row.getCell(21).getStringCellValue());
                booking.setContAccName(row.getCell(22).getStringCellValue());
                booking.setPeriod(Integer.parseInt(row.getCell(23).getStringCellValue()));
                booking.setBookingDate(row.getCell(24).getLocalDateTimeCellValue().toLocalDate());
                booking.setDocDate(row.getCell(25).getLocalDateTimeCellValue().toLocalDate());
                booking.setPostingDate(row.getCell(26).getLocalDateTimeCellValue().toLocalDate());
                booking.setUserName(row.getCell(27).getStringCellValue());

                bookings.add(booking);
            }
        }

        workbook.close();

        return bookings;
    }
}
