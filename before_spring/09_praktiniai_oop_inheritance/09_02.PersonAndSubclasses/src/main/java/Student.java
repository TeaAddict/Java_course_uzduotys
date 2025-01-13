public class Student extends Person {

    private int credits = 0;

    public Student(String name, String street) {
        super(name, street);
    }

    public void study(){
        credits++;
    }
}
