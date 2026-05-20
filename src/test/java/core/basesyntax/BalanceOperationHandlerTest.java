package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BalanceOperationHandlerTest {
    @Test
    void balanceOperation_shouldOverwriteExistingQuantity() {
        Storage storage = new Storage();
        storage.getFruits().put("banana", 10);
        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(FruitTransaction.Operation.BALANCE);
        transaction.setFruit("banana");
        transaction.setQuantity(100);
        BalanceOperationHandler handler = new BalanceOperationHandler(storage);
        handler.apply(transaction);
        Assertions.assertEquals(100, storage.getFruits().get("banana"));
    }
}
