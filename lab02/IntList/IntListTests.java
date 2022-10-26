package IntList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntListTests {

    @Test
    public void testdSquareList() {
        IntList L = IntList.of(1, 2, 5);
        IntList.dSquareList(L);
        assertEquals("1 -> 4 -> 25", L.toString());
    }

    @Test
    public void testsquareListIterative() {
        IntList L = IntList.of(1, 2, 5);
        IntList N = IntList.squareListIterative(L);
        assertEquals("1 -> 4 -> 25", N.toString());
    }

    @Test
    public void testsquareListRecursive() {
        IntList L = IntList.of(1, 2, 5);
        IntList N = IntList.squareListRecursive(L);
        assertEquals("1 -> 4 -> 25", N.toString());
    }


    @Test
    public void testdcatenate() {
        IntList L_1 = IntList.of(1, 2, 5);
        IntList L_2 = IntList.of(1, 2, 5);
        IntList.dcatenate(L_1, L_2);
        assertEquals("1 -> 2 -> 5 -> 1 -> 2 -> 5", L_1.toString());
    }

    @Test
    public void testdeepcopy() {
        IntList L = IntList.of(1, 2, 5);
        IntList N = IntList.deepcopy(L);
        assertEquals("1 -> 2 -> 5", L.toString());
        assertEquals("1 -> 2 -> 5", N.toString());
    }

    @Test
    public void testcatenate() {
        IntList L_1 = IntList.of(1, 2, 5);
        IntList L_2 = IntList.of(1, 2, 5);
        IntList N = IntList.catenate(L_1, L_2);
        assertEquals("1 -> 2 -> 5 -> 1 -> 2 -> 5", N.toString());
        assertEquals("1 -> 2 -> 5", L_1.toString());
        assertEquals("1 -> 2 -> 5", L_2.toString());
    }
}
