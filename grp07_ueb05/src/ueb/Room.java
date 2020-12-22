package ueb;

/**
 * @author ITE104673 - Sudhakar Maddala
 */
public class Room {
    public static String SHORTCUT = "RO";
    Position topLeftCorner;
    Position bottomRightCorner;
    private final RoomUsage roomUsage;

    public String getAbbreviation() {
        return SHORTCUT;
    }

    Room(RoomUsage roomUsage, Position topLeftCorner, Position bottomRightCorner) {
        if (topLeftCorner == null || bottomRightCorner == null || roomUsage == null) {
            throw new IllegalArgumentException("Position is not Valid!");
        } else if (bottomRightCorner.getX() > topLeftCorner.getX() && bottomRightCorner.getY() > topLeftCorner.getY()) {
            this.topLeftCorner = topLeftCorner;
            this.bottomRightCorner = bottomRightCorner;
            this.roomUsage = roomUsage;
        } else throw new IllegalArgumentException("The BC is not further right");
    }

    public RoomUsage getRoomUsage() {
        return this.roomUsage;
    }

    public Position getPosTL() {
        return this.topLeftCorner;
    }

    public Position getPosBR() {
        return this.bottomRightCorner;
    }

    public String getShortcut() {
        return SHORTCUT;
    }

    Room(String abbreviatedStr) {
        if (abbreviatedStr == null || abbreviatedStr.split(",").length != 3) {
            throw new IllegalArgumentException("Position is not Valid!");
        } else {
            String[] stringArray = abbreviatedStr.trim().split(" ");
            checkandAssignCondition(new Position(stringArray[1].trim()), new Position(stringArray[2].trim()));
            this.roomUsage = RoomUsage.toRoomUsage(stringArray[0]);
        }
    }

    private void checkandAssignCondition(Position topLeftCorner, Position bottomRightCorner) {
        if (bottomRightCorner.getX() > topLeftCorner.getX() &&
                bottomRightCorner.getY() > topLeftCorner.getY()) {
            this.topLeftCorner = topLeftCorner;
            this.bottomRightCorner = bottomRightCorner;
        } else {
            throw new IllegalArgumentException("Br and LT is not further right or not further left");
        }

    }


    int calcBaseArea() {
        int x = bottomRightCorner.getX() - topLeftCorner.getX();
        int y = bottomRightCorner.getY() - topLeftCorner.getY();
        return x * y;
    }

    int calcEffectiveArea() {
        return this.calcBaseArea();
    }

    int calcLivingArea() {
        return this.calcBaseArea();
    }


    @Override
    public String toString() {
        //return String.format("%s %s %s %s", getShortcut(), roomUsage.getShortcut(), topLeftCorner, bottomRightCorner);
        return this.getShortcut()
                + " "
                + this.roomUsage.getShortcut()
                + " "
                + this.topLeftCorner.toString()
                + " "
                + this.bottomRightCorner.toString();
    }

    @Override
    public boolean equals(Object obj) {
//        if (obj instanceof Room) {
//            return ((Room) obj).roomUsage.equals(roomUsage) &&
//                    ((Room) obj).calcLivingArea() == calcLivingArea();
//        }
//        return false;
//    }
        if (obj instanceof Room) {
            Room room = (Room) obj;
            return this.roomUsage.equals(room.roomUsage)
                    && (this.calcLivingArea() == room.calcLivingArea()
                    || this.calcEffectiveArea() == room.calcEffectiveArea());
        } else {
            return false;
        }
    }
}
