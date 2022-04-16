import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BankDatabaseTest {

    BankDatabase bd;
    Account accounts1;
    Account accounts2;
    Account accounts3;
    Account accounts4;
    static Account[] accounts;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        bd = new BankDatabase();
        accounts1 = new Account("Customer1", 12345, 11111, 1000.0, 1200.0, 0);
        accounts2 = new Account("Customer3", 19234, 33333, 200.0, 200.0, 0);
        accounts3 = new Account("Customer2", 98765, 22222, 200.0, 200.0, 0);
        accounts4 = new Account("Manager1", 99999, 00000, 0, 0, 1);

        accounts = new Account[]{accounts1, accounts2, accounts3, accounts4};
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        for (Account acc : accounts) {
            acc= null;
        }
        accounts = null;
    }

    @org.junit.jupiter.api.Test
    void getAccount() {

        // EQUIVALENCE PARTITIONING

        int[] partitioning = {12345, 19234, 98765, 99999, 100000};

        for(int i=0; i < 4; ++i)
        {
            int bound = ThreadLocalRandom.current().nextInt(partitioning[i] , partitioning[i+1] + 1);

            assertTrue(bd.getAccount(partitioning[i]).getAccountNumber() <= bound);
        }





    }

    @org.junit.jupiter.api.Test
    void authenticateUser() {
        assertTrue(bd.getAccount(12345).getUsername().equals(accounts1.getUsername()));
        assertEquals(bd.getAccount(98765).getTotalBalance(),accounts3.getTotalBalance());
        assertEquals(bd.getAccount(98765).getAvailableBalance(),accounts3.getAvailableBalance());
        assertEquals(bd.getAccount(19234).getPin(),accounts2.getPin());
        assertEquals(bd.getAccount(99999).getISadmin(),accounts4.getISadmin());
    }

    @org.junit.jupiter.api.Test
    void getAvailableBalance() {
            assertEquals(bd.getAccount(12345).getAvailableBalance(),accounts1.getAvailableBalance());
    }

    @org.junit.jupiter.api.Test
    void getTotalBalance() {
        assertEquals(bd.getAccount(99999).getTotalBalance(),accounts4.getTotalBalance());
    }

    @org.junit.jupiter.api.Test
    void getadmin() {
        assertEquals(bd.getAccount(99999).getAdmin(),1);
    }

    @org.junit.jupiter.api.Test
    void getaccpin() {
        assertEquals(bd.getAccount(12345).getPin(),11111);
    }


}