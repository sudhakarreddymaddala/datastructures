package ueb;

/**
 * @author ITE104673 - Sudhakar Maddala
 */

/**
 * This class will extends the room class and inherits all the properties
 */
public class FunctionalSpace extends Room {
    RoomUsage roomUsage = RoomUsage.STAIRWAY;
    //  variable for FunctionalSpace
    public static String SHORTCUT = "FS";

    /**
     * Constructor with string parameter
     *
     * @param abbreviatedStr - the string which we are splitting
     */
    FunctionalSpace(String abbreviatedStr) {
        super(RoomUsage.STAIRWAY + " " + abbreviatedStr);
    }

    /**
     * Constructor with two parameters
     *
     * @param position  - first coordinate
     * @param position1 - second coordinate
     */
    public FunctionalSpace(Position position, Position position1) {
        super(RoomUsage.STAIRWAY, position, position1);
    }

    /**
     * getter method for room usage
     * @return - returns room usage enum
     */
    public RoomUsage getRoomUsage() {
        return this.roomUsage;
    }

    /**
     * getter method for shortcut
     * @return - returns the shortcut
     */
    public String getShortcut() {
        return SHORTCUT;
    }

    /**
     * this method will return zero when we call
     * @return - returns zero
     */
    public int calcEffectiveArea() {
        return 0;
    }

    /**
     * this method will return zero because there will be no living area
     * @return - returns zero
     */
    public int calcLivingArea() {
        return 0;
    }
}
