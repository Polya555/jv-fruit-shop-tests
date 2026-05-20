package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PurchaseOperationHandlerTest {
    @Test
    void purchaseOperation_shouldDecreaseFruitQuantity() {
        Storage storage = new Storage();
        storage.getFruits().put("apple", 10);

        FruitTransaction transaction = new FruitTransaction(
                FruitTransaction.Operation.PURCHASE, "apple", 3
        );
        PurchaseOperationHandler handler = new PurchaseOperationHandler(storage);
        handler.apply(transaction);
        Assertions.assertEquals(7, storage.getFruits().get("apple"));
    }

    @Test
    void purchaseOperation_noFruitTypeInStorage() {
        Storage storage = new Storage();
        FruitTransaction transaction = new FruitTransaction(
                FruitTransaction.Operation.PURCHASE, "banana", 5
        );
        PurchaseOperationHandler handler = new PurchaseOperationHandler(storage);
        Assertions.assertThrows(RuntimeException.class,
                () -> handler.apply(transaction));
    }

    @Test
    void purchaseOperation_notEnoughFruits_shouldThrowException() {
        Storage storage = new Storage();
        storage.getFruits().put("apple", 2);
        FruitTransaction transaction = new FruitTransaction(
                FruitTransaction.Operation.PURCHASE, "apple", 5
        );
        PurchaseOperationHandler handler = new PurchaseOperationHandler(storage);
        Assertions.assertThrows(RuntimeException.class,
                () -> handler.apply(transaction));
    }
}
