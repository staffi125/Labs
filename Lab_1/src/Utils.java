class Utils {
    // Масштабування для кола
    public static void scale(Circle circle, double factor) {
        circle.getCenter().scale(factor);
    }

    // Масштабування для трикутника
    public static void scale(Triangle triangle, double factor) {
        triangle.translate(factor, factor); // простий приклад для трансформації
    }

    // Масштабування для багатокутника
    public static void scale(Polygon polygon, double factor) {
        for (Point vertex : polygon.getVertices()) {
            vertex.scale(factor);
        }
    }
}