package ueb;

/**
 * @author ITE104673 - Sudhakar Maddala
 */

/**
 * this class  will accepts x and y coordinates and validates the position
 */
public class Position {
    private final int X_Pos;
    private final int Y_Pos;

    /**
     * constructor with two parameters
     * @param x - x coordinate
     * @param y - y coordinate
     */
    public Position(int x, int y) {
        this.X_Pos = x;
        this.Y_Pos = y;
    }

    /**
     * getter method for x-coordinate
     * @return - returns x-position
     */
    public int getX() {
        return this.X_Pos;
    }

    /**
     * getter method for y-coordinate
     * @return - returns y-position
     */
    public int getY() {
        return this.Y_Pos;
    }

    /**
     * This method will accepts string position and gives valid if
     * @param position
     */
    Position(String position) {
        if (position == null || !position.contains(",") || position.trim().split(",").length != 2) {
            throw new IllegalArgumentException("position not valid.");
        } else {
            String[] str = position.trim().split(",");
            this.X_Pos = Integer.parseInt(str[0].trim());
            this.Y_Pos = Integer.parseInt(str[1].trim());
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() == null || obj == null || obj.getClass() == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else {
            String[] split = obj.toString().trim().split(",");
            return Integer.parseInt(split[0]) == getX() && Integer.parseInt(split[1]) == getY();
        }
    }

    @Override
    public String toString() {
        return getX() + "," + getY();
    }


}
