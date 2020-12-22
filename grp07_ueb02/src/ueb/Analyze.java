package ueb;

import static ueb.ArrayTools.*;

/**
 * Methods to manage the transport from products from warehouses to customers by
 * drone.
 *
 * @author Mo, klk
 */
public class Analyze {

//<editor-fold defaultstate="collapsed" desc="constants">
    /**
     * signs to show for printing the map.
     */
    public static final String SIGN_WAREHOUSE = "W";
    public static final String SIGN_CUSTOMER = "C";
    public static final String SIGN_EMPTY = "E";

    /**
     * position of service-station of the drone {@code POS_SERVICE}
     */
    static int[] POS_SERVICE = { 0, 0 };
    // TODO insert code that makes sense
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="attributes">
    /**
     * the amount of units the drone flew. Default is 0. {@code units}
     */
    static int units = 0;
    // TODO insert code that makes sense
    /**
     * the current map working on. Default is the Map from Data.{@code map}
     */
    static int[][][] map = Data.getMap();
    // TODO insert code that makes sense
    /**
     * the current position of the Drone. Default is POS_SERVICE. {@code posDrone}
     */
    static int[] posDrone = POS_SERVICE.clone();
    // TODO insert code that makes sense
    static int flownUnits = 0;
    static int productCount = 0;
    static int storedArray[] = new int[] {};
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="init">

