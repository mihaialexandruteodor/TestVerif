import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void verificaTrue(){
        assertTrue(Main.calculeaza(6533).equals("DA"));
    }
    @Test
    void verificaFalse(){
        assertTrue(Main.calculeaza(6282).equals("NU"));
    }

    @Test
    void testarePartitionareInClaseDeEchivalenta(){


        assertTrue(Main.calculeaza(4513).equals("DA"));
        assertTrue(Main.calculeaza(1234).equals("NU"));
        assertTrue(Main.calculeaza(345).equals("Numarul nu este valid"));
        assertTrue(Main.calculeaza(123456).equals("Numarul nu este valid"));

    }
    @Test
    void frontiere(){
/*
        (1000, “NU”)
        (99999, “NU”)
        (4513, “DA”)
        (999, “eroare”)
        (34, “eroare”)
        (100000, “eroare”)
        (4534123, “eroare”)
        */

        assertTrue(Main.calculeaza(1000).equals("NU"));
        assertTrue(Main.calculeaza(99999).equals("NU"));
        assertTrue(Main.calculeaza(4513).equals("DA"));
        assertTrue(Main.calculeaza(999).equals("Numarul nu este valid"));
        assertTrue(Main.calculeaza(34).equals("Numarul nu este valid"));
        assertTrue(Main.calculeaza(100000).equals("Numarul nu este valid"));
        assertTrue(Main.calculeaza(4534123).equals("Numarul nu este valid"));
    }

    @Test
    void grafulcauzaefect(){

        /*
        n
123
1231
1234
output
eroare
DA
NU


         */

        assertTrue(Main.calculeaza(123).equals("Numarul nu este valid"));
        assertTrue(Main.calculeaza((1231)).equals("DA"));
        assertTrue(Main.calculeaza((1234)).equals("NU"));
    }
}
