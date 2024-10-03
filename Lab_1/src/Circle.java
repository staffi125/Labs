class Circle extends Shape {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void translate(double dx, double dy) {
        center.translate(dx, dy);
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }
    @Override
    public String toString() {
        return "Circle with center: " + center + " and radius: " + radius;
    }

}
