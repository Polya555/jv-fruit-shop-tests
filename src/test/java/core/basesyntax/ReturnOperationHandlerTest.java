package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReturnOperationHandlerTest {
    @Test
    void returnOperation_shouldIncreaseFruitQuantity() {
        Storage storage = new Storage();
        storage.getFruits().put("apple", 5);
        FruitTransaction transaction = new FruitTransaction();
        transaction.setFruit("apple");
        transaction.setQuantity(3);
        transaction.setOperation(FruitTransaction.Operation.RETURN);
        ReturnOperationHandler handler = new ReturnOperationHandler(storage);
        handler.apply(transaction);
        Assertions.assertEquals(8, storage.getFruits().get("apple"));
    }
}
