package tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static util.Files.getXls;
import static util.Files.readXlsxFromPath;

public class ExcelFileTests {
    @Test
    void xlsSimpleTest() throws IOException {
        String xlsFilePath = "./src/test/resources/files/25-17.xls";
        String expectedData = "ибо препятствуют ему себялюбивые и тираны из злых людей";

        XLS xls = getXls(xlsFilePath);
        assertThat(xls, XLS.containsText(expectedData));
    }

    @Test
    void xlsCellTest() throws IOException {
        String xlsFilePath = "./src/test/resources/files/25-17.xls";
        String expectedData = "ибо препятствуют ему себялюбивые и тираны из злых людей";

        XLS xls = getXls(xlsFilePath);
        String actualData = xls.excel.getSheetAt(0).getRow(4).getCell(1).toString();
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void xlsxTest() {
        String xlsFilePath = "./src/test/resources/files/25-17.xlsx";
        String expectedData = "ибо препятствуют ему себялюбивые и тираны из злых людей";

        String actualData = readXlsxFromPath(xlsFilePath);
        assertThat(actualData, containsString(expectedData));
    }

}
