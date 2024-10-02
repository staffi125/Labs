public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Обчислення відстані між двома точками
    public double distanceTo(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Переміщення точки на dx по осі X і на dy по осі Y
    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    // Масштабування точки відносно початку координат
    public void scale(double factor) {
        this.x *= factor;
        this.y *= factor;
    }

    // Масштабування точки відносно певної точки
    public void scale(double factor, Point origin) {
        this.x = origin.getX() + factor * (this.x - origin.getX());
        this.y = origin.getY() + factor * (this.y - origin.getY());
    }

    // Відображення точки по осі X
    public void reflectX() {
        this.y = -this.y;
    }

    // Відображення точки по осі Y
    public void reflectY() {
        this.x = -this.x;
    }

    // Відображення точки по прямій y = x
    public void reflectXY() {
        double temp = this.x;
        this.x = this.y;
        this.y = temp;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
