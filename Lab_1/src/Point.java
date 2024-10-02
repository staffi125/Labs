/**
 * Клас Point представляє точку на площині з координатами (x, y).
 * Дозволяє виконувати основні геометричні операції, такі як обчислення відстані,
 * переміщення, масштабування та відображення точки.
 */
public class Point {
    private double x;
    private double y;

    /**
     * Конструктор класу Point.
     *
     * @param x Координата X
     * @param y Координата Y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Повертає координату X точки.
     *
     * @return значення координати X
     */
    public double getX() {
        return x;
    }

    /**
     * Повертає координату Y точки.
     *
     * @return значення координати Y
     */
    public double getY() {
        return y;
    }

    /**
     * Задає нове значення для координати X.
     *
     * @param x нове значення X
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Задає нове значення для координати Y.
     *
     * @param y нове значення Y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Обчислює відстань між поточною точкою і іншою точкою.
     *
     * @param other Інша точка
     * @return відстань між двома точками
     */
    public double distanceTo(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Переміщує точку на dx по осі X і на dy по осі Y.
     *
     * @param dx зміна по осі X
     * @param dy зміна по осі Y
     */
    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * Масштабує точку відносно початку координат.
     *
     * @param factor коефіцієнт масштабування
     */
    public void scale(double factor) {
        this.x *= factor;
        this.y *= factor;
    }

    /**
     * Масштабує точку відносно іншої точки (origin).
     *
     * @param factor коефіцієнт масштабування
     * @param origin точка, відносно якої виконується масштабування
     */
    public void scale(double factor, Point origin) {
        this.x = origin.getX() + factor * (this.x - origin.getX());
        this.y = origin.getY() + factor * (this.y - origin.getY());
    }

    /**
     * Відображає точку по осі X.
     */
    public void reflectX() {
        this.y = -this.y;
    }

    /**
     * Відображає точку по осі Y.
     */
    public void reflectY() {
        this.x = -this.x;
    }

    /**
     * Відображає точку по прямій y = x.
     */
    public void reflectXY() {
        double temp = this.x;
        this.x = this.y;
        this.y = temp;
    }

    /**
     * Повертає рядкове представлення точки.
     *
     * @return координати точки у вигляді рядка
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
