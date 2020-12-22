package ueb;
//TODO - done: JavaDoc missing.
//FIXME - done: The author tag must be part of the JavaDoc for the class.

/**
 * This class will have one variable and the values will get from element class
 *
 * @author ite104673 Sudhakar Maddala
 */
//FIXME - done: Format the code properly.
public class MyList {
    private Element elements;

    //TODO done: JavaDoc missing.

    /**
     * to check the element list is empty or not
     *
     * @return - true if elements not empty else returns false
     */
    public boolean isEmpty() {
        return elements == null;
    }

    //TODO - done: JavaDoc missing.

    /**
     * This method will accepts the integer value and appends the value given
     * * @param value - the value to be appended in the element
     */
    public void appendElement(int value) {
        if (this.isEmpty()) {
            elements = new Element(value);
        } else
            elements = elements.appendElement(value);
    }

    //TODO -done: JavaDoc missing.

    /**
     * This method will accepts the integer value and deletes the given value if contains
     * * @param value - the value to be deleted in the element
     */
    public void deleteElement(int value) {
        if (!isEmpty()) {
            elements = elements.deleteElement(value);
        }
    }

    //TODO - done: JavaDoc missing.

    /**
     * This method will accepts the integer value and inserts the value given
     * * @param value - the value to be inserted in the element
     */
    public void insertElement(int value) {
        if (this.isEmpty()) {
            elements = new Element(value);
        } else {
            elements = elements.insertElement(value);
        }
    }

    /**
     * this method will converts the element into array
     *
     * @return - returns the converted array
     */
    int[] toArray() {
        if (isEmpty()) {
            return new int[]{};
        } else {
            int[] valueArray = new int[this.elements.size()];
            int i = 0;
            for (Element ptr1 = this.elements; ptr1 != null; ptr1 = ptr1.getNext()) {
                valueArray[i] = ptr1.getValue();
                i++;
            }
            return valueArray;
        }
    }

    //TODO -done: JavaDoc missing.

    /**
     * This method will return the size of the element.
     *
     * @return -- counts the number of elements
     */
    int size() {
        if (isEmpty()) {
            return 0;
        }
        return this.elements.size();
    }

    //TODO - done: JavaDoc missing.

    /**
     * This method will return the size of the element.
     *
     * @return -- counts the number of elements
     */
    int sum() {
        if (isEmpty()) {
            return 0;
        }
        return this.elements.sum();
    }

    //TODO -done: JavaDoc missing.
    //TODO -done: This method must also work for an empty list.

    /**
     * This will check if weather the elements is sorted in ascending order or not , if yes returns true
     * else returns false
     *
     * @return - If sorted in ascending true else false
     */
    boolean isSorted() {
        if (isEmpty()) {
            return false;
        }
        return this.elements.isSorted();
    }

    //TODO - done: JavaDoc missing.
    //TODO -done: This method must also work for an empty list.

    /**
     * This method will accepts the value as input and return true if value  exists else returns false
     *
     * @param value -- Input search the value in the element
     * @return -- true if value exists in the element, else false
     */
    boolean existsElement(int value) {
        if (isEmpty()) {
            return false;
        }
        return this.elements.existsElement(value);
    }

    //TODO -done: JavaDoc missing.
    //TODO -done: This method must also work for an empty list.
    //TODO -done: Read the description of the task. MyList has to also output "{" at the front and "}" at the back.
    //      Example: List 1 -> 2 -> 3 Expected: "{1, 2, 3}" not "1, 2, 3"

