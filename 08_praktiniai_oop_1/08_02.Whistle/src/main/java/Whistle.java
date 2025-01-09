public class Whistle {
    private String reservedSound;

    public Whistle(String whistleSound){
        reservedSound = whistleSound;
    }

    public void sound(){
        System.out.println(reservedSound);
    }
}
