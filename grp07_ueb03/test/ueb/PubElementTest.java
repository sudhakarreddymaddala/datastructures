package ueb;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests that are published with the assignment.
 * If one of them fails, you will fail the assignment.
 * 
 * @author klk
 */
public class PubElementTest {

    /**
     * Creates an element with the given value, if multiple values are passed,
     * additional elements are appended.
     *
     * @param value value(s) of the element(s)
     * @return element with the value or multiple linked elements
     */
    private Element createElements(int... value) {
        if (value.length == 0) {
            return null;
        }
        // create an element
        Element el = new Element(value[0]);
        Element firstEl = el; // remember the first element

        // create additional elements
        for (int i = 1; i < value.length; i++) {
            el.appendElement(value[i]);
            el = el.getNext();
        }
        return firstEl;
    }

    // -----------------------------------------------

//<editor-fold defaultstate="collapsed" desc="tests from the lecture">

    // you have to pass this test first as other test rely on it
    @Test
    public void test0AppendElement_ToOneElement() {
        Element el = new Element(0, null);
        Element result = el.appendElement(1);
        assertEquals(0, result.getValue());
        assertEquals(1, result.getNext().getValue());
        assertNull(result.getNext().getNext());
    }

    // you have to pass this test first as other test rely on it
    @Test
    public void test0AppendElement_Twice() {
        Element el = new Element(0, null);
        Element result = el.appendElement(1).appendElement(2);
        assertEquals(0, result.getValue());
        assertEquals(1, result.getNext().getValue());
        assertEquals(2, result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());
    }

    // -----------------------------------------------

    @Test
    public void testInsertElement_AtFront() {
        Element el = createElements(1, 3);
        Element result = el.insertElement(0);
        assertEquals(0, result.getValue());
        assertEquals(1, result.getNext().getValue());
        assertEquals(3, result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());
    }

    @Test
    public void testInsertElement_InMiddle() {
        Element el = createElements(1, 3);
        Element result = el.insertElement(2);
        assertEquals(1, result.getValue());
        assertEquals(2, result.getNext().getValue());
        assertEquals(3, result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());

    }

    @Test
    public void testInsertElement_AtEnd() {
        Element el = createElements(1, 3);
        Element result = el.insertElement(4);
        assertEquals(1, result.getValue());
        assertEquals(3, result.getNext().getValue());
        assertEquals(4, result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());
    }

    // -----------------------------------------------

    @Test
    public void testDeleteElement_AtFront() {
        Element el = createElements(0, 1, 2);
        Element result = el.deleteElement(0);
        assertEquals(1, result.getValue());
        assertEquals(2, result.getNext().getValue());
        assertNull(result.getNext().getNext());
    }

    @Test
    public void testDeleteElement_InMiddle() {
        Element el = createElements(0, 1, 2);
        Element result = el.deleteElement(1);
        assertEquals(0, result.getValue());
        assertEquals(2, result.getNext().getValue());
        assertNull(result.getNext().getNext());
    }

    @Test
    public void testDeleteElement_AtEnd() {
        Element el = createElements(0, 1, 2);
        Element result = el.deleteElement(2);
        assertEquals(0, result.getValue());
        assertEquals(1, result.getNext().getValue());
        assertNull(result.getNext().getNext());
    }

    @Test
    public void testDeleteElement_NotExisting() {
        Element el = createElements(0, 1, 2);
        Element result = el.deleteElement(3);
        assertEquals(0, result.getValue());
        assertEquals(1, result.getNext().getValue());
        assertEquals(2, result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());
    }

//</editor-fold>

    // -----------------------------------------------

    //<editor-fold defaultstate="collapsed" desc="Tests for methods you have to implement">
    @Test
    public void testSize() {
        Element el = createElements(0);
        assertEquals(1, el.size());
        el = createElements(0, 1, 2);
        assertEquals(3, el.size());
    }

    // -----------------------------------------------

    @Test
    public void testSum() {
        Element el = createElements(1, 2, 8);
        assertEquals(11, el.sum());
    }

    // -----------------------------------------------

    @Test
    public void testExistsElement_First() {
        Element el = createElements(1, 2, 4);
        assertTrue(el.existsElement(1));
    }

    @Test
    public void testExistsElement_Middle() {
        Element el = createElements(1, 2, 4);
        assertTrue(el.existsElement(2));
    }

    @Test
    public void testExistsElement_Last() {
        Element el = createElements(1, 2, 4);
        assertTrue(el.existsElement(4));
    }

    @Test
    public void testExistsElement_NotExisting() {
        Element el = createElements(1, 2, 4);
        assertFalse(el.existsElement(0));
        assertFalse(el.existsElement(3));
        assertFalse(el.existsElement(5));
    }

    // -----------------------------------------------

