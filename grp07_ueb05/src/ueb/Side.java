package ueb;

/**
 * @author ITE104673 - Sudhakar Maddala
 */
public enum Side {
    TOP("TP"), RIGHT("RT"), BOTTOM("BM"), LEFT("LT");

    private final String shortcut;

    Side(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getShortcut() {
        return shortcut;
    }

    public boolean isLeftRight() {
        return this == LEFT || this == RIGHT;
    }

    public static Side toSide(String shortcut) {
        for (Side side : Side.values()) {
            if (side.shortcut.equals(shortcut)) {
                return side;
            }

        }
        throw new IllegalArgumentException(" Side Invalid");
    }
}
