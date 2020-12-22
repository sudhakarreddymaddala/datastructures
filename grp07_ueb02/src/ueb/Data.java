package ueb;

/**
 * Contains the data to analyze: private constants - the whole map containing a
 * snapshot of the current product-allocation - a list of order-series, each
 * order-series contains a list of multiple orders, each order contains a list
 * of order details (dimension of an order, s.b.)
 * <p>
 * public constants determine the sequence of the dimensions of an order
 * <p>
 * public getter - get the dimensions of the box - get the count of orderseries
 * - get one orderseries containing multiple orders - get the map of the initial
 * situation
 *
 * @author Mo, klk
 */
public class Data {

    /**
     * The simulation takes place on a two-dimensional non-cyclic map: 10x7. The
     * specified map represents a snapshot of the current product-allocation At
     * every coordinate of the map it is known whether there is nothing (empty
     * array) or a warehouse: Each warehouse initially stocks a known number of
     * product items of each product type. Any warehouse does not necessarily need
     * to have every product type available.
     */
//    map as shown on system.out
//    private static final int[][][] MAP_ROTATED = {
//        {{1,1,3,3,4,4,4,4}, {E}, {E}, {}, {} , {}, {}   , {}, {}, {}},
//        {{}               , {}, {}, {}, {} , {}, {}   , {}, {}, {}},
//        {{}               , {}, {}, {}, {} , {}, {}   , {}, {}, {}},
//        {{2,2}            , {}, {}, {}, {} , {}, {3,4}, {}, {}, {}},
//        {{}               , {}, {}, {}, {} , {}, {}   , {}, {}, {}},
//        {{}               , {}, {}, {}, {} , {}, {}   , {}, {}, {}},
//        {{}               , {}, {}, {}, {0}, {}, {}   , {}, {}, {}}
//    };
    // 10 columns, 7 rows, addressed by (x,y) or (col, row)
    // a row in the declaration is a column when accessed/printed
    private static final int[][][] MAP = { { { 1, 1, 3, 3, 4, 4, 4, 4 }, {}, {}, { 2, 2 }, {}, {}, {} },
            { {}, {}, {}, {}, {}, {}, {} }, { {}, {}, {}, {}, {}, {}, {} }, { {}, {}, {}, {}, {}, {}, {} },
            { {}, {}, {}, {}, {}, {}, { 0 } }, { {}, {}, {}, {}, {}, {}, {} }, { {}, {}, {}, { 3, 4 }, {}, {}, {} },
            { {}, {}, {}, {}, {}, {}, {} }, { {}, {}, {}, {}, {}, {}, {} }, { {}, {}, {}, {}, {}, {}, {} } };

    /* ORDER_CONSTANTS: classifying the sequence of every order */
    public static final int X = 0; // x-coordinate of the deliverylocation
    public static final int Y = 1; // y-coordinate of the deliverylocation
    public static final int ID = 2; // ID of the product as part of ones Order
    public static final int CT = 3; // Count of the specific product to order

    /**
     * array of an order-series of multiple customers: Each order-series specifies
     * all product items purchased by the customer, grouped in single orders. Each
     * order consists of one product item purchased by the customer, but it can
     * contain multiple product items of the same product type and specifies the
     * cell in the grid where the productitems have to be deliver- ed. It is
     * possible to have multiple orders with the same delivery cell.
     */
    private static final int[][][] ORDER_SERIES = { { // series 0
            { 1, 2, 0, 1 }, // customer at (1,2) orders product 0, 1 times
    }, { // series 1
            { 1, 2, 0, 1 }, // customer at (1,2) orders product 0, 1 times
            { 1, 2, 1, 1 }, // customer at (1,2) orders product 1, 1 times
            { 8, 5, 3, 3 } // customer at (8,5) orders product 3, 3 times
    }, { // series 2
            { 7, 4, 4, 5 }, // customer at (7,4) orders product 4, 5 times
            { 0, 6, 0, 1 } // customer at (0,6) orders product 0, 1 times
    }, { // series 3
            { 7, 4, 0, 5 } // customer at (7,4) orders product 0, 5 times
    } };

    /**
     * Get the dimensions of the map. First value contains the number of columns,
     * second the number of rows.
     *
     * @return the dimensions of the map {noOfColumns, noOfRows}
     */
    public static int[] getMapDimensions() {
        // TODO insert code that makes sense
        return new int[] { MAP[0].length, MAP.length };
    }

    /**
     * Get the amount of series.
     *
     * @return the amount of series
     */
    public static int getNoOfSeries() {
        // TODO insert code that makes sense
        return ORDER_SERIES.length;
    }

    /**
     * If products are at this position it has to be a warehouse.
     *
     * @param posX position of cell to check
     * @param posY position of cell to check
     * @return true, if there is a warehouse
     */
    public static boolean isWarehouse(int posX, int posY) {
        return MAP[posX][posY].length > 0;
    }

    /**
     * Gets a (deep!) copy of the productlist of one orderseries.
     *
     * @param idx idx of the orderseries
     * @return a copy of the productlist of one orderseries
     * @throws IllegalArgumentException if the idx isn't valid
     */
    public static int[][] getOrderSeries(int idx) {
        // TODO insert code that makes sense
        int[][] orderSeries = null;
        if (idx >= 0 && idx < ORDER_SERIES.length) {
            orderSeries = new int[ORDER_SERIES[idx].length][];
            for (int i = 0; i < ORDER_SERIES[idx].length; i++) {
                orderSeries = ORDER_SERIES[idx].clone();
                for (int j = 0; j < orderSeries.length; j++) {
                    orderSeries[j] = ORDER_SERIES[idx][j].clone();
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
        return orderSeries;
    }

    /**
     * Gets a (deep!) copy of the whole map of the initial situation.
     *
     * @return a copy of the whole map of the initial situation.
     */
    public static int[][][] getMap() {
        // TODO insert code that makes sense
        int[][][] cloneMap = new int[MAP.length][][];
        for (int i = 0; i < MAP.length; i++) {
            cloneMap[i] = MAP[i].clone();
            for (int j = 0; j < MAP[i].length; j++) {
                cloneMap[i][j] = MAP[i][j].clone();
            }
        }
        return cloneMap;
    }
}
