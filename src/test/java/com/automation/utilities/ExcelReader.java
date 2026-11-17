package com.automation.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;

public class ExcelReader {

    public static Object[][] getTestData(String sheetName)
            throws Exception {

        // Read Excel file from test resources
        try (InputStream input = ExcelReader.class
                .getResourceAsStream("/testData/LoginTestData.xlsx")) {

            if (input == null) {
                throw new IllegalArgumentException(
                        "Excel file not found in test resources");
            }

            // Open workbook
            try (Workbook workbook = new XSSFWorkbook(input)) {

                // Get required sheet
                Sheet sheet = workbook.getSheet(sheetName);

                if (sheet == null) {
                    throw new IllegalArgumentException(
                            "Sheet not found: " + sheetName);
                }

                // Count rows excluding header
                int rows = sheet.getLastRowNum();

                // Read number of columns from header
                int cols = sheet.getRow(0).getLastCellNum();

                // Store Excel data
                Object[][] data = new Object[rows][cols];

                DataFormatter formatter = new DataFormatter();

                // Start from row 1 because row 0 is header
                for (int i = 1; i <= rows; i++) {

                    Row row = sheet.getRow(i);

                    for (int j = 0; j < cols; j++) {

                        Cell cell = (row == null) ? null :
                                row.getCell(j);

                        // Convert cell value into String
                        data[i - 1][j] = cell == null
                                ? ""
                                : formatter.formatCellValue(cell);
                    }
                }

                return data;
            }
        }
    }
}