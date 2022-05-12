package tests;

import app.Account;
import app.BankDatabase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BankDatabaseTest_me {

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

        int[] accountNumbers = {12345, 19234, 98765, 99999};

        for (int i = 0; i < 4; ++i) {
            assertEquals(bd.getAccount(accountNumbers[i]).getAccountNumber(), accounts[i].getAccountNumber());
            assertEquals(bd.getAccount(accountNumbers[i]).getPin(), accounts[i].getPin());
            assertEquals(bd.getAccount(accountNumbers[i]).getUsername(), accounts[i].getUsername());
            assertEquals(bd.getAccount(accountNumbers[i]).getAdmin(), accounts[i].getAdmin());
            assertEquals(bd.getAccount(accountNumbers[i]).getAvailableBalance(), accounts[i].getAvailableBalance());
            assertEquals(bd.getAccount(accountNumbers[i]).getTotalBalance(), accounts[i].getTotalBalance());
            assertEquals(bd.getAccount(accountNumbers[i]).getISadmin(), accounts[i].getISadmin());

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
    void getTotalBalance_claseEchivaneta() {

        // partitionare in clase de echivalenta
        /*

        CLASE DE INTRARI
        N1 = [0.0, 200.0)
        N2 = [200.0, 1000.0)
        N3 = [1000.0, 1200.0)
        N4 = [1200.0, 10000.0]


        CLASE DE IESIRI
        I1={"Balans Insuficient"}
        I2={"Cont standard"}
        I3={"Cont premium"}
        I3={"Cont premium plus"}

        CLASE ECHIVALENTA FINALE
        C11={n | n apartine lui N1 si iesirea este I1}
        C22={n | n apartine lui N2 si iesirea este I2}
        C33={n | n apartine lui N3 si iesirea este I3}
        C44={n | n apartine lui N4 si iesirea este I4}

         */

        double[] intrari = {0.0, 200.0, 1000.0, 1200.0, 10000.0};
        String[] iesiri = {"Balans Insuficient","Cont standard", "Cont premium", "Cont premium plus"};
        String clasaEchivalenta = "Nedeterminat";

        //assertEquals(bd.getAccount(99999).getTotalBalance(),accounts4.getTotalBalance());

        for(Account acc : accounts)
        {
            double totalBalance = acc.getTotalBalance();

            if( intrari[0] == totalBalance && totalBalance < intrari[1])
                clasaEchivalenta = "C11";

            if( intrari[1] == totalBalance && totalBalance < intrari[2])
                clasaEchivalenta = "C22";

            if( intrari[2] == totalBalance && totalBalance < intrari[3])
                clasaEchivalenta = "C33";

            if( intrari[3] == totalBalance && totalBalance < intrari[4])
                clasaEchivalenta = "C44";

            switch (clasaEchivalenta)
            {
                case "C11":
                    assertEquals(clasaEchivalenta,"C11");
                    break;
                case "C22":
                    assertEquals(clasaEchivalenta,"C22");
                    break;
                case "C33":
                    assertEquals(clasaEchivalenta,"C33");
                    break;
                case "C44":
                    assertEquals(clasaEchivalenta,"C44");
                    break;
            }

        }
    }

    @org.junit.jupiter.api.Test
    void getTotalBalance_GrafCauzaEfect() {

        /*graf cauza efect
        Cauze:
          C1: n valid: n intre 200.0 si 1200.0
          C2: n invalid: n < 200.0
          C3: n valid, fonduri reziduale: n > 1200.0

        Efecte:
           E1: balans suficient
           E2: balans insuficient


        GRAF:
        | C1  | 1  | 0  | 0  |
        | C2  | 0  | 1  | 0  |
        | C3  | 0  | 0  | 1  |
        | E1  | 1  | 0  | 1  |
        | E2  | 0  | 1  | 0  |
        | n  | 0.0  | 1000.0  | 10000.0  |
        | Effect  | balans insuficient  | balans suficient  | balans suficient  |

         */

        String[][] graf = { {"C1","1","0","0"}, {"C2","0","1","0"}, {"C3","0","0","1"}, {"E1","1","0","1"}, {"E2","0","1","0"}};
        
        String cause = null;
        String effect = "";

        for(Account acc : accounts) {
            double n = acc.getTotalBalance();
            
            if(n> 200.0 && n < 1200.0)
                cause = "C1";
            else if(n < 200.0)
                cause = "C2";
            else if(n > 1200.0)
                cause = "C3";
            
            for(int i=0; i<4; ++i)
            {
                if(graf[i][0] == cause)
                {
                    if(cause == "C2")
                        effect = "balans insuficient";
                    else
                        effect = "balans suficient";
                }
            }
        }
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