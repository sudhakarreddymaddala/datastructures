package ueb;

//TODO - done: JavaDoc missing.
//FIXME - done: The author tag must be part of the JavaDoc for the class.

/**
 * This class will have two variables and two constructors.
 * This class will be called when we call argument constructor
 *
 * @author ite104673 Sudhakar Maddala
 */
public class Element {
    private int value;
    private Element next;

    //TODO -done: JavaDoc missing.

    /**
     * Argumented constructor with two arguments
     *
     * @param value - Input value
     * @param next  - next element in the list
     */
    public Element(int value, Element next) {
        this.value = value;
        this.next = next;
    }

    //TODO -done: JavaDoc missing.

    /**
     * Single argument constructor
     *
     * @param v - Value of this constructor
     */
    Element(int v) {
        this.value = v;
    }

    //TODO -done: JavaDoc missing.

    /**
     * getter method for value
     *
     * @return - returns the value when get value is called
     */
    public int getValue() {
        return value;
    }

    //TODO - done: JavaDoc missing.

    /**
     * getter method for next
     *
     * @return - returns the next value
     */
    public Element getNext() {
        return next;
    }

    /**
     * This method will return the size of the element.
     *
     * @return -- counts the number of elements
     */
    int size() {
        int count = 0;   // Assuming no linked list
        if (this.next == null) {
            count = count + 1;
        } else {
            count++;
            count = count + this.next.size(); //
        }
        return count;
        //return this.next == null ? 1 : 1 + this.next.size();
    }

    /**
     * This method will returns the sum of the "this" and all sub sequent elements in list
     *
     * @return -- sum of elements
     */
    int sum() {
        int sum = 0;
        if (this.next == null) {
            sum = sum + this.value;
        } else {
            sum = this.value + this.next.sum();
        }
        return sum;
    }

    /**
     * This method will accepts the value as input and return true if value  exists else returns false
     *
     * @param value -- Input search the value in the element
     * @return -- true if value exists in the element, else false
     */
    boolean existsElement(int value) {
        if (this.value == value) {
            return true;
        } else if (this.next != null) {
            return this.next.existsElement(value);
        }
        return false;
    }

    /**
     * This method will returns the string with the current numerical value and separated by the spaces
     *
     * @return - string with numerical values followed by spaces
     */
    public String toString() {
        String sum = "";
        if (this.next == null) {
            sum = sum + this.value + "";
        } else {
            sum = this.value + " " + this.next.toString();
        }
        return sum;
    }

    /**
     * This method will accepts the index of the element and returns the value of that index if it is valid
     * else it will return Integer max value
     *
     * @param index - Getting the value at this index
     * @return - returns the value at index if valid else return max_value
     */
    //TODO - done: Complete the JavaDoc.
    //FIXME - done: All parameters have to be described in JavaDoc.
    int getValueAt(int index) {
        if (index == 0) {
            return this.value;
        } else if (this.next != null) {
            return this.next.getValueAt(index - 1);
        }
        return Integer.MAX_VALUE;
    }

    /**
     * This method will accepts the value and index and returns current object if index is negative
     * and index greater then size. if index is zero then we are inserting the value at that index.
     * if index is not equal to zero then we are iterating recursively by decreasing the index value.
     *
     * @param value - Insertion value in the element
     * @param index - Inserting the value at this index
     * @return - element after inserting the value at specified index
     */
    Element insertElementAt(int value, int index) {
        if (index < 0 || index > this.size()) {
            return this;
        }
        if (index == 0) {
            return prependElement(value);
        } else if (this.next != null) {  // To move the pointer to desired location
            this.next = this.next.insertElementAt(value, index - 1);
            return this;
        } else {
            return this.appendElement(value);
        }
    }

    /**
     * This method will accepts the integer value and appends the value given.
     *
     * @param value - appends the value to the existing element
     * @return - returns the updated element
     */
    Element prependElement(int value) {
         return new Element(value, this);
    }

    /**
     * This will check if weather the elements is sorted in ascending order or not , if yes returns true
     * else returns false
     *
     * @return - If sorted in ascending true else false
     */
    boolean isSorted() {

        if (next == null) {
            return true;
        }
        if (getValue() > next.getValue()) {
            return false;
        }
        return next.isSorted();
    }

    /**
     * This method will accepts the value which needs to be deleted and returns the element
     * after deleting the value in all the positions which is available in the element
     *
     * @param value - The value to be deleted in the element
     * @return - if value exists then returns the updated element and
     * if element not exists current object will be returned
     */
    //TODO -done: Use the return value of the recursive call. This method must delete all occurrences of the given value
    //      from the list. Example: {1, 0, 0, 0, 2} value = 0 Expected: {1, 2} and not {1, 0, ...}
    Element deleteAll(int value) {
        if (this.value == value) {
            if (this.next != null) {
                this.next = this.next.deleteAll(value);
            } else {
                return null;
            }
        } else {
            if (this.next != null) {
                this.next = this.next.deleteAll(value);
            }
            return this;
        }
        return next;
    }

    /**
     * This method will accepts the integer value and appends the value given
     * * @param value - the value to be appended in the element
     *
     * @return - returns the updated element with appended value
     */
    public Element appendElement(int value) {
        if (this.next == null) {
            this.next = new Element(value, null);
        } else {
            this.next = this.next.appendElement(value);
        }
        return this;
    }

    /**
     * This method will accepts the integer value and inserts the value given
     * * @param value - the value to be inserted in the element
     *
     * @return - returns the updated element with inserted value
     */
    public Element insertElement(int value) {
        if (this.value > value) {
            return new Element(value, this);
        } else if (this.next == null) {
            this.next = new Element(value, null);
            return this;
        } else {
            this.next = this.next.insertElement(value);
            return this;
        }
    }

    /**
     * This method will accepts the integer value and deletes the given value if contains
     * * @param value - the value to be deleted in the element
     *
     * @return - returns the updated element after deleting value
     */
    public Element deleteElement(int value) {
        if (this.value == value) {
            return this.next;
        } else {
            if (this.next != null) {
                this.next = this.next.deleteElement(value);
            }
            return this;
        }
    }
}