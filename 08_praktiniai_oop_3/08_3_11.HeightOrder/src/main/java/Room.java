import java.util.ArrayList;

public class Room {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        persons.add(person);
    }

    public boolean isEmpty(){
        return persons.isEmpty();
    }

    public ArrayList<Person> getPersons(){
        return persons;
    }

    public Person shortest(){
        if (persons.isEmpty()) return null;

        Person shortestPerson = persons.get(0);

        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getHeight() < shortestPerson.getHeight()) {
                shortestPerson = persons.get(i);
            }
        }

        return shortestPerson;
    }

    public Person take(){
        if (persons.isEmpty()) return null;

        Person shortestPerson = shortest();
        for (int i = 0; i < persons.size(); i++) {
             if (shortestPerson.getHeight() == persons.get(i).getHeight()){
                 persons.remove(i);
                 return shortestPerson;
             }
        }
        return shortestPerson;
    }
}
