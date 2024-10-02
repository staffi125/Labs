import java.util.ArrayList;

public class Polygon {
    private ArrayList<Point> vertices;

    public Polygon(ArrayList<Point> vertices) {
        this.vertices = vertices;
    }

    public double calculatePerimeter() {
        double perimeter = 0;
        for (int i = 0; i < vertices.size(); i++) {
            Point current = vertices.get(i);
            Point next = vertices.get((i + 1) % vertices.size());
            perimeter += current.distanceTo(next);
        }
        return perimeter;
    }

    public double calculateArea() {
        double area = 0;
        for (int i = 0; i < vertices.size(); i++) {
            Point current = vertices.get(i);
            Point next = vertices.get((i + 1) % vertices.size());
            area += current.getX() * next.getY() - next.getX() * current.getY();
        }
        return Math.abs(area) / 2;
    }

    // Обчислення центру мас багатокутника
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

    // Описане коло для правильного багатокутника
    public double calculateCircumscribedRadius() {
        if (vertices.size() < 3) {
            throw new IllegalArgumentException("Не можливо обчислити радіус описаного кола для менше ніж трикутника.");
        }
        Point centroid = calculateCentroid();
        return centroid.distanceTo(vertices.get(0)); // Відстань від центру до першої вершини
    }

    // Вписане коло - обчислення приблизне для правильного багатокутника
    public double calculateInscribedRadius() {
        double area = calculateArea();
        double perimeter = calculatePerimeter();
        return (2 * area) / perimeter;
    }

    @Override
    public String toString() {
        return "Polygon with vertices: " + vertices.toString();
    }
}
