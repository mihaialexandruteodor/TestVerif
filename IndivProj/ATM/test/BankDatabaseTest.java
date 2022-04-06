import static org.junit.jupiter.api.Assertions.*;

class BankDatabaseTest {

    BankDatabase bd;
    Account accounts1;
    Account accounts2;
    Account accounts3;
    Account accounts4;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        bd = new BankDatabase();
        accounts1 = new Account("Customer1", 12345, 11111, 1000.0, 1200.0, 0);
        accounts2 = new Account("Customer2", 98765, 22222, 200.0, 200.0, 0);
        accounts3 = new Account("Customer3", 19234, 33333, 200.0, 200.0, 0);
        accounts4 = new Account("Manager1", 99999, 00000, 0, 0, 1);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        bd = null;
        accounts1 = null;
        accounts2 = null;
        accounts3 = null;
        accounts4 = null;
    }

    @org.junit.jupiter.api.Test
    void getAccount() {
        assertTrue(bd.getAccount(12345).getUsername().equals(accounts1.getUsername()));
        assertEquals(bd.getAccount(98765).getTotalBalance(),accounts2.getTotalBalance());
        assertEquals(bd.getAccount(98765).getAvailableBalance(),accounts2.getAvailableBalance());
        assertEquals(bd.getAccount(19234).getPin(),accounts3.getPin());
        assertEquals(bd.getAccount(99999).getISadmin(),accounts4.getISadmin());
    }

    @org.junit.jupiter.api.Test
    void authenticateUser() {
    }

    @org.junit.jupiter.api.Test
    void getAvailableBalance() {
    }

    @org.junit.jupiter.api.Test
    void getTotalBalance() {
    }

    @org.junit.jupiter.api.Test
    void credit() {
    }

    @org.junit.jupiter.api.Test
    void debit() {
    }

    @org.junit.jupiter.api.Test
    void getadmin() {
    }

    @org.junit.jupiter.api.Test
    void getaccpin() {
    }

    @org.junit.jupiter.api.Test
    void adduser() {
    }

    @org.junit.jupiter.api.Test
    void deleteuser() {
    }
}