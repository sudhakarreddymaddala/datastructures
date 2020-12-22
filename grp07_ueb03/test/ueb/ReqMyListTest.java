package ueb;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

/**
 * @author ite104673
 */
//TODO done: For all tests use empty lists if needed and not a list with the value 0 in it.
public class ReqMyListTest<Public> {
    /**
     * Creates a list with the given values.
     *
     * @param value values that should be inserted into the list
     * @return list with the given values
     */
    private MyList createList(int... value) {
        MyList list = new MyList();
        for (int i : value) {
            list.appendElement(i);
        }
        return list;
    }

    @Test
    public void testSum() {
        MyList list = createList(1, 2, 5);
        assertEquals(8, list.sum());
        list = createList(1, 2, 2, 3);
        assertEquals(8, list.sum());
        list = createList();
        assertEquals(0, list.sum());
    }

    @Test
    public void isSorted() {
        MyList list = createList(1, 2, 5);
        assertTrue(list.isSorted());
        list = createList(1, 2, 2, 3);
        assertTrue(list.isSorted());
        list = createList(2, 3, 1);
        assertFalse(list.isSorted());
    }

    @Test
    public void testExistsElement() {
        MyList list = createList(1, 2, 5);
        assertTrue(list.existsElement(1));
        assertTrue(list.existsElement(2));
        assertTrue(list.existsElement(5));
        assertFalse(list.existsElement(9));
        list = createList();
        assertFalse(list.existsElement(0));
        assertFalse(list.existsElement(8));
    }

    @Test
    public void testGetValueAt() {
        MyList list = createList(1, 2, 5);
        assertEquals(1, list.getValueAt(0));
        assertEquals(2, list.getValueAt(1));
        assertEquals(5, list.getValueAt(2));
        assertEquals(Integer.MAX_VALUE, list.getValueAt(-1));
    }

    @Test
    public void testSize() {
        MyList list = createList(1, 2, 5);
        assertEquals(3, list.size());
        list = createList(1);
        assertEquals(1, list.size());
        list = createList();
        assertEquals(0, list.size());
    }

    @Test
    public void testIsEmptyForNonEmptyValue() {
        MyList list = createList(1, 2, 5);
        assertFalse(list.isEmpty());
        list = createList(1);
        assertFalse(list.isEmpty());
        list = createList(0);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testInsertSortedIfUnique() {
        MyList list = createList(1, 2, 5);
        list.insertSortedIfUnique(3);
        assertEquals(4, list.size());
        assertArrayEquals(new int[]{1, 2, 3, 5}, list.toArray());
    }

    @Test
    public void testInsertSortedIfUnique_empty() {
        MyList list = createList();
        list.insertSortedIfUnique(3);
        assertEquals(1, list.size());
        assertArrayEquals(new int[]{3}, list.toArray());
    }

    @Test
    public void insert_sorted_if_unique() {
        MyList list = createList(100, 102, 103);
        list.insertSortedIfUnique(101);
        assertArrayEquals(new int[]{100, 101, 102, 103}, list.toArray());
    }

    @Test
    public void testInsertSortedIfUnique_first() {
        MyList list1 = createList(100, 101, 102, 103);
        list1.insertSortedIfUnique(99);
        assertEquals(5, list1.size());
        assertArrayEquals(new int[]{99, 100, 101, 102, 103}, list1.toArray());
    }

    @Test
    public void testInsertElement_empty() {
        MyList list1 = createList();
        list1.insertSortedIfUnique(99);
        assertEquals(1, list1.size());
        assertArrayEquals(new int[]{99}, list1.toArray());
    }



    @Test
    public void testDeleteAll() {
        MyList list = createList(1, 2, 5);
        list.deleteAll(1);
        assertEquals(2, list.size());
        assertArrayEquals(new int[]{2, 5}, list.toArray());
        MyList list1 = createList(1, 0, 0, 0, 2, 5);
        list1.deleteAll(0);
        assertEquals(3, list1.size());
        assertArrayEquals(new int[]{1, 2, 5}, list1.toArray());
    }

    @Test
    public void testDeleteAll_Emptylist() {
        MyList list = createList();
        assertTrue(list.isEmpty());
        list.deleteAll(1);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testInsertElementAt() {
        MyList list = createList(1, 2, 5);
        list.insertElementAt(11, 0);
        assertEquals(4, list.size());
        assertArrayEquals(new int[]{11, 1, 2, 5}, list.toArray());
    }

    @Test
    public void testInsertElementAt_Empty() {
        MyList list = createList();
        list.insertElementAt(11, 0);
        assertEquals(1, list.size());
        assertArrayEquals(new int[]{11}, list.toArray());
    }

    @Test
    public void testInsertElement_Empty() {
        MyList list = createList(2, 3, 4);
        list.insertElement(1);
        assertEquals(4, list.size());
        assertArrayEquals(new int[]{1, 2, 3, 4}, list.toArray());
    }

    @Test()
    public void exist_elements_empty() {
        MyList list = new MyList();
        assertFalse(list.existsElement(2));
        assertFalse(list.existsElement(5));
        assertFalse(list.existsElement(1));
        assertFalse(list.existsElement(0));
    }


    @Test
    public void testPrependElement_empty() {
        MyList list = createList();
        assertTrue(list.isEmpty());
        list.prependElement(1);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertArrayEquals(new int[]{1}, list.toArray());
    }

    @Test
    public void testPrependElement_nonEmpty() {
        MyList list = createList(2, 3, 4);
        assertFalse(list.isEmpty());
        list.prependElement(1);
        assertEquals(4, list.size());
        assertArrayEquals(new int[]{1, 2, 3, 4}, list.toArray());
    }
}
