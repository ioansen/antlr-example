package uti.ro.examples;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExprTest {


    @Test
    public void testInt() {
        Postfix postfix = new Postfix("3");
        assertEquals(3, postfix.result());
    }

    @Test
    public void testIntAddition(){
        Postfix postfix = new Postfix("3 4 +");
        assertEquals(7, postfix.result());
    }

    @Test
    public void testIntSubtraction(){
        Postfix postfix = new Postfix("3 4 -");
        assertEquals(-1, postfix.result());
    }

    @Test
    public void testIntMultiplication(){
        Postfix postfix = new Postfix("3 4 *");
        assertEquals(12, postfix.result());
    }

    @Test
    public void testIntDivision(){
        Postfix postfix = new Postfix("3 4 /");
        assertEquals(0, postfix.result());
    }
}
