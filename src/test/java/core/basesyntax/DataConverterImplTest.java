package core.basesyntax;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataConverterImplTest {
    @Test
    void convert_validData_returnsTransactions() {
        DataConverter converter = new DataConverterImpl();
        List<String> data = List.of("b,apple,50", "s,banana,30");
        List<FruitTransaction> result = converter.convertToTransaction(data);
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(FruitTransaction.Operation.BALANCE, result.get(0).getOperation());
        Assertions.assertEquals("apple", result.get(0).getFruit());
        Assertions.assertEquals(50, result.get(0).getQuantity());
    }

}
