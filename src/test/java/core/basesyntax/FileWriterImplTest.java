package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileWriterImplTest {
    @Test
    void write_validData_writesToFile() throws IOException {
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write("test content", "output.txt");

        String result = Files.readString(Path.of("output.txt"));
        Assertions.assertEquals("test content", result);
    }
}
