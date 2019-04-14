class Circle extends Shape {
    private final double radius;

    Circle(double r) {
        this.radius = r;
        if (r <= 0) {
            throw new IllegalArgumentException("Illegal Argument!!!");
        }
    }

    double square() {
        return 3.14 * radius * radius;
    }

    double perimeter() {
        return 2 * 3.14 * radius;
    }
}
