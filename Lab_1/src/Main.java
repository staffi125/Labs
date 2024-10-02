import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
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

        // Тест геометрії (Точки, Відрізки, Багатокутники)
        System.out.println("\n=== Тест геометрії ===");

        // Тест класу Point
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        System.out.println("Відстань між точками p1 і p2: " + p1.distanceTo(p2));

        // Тест класу LineSegment
        LineSegment line = new LineSegment(p1, p2);
        System.out.println("Довжина відрізка: " + line.length());

        // Тест класу Polygon
        ArrayList<Point> vertices = new ArrayList<>();
        vertices.add(new Point(0, 0));
        vertices.add(new Point(4, 0));
        vertices.add(new Point(4, 3));
        Polygon triangle = new Polygon(vertices);
        System.out.println("Периметр трикутника: " + triangle.calculatePerimeter());
        System.out.println("Площа трикутника: " + triangle.calculateArea());

        ArrayList<Point> Vertices = new ArrayList<>();
        Vertices.add(new Point(0, 0));
        Vertices.add(new Point(4, 0));
        Vertices.add(new Point(4, 3));
        Vertices.add(new Point(0, 3));

        // Створюємо багатокутник на основі цих точок
        Polygon polygon = new Polygon(Vertices);

        // Обчислюємо та виводимо периметр
        double perimeter = polygon.calculatePerimeter();
        System.out.println("Периметр багатокутника: " + perimeter);

        // Обчислюємо та виводимо площу
        double area = polygon.calculateArea();
        System.out.println("Площа багатокутника: " + area);

        // Обчислюємо та виводимо центр мас (центроїд)
        Point centroid = polygon.calculateCentroid();
        System.out.println("Центр мас багатокутника: " + centroid);

        // Обчислюємо та виводимо радіус описаного кола
        double circumscribedRadius = polygon.calculateCircumscribedRadius();
        System.out.println("Радіус описаного кола: " + circumscribedRadius);

        // Обчислюємо та виводимо радіус вписаного кола
        double inscribedRadius = polygon.calculateInscribedRadius();
        System.out.println("Радіус вписаного кола: " + inscribedRadius);
    }
}
