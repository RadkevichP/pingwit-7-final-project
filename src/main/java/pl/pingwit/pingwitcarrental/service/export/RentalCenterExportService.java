package pl.pingwit.pingwitcarrental.service.export;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import pl.pingwit.pingwitcarrental.repository.rentalcenter.RentalCenter;
import pl.pingwit.pingwitcarrental.repository.rentalcenter.RentalCenterRepository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class RentalCenterExportService {

    private final RentalCenterRepository repository;

    public RentalCenterExportService(RentalCenterRepository repository) {
        this.repository = repository;
    }

    public byte[] exportRentalCenters() throws IOException {
        List<RentalCenter> rentalCenters = repository.findAll();

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Rental Centers");
            // Create header row
            createHeader(sheet);
            // Create data rows
            createDataRows(rentalCenters, sheet);

            // Write Excel to ByteArrayOutputStream
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return outputStream.toByteArray();
        }
    }

    private void createDataRows(List<RentalCenter> rentalCenters, Sheet sheet) {
        int rowNum = 1;
        for (RentalCenter rentalCenter : rentalCenters) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(rentalCenter.getId());
            row.createCell(1).setCellValue(rentalCenter.getName());
            row.createCell(2).setCellValue(rentalCenter.getAddress());
        }
    }

    private void createHeader(Sheet sheet) {
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Address");
    }
}