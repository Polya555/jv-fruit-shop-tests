package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PurchaseOperationHandlerTest {
    @Test
    void purchaseOperation_shouldDecreaseFruitQuantity() {
        Storage storage = new Storage();
        storage.getFruits().put("apple", 10);
        FruitTransaction transaction = new FruitTransaction();
        transaction.setFruit("apple");
        transaction.setQuantity(3);
        transaction.setOperation(FruitTransaction.Operation.PURCHASE);
        PurchaseOperationHandler handler = new PurchaseOperationHandler(storage);
        handler.apply(transaction);
        Assertions.assertEquals(7, storage.getFruits().get("apple"));
    }
}
