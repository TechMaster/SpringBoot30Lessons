package vn.techmaster.cookiedemo.model;

//Tạo Class lưu các thuộc tính
public class Style {
    private String background;
    private String color;
    private String font;

    public Style() {
        this.background ="linen";
        this.color="maroon";
        this.font = "0.8";
    }

    public Style(String background, String color, String font) {
        this.background = background;
        this.color = color;
        this.font = font;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }
}
