public class Square extends  Rectangle {
    public Square(int side) {
        super(side, side);
    }

    public static void main(String[] args) {
        Rectangle rectangle_1 = new Rectangle(4, 5);
        Rectangle rectangle_2 = new Rectangle(6, 7);

        System.out.println("Area of Rectangle 1: " + rectangle_1.getArea());
        System.out.println("Circumference of Rectangle 2: " + rectangle_2.getCircumference());

        Square square_1 = new Square(5);
        System.out.println("Area of Square 1: " + square_1.getArea());
    }
}