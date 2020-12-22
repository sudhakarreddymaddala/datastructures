package ueb;

/**
 * @author ITE104673 - Sudhakar Maddala
 */
public class RoofRoom extends Room {

    private Side side;

    public static String SHORTCUT = "RR";

    public String getShortcut() {
        return SHORTCUT;
    }

    // utility (effective) area = base area
    private int distance;

    RoofRoom(String abbreviatedStr) {
        super(abbreviatedStr.split(" ")[0]
                + " " + abbreviatedStr.split(" ")[1]
                + " " + abbreviatedStr.split(" ")[2]);
        this.side = Side.toSide(abbreviatedStr.split(" ")[3]);
        this.distance = Integer.parseInt(abbreviatedStr.split(" ")[4]);
    }

    public RoofRoom(RoomUsage roomUsage, Position position1, Position position2, Side side, int distance) {
        super(roomUsage, position1, position2);
        this.side = side;
        this.distance = distance;
    }


    public String toString() {
        return super.toString() + " " + this.side.getShortcut() + " " + this.distance;
    }

    public boolean equals(Object obj){
        if (obj instanceof RoofRoom) {
            RoofRoom roofRoom = (RoofRoom) obj;
            return (roofRoom.side.isLeftRight() || this.side.equals(roofRoom.side))
                    && this.distance == roofRoom.distance
                    && super.equals(roofRoom);
        } else {
            return false;
        }
    }
    public int calcLivingArea() {
        int length = this.getPosBR().getX() - this.getPosTL().getX();
        int width = this.getPosBR().getY() - this.getPosTL().getY();
        return  (calcIndividualArea(distance,width,0)  +
                calcIndividualArea(distance,width,50 ) +
                calcIndividualArea(distance,width,100));

    }
    private int calcIndividualArea(int distto1m, int width, int percentage){

        return ((distto1m*width/100)*percentage);
    }

}
