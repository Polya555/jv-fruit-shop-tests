package core.basesyntax;

import core.basesyntax.serviceimpl.ReportGeneratorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReportGeneratorImplTest {
    @Test
    void getReport_emptyStorage_returnsOnlyHeader() {
        Storage storage = new Storage();
        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String report = reportGenerator.getReport();
        Assertions.assertEquals("fruit,quantity\n", report);
    }

    @Test
    void getReport_withFruits_returnsCorrectReport() {
        Storage storage = new Storage();
        storage.getFruits().put("apple", 50);
        storage.getFruits().put("banana", 30);
        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String report = reportGenerator.getReport();
        String expected = "fruit,quantity"
                + "apple,50"
                + "banana,30";
        Assertions.assertEquals(expected, report);
    }
}
