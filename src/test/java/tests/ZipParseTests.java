package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipParseTests {

    private final ClassLoader cl = ZipParseTests.class.getClassLoader();

    @Test
    void zipPdfTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("ZipTest.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zs.getNextEntry()) != null) {
                if (entry.getName().contains("pdf-test")) {
                    PDF pdf = new PDF(zs);
                    Assertions.assertTrue((pdf.text).contains("PDF Test File"));
                }
            }
        }
    }

    @Test
    void zipCsvTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("ZipTest.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zs.getNextEntry()) != null) {

                if (entry.getName().contains("csv-test")) {

                    CSVReader csvReader = new CSVReader(new InputStreamReader(zs));
                    List<String[]> content = csvReader.readAll();
                    Assertions.assertArrayEquals(new String[]{"John", "Doe", "120 jefferson st.", "Riverside", " NJ", " 08075"}, content.get(0));

                }
            }
        }
    }

    @Test
    void zipXlsTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("ZipTest.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zs.getNextEntry()) != null) {

                if (entry.getName().contains("xls-test")) {

                    XLS xls = new XLS(zs);
                    Assertions.assertTrue(
                            xls.excel.getSheetAt(0).getRow(3).getCell(4).getStringCellValue().contains("France")
                    );

                }
            }
        }
    }
}