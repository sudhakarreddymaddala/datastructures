package ueb;

import java.util.Arrays;

/**
 * @author ITE104673 - Sudhakar Maddala
 */
public class Flat {
    String rooms[];
    int roomLength =0;


    // empty new Flat()
    Flat() {
        roomLength = 0;
    }

    // (e.g. new Flat(new Room("BA 0,0 4,5"), new RoofRoom("SL 40,0 60,60 RT 15")))
    Flat(Room room, RoofRoom roofRoom) {

    }

    // new Flat("FS 2,2 4,4\n" + "CS ST 2,2 4,4\n" + "RR BA 20,50 65,70 RT 10");
    Flat(String rooms) {
        this.rooms = rooms.split("\n");
    }

    public Flat(Room room, Room room1, Room room2) {
    String roomNo1 =String.valueOf(room);
    String roomNo2 =String.valueOf(room1);
    String roomNo3 =String.valueOf(room2);
    String array[]={roomNo1,roomNo2,roomNo3};
       this.roomLength=this.roomLength+array.length;


    }

    public Flat(Room room) {
        this.roomLength=this.roomLength+1;
    }

    int getCountOfRooms() {
        return roomLength;
    }



    int add(Room room) {
        if (room == null) {
            throw new IllegalArgumentException("INVALID room. Adding room is not possible");
        }
        this.roomLength = this.roomLength+1;
        /*this.rooms = Arrays.copyOf(this.rooms, newLength);
        this.rooms[newLength] = room.toString();*/
        return this.roomLength;
    }

    int calcBaseArea() {
        // FIXME multiplying the lengths of the sides of the room
        String room1 = this.rooms[0];
        String [] room1Attributes = room1.split(" ");
        String [] room1FirstXY =room1Attributes[2].split(",");
        String [] room1SecondXY =room1Attributes[3].split(",");
        int x1=  Integer.parseInt(room1SecondXY[0])-Integer.parseInt(room1FirstXY[0]);
        int y1=  Integer.parseInt(room1SecondXY[1])-Integer.parseInt(room1FirstXY[1]);
        int sum1 = x1*y1;

        String room2 = this.rooms[1];
        String [] room2Attributes = room2.split(" ");
        String [] room2FirstXY =room2Attributes[2].split(",");
        String [] room2SecondXY =room2Attributes[3].split(",");
        int x2=  Integer.parseInt(room2SecondXY[0])-Integer.parseInt(room2FirstXY[0]);
        int y2=  Integer.parseInt(room2SecondXY[1])-Integer.parseInt(room2FirstXY[1]);
        int sum2 = x2*y2;

        String room3 = this.rooms[2];
        String [] room3Attributes = room3.split(" ");
        String [] room3FirstXY =room3Attributes[2].split(",");
        String [] room3SecondXY =room3Attributes[3].split(",");
        int x3=  Integer.parseInt(room3SecondXY[0])-Integer.parseInt(room3FirstXY[0]);
        int y3=  Integer.parseInt(room3SecondXY[1])-Integer.parseInt(room3FirstXY[1]);
        int sum3 = x3*y3;

        int sum = sum1+sum2+sum3;
        return sum;
    }

    int calcEffectiveArea() {
        return this.calcBaseArea();
    }

    int calcLivingArea() {
        return this.calcBaseArea();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.rooms.length)
                .append(" rooms with base area ").append(calcBaseArea())
                .append(", effective area ").append(calcEffectiveArea())
                .append(" und living area ").append(calcLivingArea());
        for (String room : this.rooms) {
            str.append(room);
            str.append("\n");
        }
        return str.toString();
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = true;
        // FIXME Two flats are equal, if they contain the same rooms in the same order and not less and not more.
        //  Use Room.equals() to determine if two rooms are equal.
        return true;
    }
}
