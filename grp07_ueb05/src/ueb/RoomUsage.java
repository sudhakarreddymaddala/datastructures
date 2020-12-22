package ueb;

/**
 * @author ITE104673 - Sudhakar Maddala
 */
public enum RoomUsage {
    HALLWAY("HA"), BATH("BA"), COOK("CO"), LIVE("LI"),
    WORK("WO"), SLEEP("SL"), SAUNA("SA"), STORE("ST"),
    STAIRWAY("SW");

    private final String shortcut;

    RoomUsage(String shortcut) {

        this.shortcut = shortcut;
    }



    public static RoomUsage toRoomUsage(String shortcut) {
        for (RoomUsage roomUsage : values()) {
            if (roomUsage.shortcut.equals(shortcut)) {
                return roomUsage;
            }
        }throw new IllegalArgumentException(" RoomUsage Invalid");

    }

    public String getShortcut() {
        return shortcut;
    }
}

