package builder;

// User class is immutable (all fields are final, no setters)
public final class User {

    // Required fields
    private final String firstName;
    private final String lastName;

    // Optional fields
    private final int age;
    private final String email;
    private final String phone;

    /**
     * Private constructor - can only be called from Builder
     * Ensures immutability and prevents direct instantiation.
     */
    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    // Only getters, no setters -> ensures immutability
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    @Override
    public String toString() {
        return "User [firstName=" + firstName +
                ", lastName=" + lastName +
                ", age=" + age +
                ", email=" + email +
                ", phone=" + phone + "]";
    }

    /**
     * Static nested Builder class
     * - Builds User step by step
     * - Can enforce required parameters through constructor
     */
    public static class Builder {
        // Required fields
        final String firstName;
        final String lastName;

        // Optional fields (default values)
        int age = 0;
        String email = "";
        String phone = "";

        /**
         * Constructor for Builder with required parameters
         */
        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        /**
         * Optional parameter methods
         * Each method returns Builder itself (fluent API style)
         */
        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        /**
         * Final build() method creates the actual User object
         */
        public User build() {
            return new User(this);
        }
    }
}