    /**
     * resetting every value to its default
     */
    public static void resetToOrigState() {
        // TODO insert code that makes sense
        units = 0;
        map = Data.getMap();
        posDrone = POS_SERVICE.clone();
        flownUnits = 0;
        productCount = 0;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="output">

    /**
     * Prints the current map to sout. The signs declared in constants at begin of
     * the class are used to visualize the cells.
     */
    public static void printCurrentState() {
//		TODO insert code that makes sense
        System.out.println("---------------------------------------");
        int B[][] = new int[map[0].length][map.length];
        String B1[][] = new String[map[0].length][map.length];
        int row1 = 0, col1 = 0;
        for (int i[][] : map) {
            col1 = 0;
            for (int j[] : i) {
                String str = m1(j);
                B1[col1][row1] = str;
                col1++;
            }
            row1++;
        }
        for (String[] str : B1) {
            for (String str1 : str) {
                System.out.print(str1);
            }
            System.out.println();
        }
        System.out.println("Drone now at 0/0 flew " + flownUnits + " units");
        System.out.println("---------------------------------------");
        resetToOrigState();
    }

    /**
     * Determines the maximum length of a given {@code column} in the map-array.
     * Used for nice output only.
     *
     * @param column the given column
     * @return the maximum of the length of all cells in the given {@code column}
     *         plus 1 (for the unique identifier of one's cell N, O or W)
     */
    static int getPrintWidthPerColumn(int column) {
        // TODO insert code that makes sense
        int row = 0;
        int max = 0;
        for (int[][] i : map) {
            if (row == column) {
                return ArrayTools.getLengthOfLongestArray(i) + 1;
            }
            row++;
        }
        return 0;
    }
    // </editor-fold>

//<editor-fold defaultstate="collapsed" desc="helping methods">

    /**
     * Calculate the Euclidean distance between two points. Math.sqrt(), Math.pow()
     * and Math.ceil() are used.
     *
     * @param pos1 the first point
     * @param pos2 the second point
     * @return the Euclidean distance between those two points, Integer.MAX_VALUE if
     *         param is invalid
     */
    static int calcDistanceBetween(int[] pos1, int[] pos2) {
        // TODO insert code that makes sense
        if (pos1 == null || pos2 == null) {
            return Integer.MAX_VALUE;
        }
        int a = pos2[0] - pos1[0];
        int b = pos2[1] - pos1[1];
        int distance = (int) Math.ceil(Math.sqrt((a * a) + (b * b)));
        return distance;
    }

    /**
     * Checks if the given position is valid in the map.
     *
     * @param pos an array with
     * @return true, if pos is a valid position in the map
     */
    static boolean isValidPosition(int[] pos) {
        // TODO insert code that makes sense
        if (pos != null && pos.length == 2) {
            if (pos[0] < map.length && pos[0] >= 0 && pos[1] < map[0].length && pos[1] >= 0) {
                return true;
            }
        }
        return false;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="working methods">

    /**
     * Flies the drone from current position to a the given position via Euclidean
     * distance. Prints the destination and flewn distance. Changes the attributes
     * {@code units} and {@code posDrone}. If the given position isn_t valid, a
     * message on serr is shown.
     *
     * @param pos the position to fly to
     */
    private static void flyDroneTo(int[] pos) {
        // TODO insert code that makes sense
        if (!isValidPosition(pos)) {
            System.err.println("Drone current position is not valid");
        }
        units = calcDistanceBetween(POS_SERVICE, pos);
        if (units != Integer.MAX_VALUE) {
            POS_SERVICE = pos.clone();
            flownUnits = flownUnits + units;
            System.out.println("fly drone to " + pos[0] + "/" + pos[1] + " distance " + units);
        }
    }

    /**
     * Transports one product of an order to a specified position with the drone.
     * Flies drone to from, collects count of ordered products at from and flies
     * drone to to. If there aren't enough products at from, the remaining count of
     * the order is given as result. If from or to is not a valid position, a
     * message is given at System.err. If the product is not at from, a message is
     * given at System.err.
     *
     * @param from    the position of the warehouse to get the product at
     * @param to      the position to transport to
     * @param product product to transport
     * @param count   count of products to transport
     * @return count of products still to transport
     */
    private static int transportSameProducts(int[] from, int[] to, int product, int count) {
        // TODO insert code that makes sense
        int row = 0, col = 0, index = 0;
        int[] updatedArray = null;
        if (!isValidPosition(from)) {
            System.err.println("The from warehouse Location is not valid ");
        }
        if (!isValidPosition(to)) {
            System.err.println("The to customer Location is not valid ");
        }
        for (int[][] i : map) {
            col = 0;
            for (int[] j : i) {
                if (row == from[0] && col == from[1]) {
                    for (int x = 1; x <= count; x++) {
                        index = ArrayTools.containsAt(j, product);
                        if (index >= 0) {
                            updatedArray = ArrayTools.deleteElementAt(j, index);
                            j = updatedArray;
                            storedArray = ArrayTools.insertElementAt(storedArray, productCount, product);
                            productCount++;
                            map[row][col] = updatedArray;
                        }
                    }
                }
                col++;
            }
            row++;
        }
        row = 0;
        for (int[][] i : map) {
            col = 0;
            for (int[] j : i) {
                if (row == to[0] && col == to[1]) {
                    map[row][col] = storedArray;
                    posDrone[0] = row;
                    posDrone[1] = col;
                }
                if (row == from[0] && col == from[1]) {
                    map[from[0]][from[1]] = updatedArray;
                    posDrone[0] = row;
                    posDrone[1] = col;
                }
                col++;
            }
            row++;
        }
        return count - storedArray.length;
    }

    /**
     * Determines the nearest warehouse for a specified position and product.
     *
     * @param pos     the starting point
     * @param product the product
     * @return the nearest (Euclidean distance) warehouse position having the
     *         {@code product}; {@code null} if there is no warehouse having the
     *         product
     */

    private static int[] findNearestWarehouse(int[] pos, int product) {
        // TODO insert code that makes sense
        int row = 0, col = 0, index = 0, ed = 0;
        int[] res = new int[] { -1, -1, Integer.MAX_VALUE };
        boolean b = false;
        for (int[][] i : map) {
            col = 0;
            for (int[] j : i) {
                if (isValidPosition(new int[] { row, col })) {
                    b = Data.isWarehouse(row, col);
                }
                if (b) {
                    index = ArrayTools.containsAt(j, product);
                    if (index >= 0) {
                        ed = calcDistanceBetween(pos, new int[] { row, col });
                        if (ed < res[2]) {
                            res[0] = row;
                            res[1] = col;
                            res[2] = ed;
                        }
                    }
                }
                col++;
            }
            row++;
        }
        if (res[0] == -1 && res[1] == -1) {
            return null;
        }
        return new int[] { res[0], res[1] };
    }

    /**
     * Transports an order-series by the drone. Process every order of the series.
     * Prints the values of the order. Searches for the nearest warehouse with the
     * product, transports the ordered number of the product to the target address.
     * If the first detected warehouse doesn_t hold enough of the product, the next
     * warehouse with the product has to be used. If there is no warehouse with the
     * product, a message on System.err is printed. After all orders have been
     * delivered, the drone flies to the service-station.
     *
     * @param orders the order-series working on
     * @throws IllegalArgumentException if {@code null} is given as param
     */
    public static void transportOrdersOfOneSeries(int[][] orders) {
        // TODO insert code that makes sense
        int a = 0, b = 0, WareHouseCount = 0, row = 0, col = 0, remainingItems = 0;
        int warehouse[] = null, count = 0;
        if (orders == null) {
            throw new IllegalArgumentException();
        }
        for (int[][] i : map) {
            col = 0;
            for (int[] j : i) {
                if (isValidPosition(new int[] { row, col }))
                    if (Data.isWarehouse(row, col)) {
                        WareHouseCount++;
                    }
                col++;
            }
            row++;
        }
        for (int[] order : orders) {
            remainingItems = order[Data.CT];
            System.out.println("deliver " + order[Data.CT] + " of product " + order[Data.ID] + " to" + " (" + order[Data.X] + "/" + order[Data.Y] + ")");

            /*
             * if (warehouse == null) { System.err.println("Error: " + quantity +
             * " of product " + product + " missing in warehouses"); }
             */
            while (remainingItems > 0 && WareHouseCount != 0) {
                warehouse = findNearestWarehouse(new int[] { a, b }, order[Data.ID]);
                flyDroneTo(warehouse);
                flyDroneTo(new int[] { order[Data.X], order[Data.Y] });
                WareHouseCount--;
                /*
                 * if (warehouse == null) { System.err.println("Error: " + quantity +
                 * " of product " + product + " missing in warehouses"); }
                 */
                // if (warehouse != null && warehouse.length >= 0) {
                remainingItems = transportSameProducts(warehouse, new int[] { order[Data.X], order[Data.Y] }, order[Data.ID], order[Data.CT]);
                // }
                count++;
            }
            a = POS_SERVICE[0];
            b = POS_SERVICE[1];
        }
        flyDroneTo(new int[] { 0, 0 });
        if (remainingItems > 0) {
            System.err.println("Pending Items are there" + remainingItems);
        }
    }

    public static String m1(int[] j) {
        StringBuffer str = new StringBuffer();
       if (j != null && j.length > 0) {
            str.append(SIGN_WAREHOUSE);
            for (int k : j) {
                str.append(k);
            }
            str.append(" ");
        } else {
            str.append(SIGN_EMPTY +" ");
        }
        return str.toString();
    }

    // </editor-fold>
}
