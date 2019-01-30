package uti.ro.examples;

import org.junit.Test;
import uti.ro.examples.postfix.Postfix;

import static org.junit.Assert.*;

public class PostfixTest {


    @Test
    public void testInt() {
        Postfix postfix = new Postfix("3");
        assertEquals(3, postfix.result());
    }

    @Test
    public void testSimpleIntAddition(){
        Postfix postfix = new Postfix("3 4 +");
        assertEquals(7, postfix.result());
    }

    @Test
    public void testSimpleTripleIntAddition(){
        Postfix postfix = new Postfix("3 4 5 6 + + +");
        assertEquals(18, postfix.result());
    }

    @Test
    public void testComplexIntAddition(){
        Postfix postfix = new Postfix("3 4 + 5 6 + + 7 +");
        assertEquals(25, postfix.result());
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
        Postfix postfix = new Postfix("4 4 /");
        assertEquals(1, postfix.result());
    }

    @Test
    public void testIntAllOperationsAtOnce(){
        Postfix postfix = new Postfix("15 7 1 1 + - / 3 * 2 1 1 + + -");
        assertEquals(5, postfix.result());
    }

}