    /**
     * This method will returns the string with the current numerical value and separated by the spaces
     *
     * @return - string with numerical values followed by spaces
     */
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        return "{" + elements.toString() + "}";
    }


    //TODO - done: JavaDoc missing.
    //TODO - done: This method must also work for an empty list.

    /**
     * This method will accepts the index of the element and returns the value of that index if it is valid
     * else it will return Integer max value
     *
     * @param index Getting the value at this index
     * @return - returns the value at index if valid else return max_value
     */
    //FIXME - done: All parameters have to be described in JavaDoc.
    int getValueAt(int index) {
        if (isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return this.elements.getValueAt(index);
    }

    //TODO -done: JavaDoc missing.
    //TODO - done: This method must also work for an empty list.
    //TODO2 - done: The method still not works correctly for an empty list. In the case of an empty list I expect that the
    //       value is inserted as the first element if the index is 0. Here the return value is null and the list still remains empty.
    //TODO -done: Also inserting at the front must work. Use the return value of the element.insertElementAt(...) call.
    //TODO2 - done: Inserting a value at the front of the list with the index 0 still not works. With the index 0 the value
    //       should be added as the first element of the list. After inserting a value at the index 0 into a list with 3
    //       elements I expect a list with 4 Elements and the new value at the front of the list. Here the list remains untouched.

    /**
     * This method will accepts the value and index and returns current object if index is negative
     * and index greater then size. if index is zero then we are inserting the value at that index.
     * if index is not equal to zero then we are iterating recursively by decreasing the index value.
     *
     * @param value - Insertion value in the element
     * @param index - Inserting the value at this index
     */
    //FIXME - done: Following the description of the task, the return typ of this method must be void.
    //       You are not allowed to change the return typ of a given method.
    public void insertElementAt(int value, int index) { //{1, 2, 3} value = 0, index = 0 elements => (1, (2, (3, null)))
        if (isEmpty() && index == 0) {
            this.elements = new Element(value);
        } else if (!isEmpty()) {
            this.elements = this.elements.insertElementAt(value, index); //{0, 1, 2, 3} elements => (0, (1, (2, (3, null))))
        }
    }

    //TODO -done: JavaDoc missing.
    //TODO - done: This method must also work for an empty list.
    //TODO2 - done: The method still not works correctly for an empty list. In the case of an empty list I expect that the
    //       value is inserted as the first element. Here the return value is null and the list still remains empty.
    //TODO - done: This must work for the front of the list. Use the return value.
    //TODO2 - done: The prepend is still not working at all. It should add the given value at the front of the list, but this
    //       never happens. After prepending a value to a list with 3 elements I expect a list with 4 Elements and the
    //       new value at the front of the list. Here the list remains untouched.

    /**
     * This method will accepts the integer value and prepends the value given.
     *
     * @param value - appends the value to the existing element
     */
    //FIXME -done: Following the description of the task, the return typ of this method must be void.
    //       You are not allowed to change the return typ of a given method.
    public void prependElement(int value) {
        if (isEmpty()) {
            this.elements = new Element(value);
        } else {
            this.elements = this.elements.prependElement(value);
        }
    }

    /**
     * This method will accepts the integer value and inserts the value if unique
     *
     * @param value - the value to be inserted if unique
     */
    //TODO -done: This must work for the front of the list. Use the return value.
    //TODO2 -done: Inserting a value at the front of the list (because the value is less then the current value at the front
    //       of the list) still not works. If the value is less then the first value of the list the value should be
    //       added as the first element of the list. After inserting a value at front into a list with 3 elements I expect
    //       a list with 4 Elements and the new value at the front of the list. Here the list remains untouched.
    //FIXME -done: Following the description of the task, the return typ of this method must be void.
    //       You are not allowed to change the return typ of a given method.
    //FIXME -done: This must also work for an empty list. In this case the value is always unique and can directly be inserted.
    public void insertSortedIfUnique(int value) {
        if (isEmpty()) {
            this.elements = new Element(value);
        } else if (!existsElement(value)) {
            this.elements = this.elements.insertElement(value);
        }
    }

    //TODO done: JavaDoc missing.
    //TODO -done: This method must also work for an empty list.
    //TODO- done: This must also work if one of the elements to delete is at the front of the list.
    //TODO2 -done: If one of the elements to delete is at the front of the list it is not deleted but remains in the list.

    /**
     * This method will accepts the value which needs to be deleted and returns the element
     * after deleting the value in all the positions which is available in the element
     *
     * @param value - The value to be deleted in the element
     */
    //FIXME -done: Following the description of the task, the return typ of this method must be void.
    //       You are not allowed to change the return typ of a given method.
    public void deleteAll(int value) {
        if (!isEmpty()) {
            this.elements = this.elements.deleteAll(value);
        }
    }
}
