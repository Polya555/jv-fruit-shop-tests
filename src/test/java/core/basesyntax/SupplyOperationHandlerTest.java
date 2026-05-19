package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SupplyOperationHandlerTest {
    @Test
    void supplyOperation_increasingFruitQuantity() {
        Storage storage = new Storage();
        FruitTransaction transaction = new FruitTransaction();
        transaction.setFruit("apple");
        transaction.setQuantity(10);
        transaction.setOperation(FruitTransaction.Operation.SUPPLY);
        SupplyOperationHandler handler = new SupplyOperationHandler(storage);
        handler.apply(transaction);
        Assertions.assertEquals(10, storage.getFruits().get("apple"));
    }
}
