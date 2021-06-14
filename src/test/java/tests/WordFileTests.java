package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static util.Files.readDocFromPath;
import static util.Files.readDocxFromPath;

public class WordFileTests {
    @Test
    void docTest() throws IOException {
        String docFilePath = "./src/test/resources/files/25-17.doc";
        String expectedData = "ибо препятствуют ему себялюбивые и тираны из злых людей";
        assertThat(readDocFromPath(docFilePath), containsString(expectedData));
    }

    @Test
    void docxTest() throws IOException {
        String docxFilePath = "./src/test/resources/files/25-17.docx";
        String expectedData = "ибо препятствуют ему себялюбивые и тираны из злых людей";
        assertThat(readDocxFromPath(docxFilePath), containsString(expectedData));
    }
}
