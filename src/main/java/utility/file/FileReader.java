package utility.file;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Log4j2
public class FileReader {
    private static final Logger logger = LogManager.getLogger();

    public static final String fileName = "src/main/resources/file.txt";

    public static String readFileAsLine(String fileNames) {
        String content = "";
        Path path = Paths.get(fileName);
        try {
            content = Files.readString(path);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return content;
    }
}
