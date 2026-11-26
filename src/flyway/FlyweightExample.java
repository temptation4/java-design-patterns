package flyway;

import java.util.HashMap;
import java.util.Map;



// Main class with Flyweight Factory
 public class FlyweightExample {

    private static final Map<String, FontStyle> cache = new HashMap<>();

    // Factory method
    public static FontStyle getFontStyle(
            String font, int size, String color) {

        String key = font + "_" + size + "_" + color;

        return cache.computeIfAbsent(
                key,
                k -> new FontStyle(font, size, color)
        );
    }

    public static void main(String[] args) {

        FontStyle style1 =
                getFontStyle("Arial", 12, "Black");

        FontStyle style2 =
                getFontStyle("Arial", 12, "Black");

        FontStyle style3 =
                getFontStyle("Times New Roman", 14, "Blue");

        style1.display("A", 1);
        style2.display("B", 2);
        style3.display("C", 3);

        // Check object reuse
        System.out.println(style1 == style2); // true
        System.out.println(style1 == style3); // false
    }
}
