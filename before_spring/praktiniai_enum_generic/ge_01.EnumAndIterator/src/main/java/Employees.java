import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Employees {
    private List<Person> personList = new ArrayList<Person>();

    public void add(Person personAdd) {
        personList.add(personAdd);
    }

    public void add(List<Person> peopleAdd) {
        personList.addAll(peopleAdd);
    }

    public void print() {
        personList.forEach(System.out::println);
    }

    public void print(Education education) {
        Iterator<Person> personIterator = personList.iterator();
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            if (person.getEducation().equals(education)) {
                System.out.println(person);
            }
        }
    }

    public void fire(Education education) {
        personList = personList.stream().filter(person -> !person.getEducation().equals(education)).collect(Collectors.toList());
    }
}
