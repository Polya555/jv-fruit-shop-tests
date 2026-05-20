package core.basesyntax;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileReaderImplTest {
    @BeforeEach
    void setUp() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("test_data.txt"))) {
            writer.write("fruit,quantity\nb,apple,50");
        }
    }

    @Test
    void read_validFile_returnsDataWithoutHeader() {
        FileReader fileReader = new FileReaderImpl();
        List<String> result = fileReader.read("test_data.txt");
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("b,apple,50", result.get(0));
    }
}
