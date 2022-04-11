import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest2 {

    @Test
    void verificaTrue(){
        assertTrue(Main.calculeaza(4000).equals("DA"));
    }
    @Test
    void verificaFalse(){
        assertTrue(Main.calculeaza(6282).equals("NU"));
    }

/*
5110
5111
82
123456


 */

    @Test
    void claseDeEchivalenta(){
        assertTrue(Main.calculeaza(5110).equals("DA"));
        assertTrue(Main.calculeaza(5111).equals("NU"));
        assertTrue(Main.calculeaza(82).equals("Numarul nu este valid"));
        assertTrue(Main.calculeaza(123456).equals("Numarul nu este valid"));
    }

    /*
    (999, "Numarul nu este valid")
(1000, “NU”)
(99999, “NU”)
(100000, "Numarul nu este valid")
(84, "Numarul nu este valid”)
(3841,”NU”)
(1234568,"Numarul nu este valid")

     */
    @Test
    void frontiere(){
        assertTrue(Main.calculeaza(999).equals("Numarul nu este valid"));
        assertTrue(Main.calculeaza(1000).equals("NU"));
        assertTrue(Main.calculeaza(100000).equals("Numarul nu este valid"));
        assertTrue(Main.calculeaza(84).equals("Numarul nu este valid"));
        assertTrue(Main.calculeaza(99999).equals("NU"));
        assertTrue(Main.calculeaza(3841).equals("NU"));
        assertTrue(Main.calculeaza(1234568).equals("Numarul nu este valid"));

    }

    @Test
    void grafcauzaefect(){
        /*
        67
2353
2354
         */
        assertTrue(Main.calculeaza(67).equals("Numarul nu este valid"));
        assertTrue(Main.calculeaza(2353).equals("DA"));
        assertTrue(Main.calculeaza(2354).equals("NU"));
    }
}
