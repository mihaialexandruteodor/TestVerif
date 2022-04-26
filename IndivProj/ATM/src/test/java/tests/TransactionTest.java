package tests;

import app.BankDatabase;
import app.Screen;
import app.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionTest {

    Transaction transaction;
    BankDatabase bd;
    Screen screen;

    @BeforeEach
    void setUp() {
        screen = new Screen();
        bd = new BankDatabase();
        transaction = new Transaction(12345, screen, bd) {
            @Override
            public void execute() {
            }
        };
    }

    @AfterEach
    void tearDown() {
        screen = null;
        bd = null;
        transaction = null;
    }

    @Test
    void getAccountNumber() {
        assertEquals(transaction.getAccountNumber(), 12345);
    }

    @Test
    void getScreen() {
        assertEquals(transaction.getScreen(), screen);
    }

    @Test
    void getBankDatabase() {
        assertEquals(transaction.getBankDatabase(), bd);
    }
}