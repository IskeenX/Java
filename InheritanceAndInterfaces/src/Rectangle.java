public class Rectangle implements Shape {
    private int width;
    private int height;
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public int getArea() {
        return width * height;
    }
    @Override
    public int getCircumference() {
        return (width + height) * 2;
    }
}