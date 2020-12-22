package ueb;

import org.junit.Test;

import static  org.junit.Assert.*;

public class MainTest {

    @Test
    public void calculateDigitSum() {
        int sum = Main.calculateDigitSum(22);
        assertEquals(4,sum);

    }
    @Test
    public void isHarshadNumber(){
      boolean  harshad = Main.isHarshadNumber(23);
      assertEquals(false,harshad);

    }
    @Test
    public void Collatz(){
        int number =Main.Collatz(1);
        assertEquals(4,number);
    }
    @Test
    public void encrytion(){

        int encryption=Main.encrytion(-1,163);
        assertEquals(1549556828,encryption);
    }
    @Test
    public void getBinaryString(){
        String binary=Main.getBinaryString(14);
        assertEquals("00000000000000000000000000001110",binary);
    }

   @Test
    public void isValidKey(){
        boolean isvalid=Main.isValidKey(163);
        assertEquals(true,isvalid);

   }
}