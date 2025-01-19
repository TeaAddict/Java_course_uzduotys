import lt.techin.stream.StreamPraktiniai;
import lt.techin.stream.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Jonas", 5, true);
        User user2 = new User("Petras", 4, true);
        User user3 = new User("Lukas", 11, true);
        User user4 = new User("Egle", 22, false);

        List<User> users = List.of(user1, user2, user3, user4);

        Map<Boolean, Long> res = StreamPraktiniai.countGender(users);
        System.out.println(res);



    }
}
