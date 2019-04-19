public final class Rectangle extends Shape {
    private final double side1;
    private final double side2;

   Rectangle(double a, double b) {
        if (a <= 0 && b <= 0) {
            throw new IllegalArgumentException("Illegal sides. Should be positive number");
        }
        this.side1 = a;
        this.side2 = b;
    }

    double square() {
        return side1 * side2;
    }

    double perimeter() {
        return 2 * (side1 + side2);
    }
}
