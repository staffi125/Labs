import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        testStack();
        testQueue();
        testDeque();
        testGeometry();
    }

    private static void testStack() {
        System.out.println("=== Тест стеку ===");
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Чи порожній стек: " + stack.isEmpty());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Чи порожній стек: " + stack.isEmpty());
    }

    private static void testQueue() {
        System.out.println("\n=== Тест черги ===");
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Peek: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Чи порожня черга: " + queue.isEmpty());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Чи порожня черга: " + queue.isEmpty());
    }

    private static void testDeque() {
        System.out.println("\n=== Тест Deque ===");
        Deque<Integer> deque = new Deque<>();
        deque.addFront(10);
        deque.addBack(20);
        deque.addFront(5);
        System.out.println("Peek Front: " + deque.peekFront());
        System.out.println("Peek Back: " + deque.peekBack());
        System.out.println("Remove Front: " + deque.removeFront());
        System.out.println("Remove Back: " + deque.removeBack());
        System.out.println("Remove Front: " + deque.removeFront());
        System.out.println("Чи порожній deque: " + deque.isEmpty());
    }

    private static void testGeometry() {
        System.out.println("\n=== Тест геометрії ===");

        testPointsAndLines();
        testPolygons();

        Shape circle = new Circle(new Point(0, 0), 5);
        Shape triangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4));

        System.out.println("Circle perimeter: " + circle.calculatePerimeter());
        System.out.println("Triangle area: " + triangle.calculateArea());

        // Динамічний поліморфізм
        circle.translate(2, 3);
        triangle.translate(1, 1);
        System.out.println("Circle after translation: " + circle);
        System.out.println("Triangle after translation: " + triangle);
        System.out.println("=== Початкові значення ===");
        System.out.println("Початкове коло: " + circle);
        System.out.println("Початковий трикутник: " + triangle);

        // Масштабування кола і трикутника
        Utils.scale((Circle) circle, 1.5);
        Utils.scale((Triangle) triangle, 1.5);

        // Виведення значень після масштабування
        System.out.println("\n=== Після масштабування ===");
        System.out.println("Коло після масштабування: " + circle);
        System.out.println("Трикутник після масштабування: " + triangle);

    }

    private static void testPointsAndLines() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        System.out.println("Відстань між точками p1 і p2: " + p1.distanceTo(p2));

        LineSegment line = new LineSegment(p1, p2);
        System.out.println("Довжина відрізка: " + line.length());
    }

    private static void testPolygons() {
        ArrayList<Point> triangleVertices = new ArrayList<>();
        triangleVertices.add(new Point(0, 0));
        triangleVertices.add(new Point(4, 0));
        triangleVertices.add(new Point(4, 3));

        Polygon triangle = new Polygon(triangleVertices);
        printPolygonProperties(triangle, "трикутника");

        ArrayList<Point> rectangleVertices = new ArrayList<>();
        rectangleVertices.add(new Point(0, 0));
        rectangleVertices.add(new Point(4, 0));
        rectangleVertices.add(new Point(4, 3));
        rectangleVertices.add(new Point(0, 3));

        Polygon rectangle = new Polygon(rectangleVertices);
        printPolygonProperties(rectangle, "багатокутника");
    }

    private static void printPolygonProperties(Polygon polygon, String name) {
        System.out.println("Периметр " + name + ": " + polygon.calculatePerimeter());
        System.out.println("Площа " + name + ": " + polygon.calculateArea());
        System.out.println("Центр мас " + name + ": " + polygon.calculateCentroid());
        System.out.println("Радіус описаного кола: " + polygon.calculateCircumscribedRadius());
        System.out.println("Радіус вписаного кола: " + polygon.calculateInscribedRadius());
    }
}
