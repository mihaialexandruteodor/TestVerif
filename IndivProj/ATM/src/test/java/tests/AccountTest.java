package tests;

import app.Account;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountTest {

    static Account[] accounts;

    @BeforeEach
    void setUp() {
        Account accounts1 = new Account("Customer1", 12345, 11111, 1000.0, 1200.0, 0);
        Account accounts2 = new Account("Customer2", 98765, 22222, 200.0, 200.0, 0);
        Account accounts3 = new Account("Customer3", 19234, 33333, 200.0, 200.0, 0);
        Account accounts4 = new Account("Manager1", 99999, 00000, 0, 0, 1);
        accounts = new Account[]{accounts1, accounts2, accounts3, accounts4};
    }

    @AfterEach
    void tearDown() {
        for (Account acc : accounts) {
            acc= null;
        }
        accounts = null;
    }

    @Test
    void validatePIN() {

        assertTrue(accounts[0].validatePIN(11111));
    }

    @Test
    void getAvailableBalance() {
        assertEquals(accounts[1].getAvailableBalance(),200.0);
    }

    @Test
    void getTotalBalance() {

        // EQUIVALENCE PARTITIONING

        double lesserValue = ThreadLocalRandom.current().nextDouble(0, 1100.0);
        double moreValue = ThreadLocalRandom.current().nextDouble(1300.0, 5000.0);

        assertTrue(accounts[0].getTotalBalance() > lesserValue);
        assertTrue(accounts[0].getTotalBalance() < moreValue);

    }


    @Test
    void getAccountNumber() {
        assertEquals(accounts[1].getAccountNumber(), 98765);
    }

    @Test
    void getISadmin() {
        assertEquals(accounts[3].getISadmin(),1);
    }

    @Test
    void getPin() {
        assertEquals(accounts[0].getPin(),11111);
    }

    @Test
    void getUsername() {
        assertEquals(accounts[3].getUsername(),"Manager1");
    }

    @Test
    void setUsername() {
        accounts[3].setUsername("Different");
        assertEquals(accounts[3].getUsername(),"Different");
    }

    @Test
    void setAccountNumber() {
        accounts[1].setAccountNumber(88888);
        assertEquals(accounts[1].getAccountNumber(), 88888);
    }


    @Test
    void setPin() {
        accounts[0].setPin(8976543);
        assertEquals(accounts[0].getPin(),8976543);
    }

    @Test
    void setAvailableBalance() {
        accounts[1].setAvailableBalance(12345.0);
        assertEquals(accounts[1].getAvailableBalance(),12345.0);
    }

    @Test
    void setTotalBalance() {
        accounts[1].setTotalBalance(5555.0);
        assertEquals(accounts[1].getTotalBalance(),5555.0);
    }

    @Test
    void getAdmin() {
        assertEquals(accounts[1].getAdmin(), 0);
    }

    @Test
    void setAdmin() {
        accounts[1].setAdmin(1);
        assertEquals(accounts[1].getAdmin(), 1);
    }
}