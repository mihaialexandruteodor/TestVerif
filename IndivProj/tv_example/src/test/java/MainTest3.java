import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest3 {

    @Test
    void verificaTrue(){
        assertTrue(Main.calculeaza(6533).equals("DA"));
    }
    @Test
    void verificaFalse(){
        assertTrue(Main.calculeaza(6282).equals("NU"));
    }


    /*
    5413
8200
29
1234567


     */

    @Test
    void echivalente(){
        assertTrue(Main.calculeaza(54413).equals("DA"));
        assertTrue(Main.calculeaza(8200).equals("NU"));
        assertTrue(Main.calculeaza(29).equals( "Numarul nu este valid"));
        assertTrue(Main.calculeaza(1234567).equals( "Numarul nu este valid"));

    }

    /*
    (999, “eroare”), (1000, “NU”), (99999,”NU”), (100000,”eroare”), (234, eroare), (2340, nu), (213232, eroare), (1001, “da”)
     */

    @Test
    void frontiere(){
        assertTrue(Main.calculeaza( 999).equals( "Numarul nu este valid"));
        assertTrue(Main.calculeaza( 1000).equals("NU"));
        assertTrue(Main.calculeaza( 99999).equals("NU"));
        assertTrue(Main.calculeaza(100000 ).equals( "Numarul nu este valid"));
        assertTrue(Main.calculeaza( 234).equals( "Numarul nu este valid"));
        assertTrue(Main.calculeaza( 2340).equals("NU"));
        assertTrue(Main.calculeaza( 213232).equals( "Numarul nu este valid"));
        assertTrue(Main.calculeaza(1001).equals("DA"));

    }

    /* 687
5321
5733

*/
    @Test
    void grafcauzaefect(){
        assertTrue(Main.calculeaza(687).equals("Numarul nu este valid"));
        assertTrue(Main.calculeaza(5321).equals("DA"));
        assertTrue(Main.calculeaza(5733).equals("NU"));
    }


}
