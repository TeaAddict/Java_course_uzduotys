public class Room {
    private String code;
    private int seats;

    public Room(String classCode, int numberOfSeats){
        code = classCode;
        seats = numberOfSeats;
    }

    public String getCode() {
        return code;
    }

    public int getSeats() {
        return seats;
    }

    public String toString(){
        return "code=" + code + ", seats=" + seats;
    }
}
