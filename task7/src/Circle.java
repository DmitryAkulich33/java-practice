class Circle extends Shape {
    private final double radius;

    Circle(double r) {
        if (r <= 0) {
            throw new IllegalArgumentException("Illegal radius. Should be positive number");
        }
        this.radius = r;
    }

    double square() {
        return (double) Math.round(Math.PI * radius * radius * 100) / 100;
    }

    double perimeter() {
        return (double) Math.round(2 * Math.PI * radius * 100) / 100;
    }
}
