package tests;

import net.lingala.zip4j.exception.ZipException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static util.Files.readTextFromPath;
import static util.Zip.unzip;

public class ZipeFileTests {
    @Test
    void zipWithPasswordTest() throws IOException, ZipException {
        String zipFilePath = "./src/test/resources/files/25-17.zip";
        String unzipFolderPath = "./src/test/resources/files/unzip";
        String zipPassword = "1";
        String unzipTxtFilePath = "./src/test/resources/files/unzip/25-17.txt";
        String expectedData = "ибо препятствуют ему себялюбивые и тираны из злых людей";

        unzip(zipFilePath, unzipFolderPath, zipPassword);

        String actualData = readTextFromPath(unzipTxtFilePath);

        assertThat(actualData, containsString(expectedData));
    }
}