    @Test
    public void testIsSorted_Gapless() {
        Element el = createElements(1, 2, 3);
        assertTrue(el.isSorted());
    }

    @Test
    public void testIsSorted_WithGaps() {
        Element el = createElements(0, 2, 4);
        assertTrue(el.isSorted());
    }

    @Test
    public void testIsSorted_DoubleValues() {
        Element el = createElements(1, 1, 4);
        assertTrue(el.isSorted());
        el = createElements(1, 4, 4);
        assertTrue(el.isSorted());
        el = createElements(1, 2, 2, 4, 4);
        assertTrue(el.isSorted());
    }

    @Test
    public void testIsSorted_NotSorted() {
        Element el = createElements(0, 1, 3, 2);
        assertFalse(el.isSorted());
        el = createElements(0, 2, 1, 3);
        assertFalse(el.isSorted());
        el = createElements(1, 2, 0, 3);
        assertFalse(el.isSorted());
    }

    // -----------------------------------------------

    @Test
    public void testToString() {
        Element el = createElements(0, 1, 2);
        assertEquals("0 1 2", el.toString());

        el = createElements(1);
        assertEquals("1", el.toString());

    }

    // -----------------------------------------------

    @Test
    public void testGetValueAt() {
        Element el = createElements(11, 22, 33);
        assertEquals(11, el.getValueAt(0));
        assertEquals(22, el.getValueAt(1));
        assertEquals(33, el.getValueAt(2));
    }

    @Test
    public void testGetValueAt_InvalidArgument() {
        Element el = createElements(11, 22, 33);
        assertEquals(Integer.MAX_VALUE, el.getValueAt(-1));
        assertEquals(Integer.MAX_VALUE, el.getValueAt(3));
    }

    // -----------------------------------------------

    @Test
    public void testInsertElementAt_Front() {
        Element el = createElements(0, 1, 2);
        Element result = el.insertElementAt(11, 0);
        assertEquals(11, result.getValue());
        assertEquals(0, result.getNext().getValue());
    }

    @Test
    public void testInsertElementAt_Middle() {
        Element el = createElements(0, 1, 2);
        Element result = el.insertElementAt(11, 1);
        assertEquals(0, result.getValue());
        assertEquals(11, result.getNext().getValue());
    }

    @Test
    public void testInsertElementAt_End() {
        Element el = createElements(0, 1);
        Element result = el.insertElementAt(11, 2);
        assertEquals(0, result.getValue());
        assertEquals(1, result.getNext().getValue());
        assertEquals(11, result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());
    }

    @Test
    public void testInsertElementAt_InvalidIndex() {
        Element el = createElements(1, 2);
        Element result = el.insertElementAt(11, -1);
        assertEquals(2, result.size());
        assertEquals(1, result.getValue());
        assertEquals(2, result.getNext().getValue());
        assertNull(result.getNext().getNext());

        el = createElements(1, 2);
        result = el.insertElementAt(11, 3);
        assertEquals(2, result.size());
        assertEquals(1, result.getValue());
        assertEquals(2, result.getNext().getValue());
        assertNull

                (result.getNext().getNext());
    }

    // -----------------------------------------------

    @Test // done but not in recursive manner
    public void testInsertElementAtFront() {
        Element el = createElements(0, 1);
        Element result = el.prependElement(11);
        assertEquals(11, result.getValue());
        assertEquals(0, result.getNext().getValue());
        assertEquals(1, result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());
    }

    // -----------------------------------------------

    @Test
    public void testDeleteAll_DoesNotExist() {
        Element el = createElements(2,0,0,0,1);
        Element result = el.deleteAll(0);
        assertEquals(2, result.getValue());
        assertEquals(1, result.getNext().getValue());
        assertNull(result.getNext().getNext());
    }

    @Test
    public void testDeleteAll_OnlyElement() {
        Element el = createElements(0);
        Element result = el.deleteAll(0);
        assertNull(result);
    }

    @Test
    public void testDeleteAll_OneElement_First() {
        Element el = createElements(0, 1, 2);
        Element result = el.deleteAll(0);
        assertEquals(1, result.getValue());
        assertEquals(2, result.getNext().getValue());
        assertNull(result.getNext().getNext());
    }

    @Test
    public void testDeleteAll_OneElement_Middle() {
        Element el = createElements(1, 0, 2);
        Element result = el.deleteAll(0);
        assertEquals(1, result.getValue());
        assertEquals(2, result.getNext().getValue());
        assertNull(result.getNext().getNext());
    }

    @Test
    public void testDeleteAll_OneElement_Last() {
        Element el = createElements(1, 2);
        Element result = el.deleteAll(0);
        assertEquals(1, result.getValue());
        assertEquals(2, result.getNext().getValue());
        assertNull(result.getNext().getNext());
    }

//</editor-fold>

}