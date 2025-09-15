package builder;

public class BuilderDemo {
    public static void main(String[] args) {
        // Build User object step by step
        User user1 = new User.Builder("John", "Doe")
                .age(30)
                .email("john.doe@example.com")
                .phone("1234567890")
                .build();

        // Another user with fewer fields
        User user2 = new User.Builder("Alice", "Smith")
                .age(25)
                .build();

        System.out.println(user1);
        System.out.println(user2);
    }
}
