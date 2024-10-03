class Triangle extends Shape {
    private Point vertex1, vertex2, vertex3;

    public Triangle(Point vertex1, Point vertex2, Point vertex3) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
    }

    @Override
    public double calculatePerimeter() {
        return vertex1.distanceTo(vertex2) + vertex2.distanceTo(vertex3) + vertex3.distanceTo(vertex1);
    }

    @Override
    public double calculateArea() {
        double a = vertex1.distanceTo(vertex2);
        double b = vertex2.distanceTo(vertex3);
        double c = vertex3.distanceTo(vertex1);
        double s = (a + b + c) / 2; // напівпериметр
        return Math.sqrt(s * (s - a) * (s - b) * (s - c)); // формула Герона
    }

    @Override
    public void translate(double dx, double dy) {
        vertex1.translate(dx, dy);
        vertex2.translate(dx, dy);
        vertex3.translate(dx, dy);
    }

    @Override
    public String toString() {
        return "Triangle with vertices: " + vertex1 + ", " + vertex2 + ", " + vertex3;
    }
}
