package ueb;

/**
 * @author ITE104673 - Sudhakar Maddala
 *
 */

/**
 *  This class will extends the room and inherits properties from parent class (room)
 */
public class CrawlSpace extends Room  {
    // variable for Crawlspace
    public static String SHORTCUT = "CS";

    /**
     * constructor with parameters and it will get the values from room class
     * @param roomUsage - Enum value
     * @param topLeftCorner - Top left position
     * @param bottomRightCorner - Bottom right position
     */
    CrawlSpace(RoomUsage roomUsage, Position topLeftCorner, Position bottomRightCorner) {
        super(roomUsage, topLeftCorner, bottomRightCorner);
    }

    /**
     * Constructor with string parameter
     * @param abbreviatedStr - the string which we are splitting
     */
    CrawlSpace(String abbreviatedStr) {
        super(abbreviatedStr);
    }

    /**
     * This is getter method for variable shortcut
     * @return - static string CS
     */
    public String getShortcut() {
        return SHORTCUT;
    }

    /**
     * This method will returns zero because living area in crawlspace is zero
     * @return - zero
     */
    public int calcLivingArea() {
        return 0;
    }
    }
