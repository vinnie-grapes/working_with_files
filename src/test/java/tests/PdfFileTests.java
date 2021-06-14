package tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static util.Files.getPdf;

public class PdfFileTests {
    @Test
    void pdfTests() throws IOException {
        String pdfFilePath = "./src/test/resources/files/25-17.pdf";
        String expectedData = "ибо препятствуют ему себялюбивые и тираны из злых людей";

        PDF pdf = getPdf(pdfFilePath);
        assertThat(pdf, PDF.containsText(expectedData));
    }
}
