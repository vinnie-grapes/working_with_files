package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import util.Files;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class DownloadFileTests {
    @Test
    void selenideDownloadFileTests() throws IOException {
        Configuration.downloadsFolder = "downloads";
        open("https://github.com/VKCOM/VKUI/blob/master/README.md");
        File downloadedFile = $("#raw-url").download();
        String fileContent = Files.readTextFromFile(downloadedFile);
        assertThat(fileContent, containsString("VKUI — это библиотека адаптивных React-компонентов"));
    }
}
