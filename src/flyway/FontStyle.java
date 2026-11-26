package flyway;

class FontStyle {

    private final String font;
    private final int size;
    private final String color;

    public FontStyle(String font, int size, String color) {
        this.font = font;
        this.size = size;
        this.color = color;
    }

    public void display(String character, int position) {
        System.out.println(
                "Character: " + character +
                        ", Font: " + font +
                        ", Size: " + size +
                        ", Color: " + color +
                        ", Position: " + position
        );
    }
}
