import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
    }

    @Test
    void getTotalBalance() {
    }

    @Test
    void credit() {
    }

    @Test
    void debit() {
    }

    @Test
    void getAccountNumber() {
    }

    @Test
    void getISadmin() {
    }

    @Test
    void getPin() {
    }

    @Test
    void getUsername() {
    }

    @Test
    void setUsername() {
    }

    @Test
    void setAccountNumber() {
    }


    @Test
    void setPin() {
    }

    @Test
    void setAvailableBalance() {
    }

    @Test
    void setTotalBalance() {
    }

    @Test
    void getAdmin() {
    }

    @Test
    void setAdmin() {
    }
}