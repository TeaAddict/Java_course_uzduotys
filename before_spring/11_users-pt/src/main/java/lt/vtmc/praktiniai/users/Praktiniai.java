package lt.vtmc.praktiniai.users;

import java.util.List;

public class Praktiniai {

    public static Integer countUsersOlderThen25(List<User> users) {
        return (int) users.stream().filter(user -> user.getAge() > 25).count();
    }

    public static double getAverageAge(List<User> users) {
        return (double) users.stream().mapToInt(User::getAge).sum() / users.size();
    }

    public static Integer getMinAge(List<User> users) {
        return users.stream().mapToInt(User::getAge).min();
    }

    public static User findByName(List<User> users, String name) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public static List<User> sortByAge(List<User> users) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public static User findOldest(List<User> users) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public static int sumAge(List<User> users) {
        throw new UnsupportedOperationException("Not implemented");
    }

}
