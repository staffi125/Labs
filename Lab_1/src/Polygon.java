import java.util.ArrayList;

/**
 * Клас Polygon представляє багатокутник, який визначається списком вершин.
 * Вершини задаються як об'єкти класу Point. Клас містить методи для обчислення
 * периметра, площі, центру мас, радіусів вписаного та описаного кіл багатокутника.
 */
public class Polygon {

    private ArrayList<Point> vertices;

    /**
     * Конструктор класу Polygon.
     * Ініціалізує багатокутник на основі переданого списку вершин.
     *
     * @param vertices список вершин багатокутника
     */
    public Polygon(ArrayList<Point> vertices) {
        this.vertices = vertices;
    }

    /**
     * Обчислює периметр багатокутника як суму довжин його сторін.
     * Довжини сторін визначаються як відстані між сусідніми вершинами.
     *
     * @return периметр багатокутника
     */
    public double calculatePerimeter() {
        double perimeter = 0;
        for (int i = 0; i < vertices.size(); i++) {
            Point current = vertices.get(i);
            Point next = vertices.get((i + 1) % vertices.size());
            perimeter += current.distanceTo(next);
        }
        return perimeter;
    }

    /**
     * Обчислює площу багатокутника за допомогою формули Гауса (методом векторного добутку).
     * Площа обчислюється як абсолютне значення половини суми векторних добутків координат
     * сусідніх вершин.
     *
     * @return площа багатокутника
     */
    public double calculateArea() {
        double area = 0;
        for (int i = 0; i < vertices.size(); i++) {
            Point current = vertices.get(i);
            Point next = vertices.get((i + 1) % vertices.size());
            area += current.getX() * next.getY() - next.getX() * current.getY();
        }
        return Math.abs(area) / 2;
    }

    /**
     * Обчислює центр мас (центроїд) багатокутника.
     * Центроїд обчислюється як середньозважена координат вершин багатокутника.
     *
     * @return центр мас багатокутника у вигляді об'єкта Point
     */
    public Point calculateCentroid() {
        double cx = 0, cy = 0;
        double area = calculateArea();
        for (int i = 0; i < vertices.size(); i++) {
            Point current = vertices.get(i);
            Point next = vertices.get((i + 1) % vertices.size());
            double factor = (current.getX() * next.getY() - next.getX() * current.getY());
            cx += (current.getX() + next.getX()) * factor;
            cy += (current.getY() + next.getY()) * factor;
        }
        cx = cx / (6 * area);
        cy = cy / (6 * area);
        return new Point(cx, cy);
    }

    /**
     * Обчислює радіус описаного кола (коло, яке проходить через усі вершини багатокутника)
     * для правильного багатокутника.
     *
     * @return радіус описаного кола
     * @throws IllegalArgumentException якщо багатокутник має менше трьох вершин
     */
    public double calculateCircumscribedRadius() {
        if (vertices.size() < 3) {
            throw new IllegalArgumentException("Не можливо обчислити радіус описаного кола для менше ніж трикутника.");
        }
        Point centroid = calculateCentroid();
        return centroid.distanceTo(vertices.get(0)); // Відстань від центру до першої вершини
    }

    /**
     * Обчислює радіус вписаного кола (коло, яке торкається всіх сторін багатокутника)
     * для правильного багатокутника. Формула обчислює приблизний радіус через площу
     * та периметр багатокутника.
     *
     * @return радіус вписаного кола
     */
    public double calculateInscribedRadius() {
        double area = calculateArea();
        double perimeter = calculatePerimeter();
        return (2 * area) / perimeter;
    }

    /**
     * Повертає текстове представлення багатокутника у вигляді списку вершин.
     *
     * @return текстове представлення багатокутника
     */
    @Override
    public String toString() {
        return "Polygon with vertices: " + vertices.toString();
    }
}
