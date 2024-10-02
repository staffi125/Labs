/**
 * Клас LineSegment представляє відрізок (лінійний сегмент) на площині, який визначається двома точками:
 * початковою точкою start і кінцевою точкою end.
 * Клас включає методи для обчислення довжини відрізка та текстового представлення відрізка.
 */
public class LineSegment {
    // Поля класу
    private Point start;
    private Point end;

    /**
     * Конструктор класу LineSegment.
     * Ініціалізує відрізок на основі двох точок: початкової та кінцевої.
     *
     * @param start початкова точка відрізка
     * @param end кінцева точка відрізка
     */
    public LineSegment(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Обчислює довжину відрізка за допомогою методу distanceTo класу Point.
     * Довжина відрізка — це відстань між початковою точкою start і кінцевою точкою end.
     *
     * @return довжина відрізка
     */
    public double length() {
        return start.distanceTo(end);
    }

    /**
     * Повертає текстове представлення відрізка у форматі:
     * "LineSegment[start to end]".
     *
     * @return текстове представлення відрізка
     */
    @Override
    public String toString() {
        return "LineSegment[" + start + " to " + end + "]";
    }
}
