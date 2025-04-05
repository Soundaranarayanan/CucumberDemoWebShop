package utilities;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {
    public static Map<String, String> getBillingData(String filePath, String sheetName) {
        Map<String, String> data = new HashMap<>();
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);
            Row dataRow = sheet.getRow(1);

            DataFormatter formatter = new DataFormatter();

            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                String key = formatter.formatCellValue(headerRow.getCell(i)); 
                String value = formatter.formatCellValue(dataRow.getCell(i));  
                data.put(key, value);
            }

            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
