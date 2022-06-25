import javafx.geometry.Point2D;

public class Skyscraper {
    private Skyline skyline;

    public Skyscraper(int height, int startX, int endX) {
        skyline = new Skyline();
        skyline.addPoint(new Point2D(startX, 0));
        skyline.addPoint(new Point2D(startX, height));
        skyline.addPoint(new Point2D(endX, height));
        skyline.addPoint(new Point2D(endX, 0));
    }

    public Skyline getSkyline() {
        return skyline;
    }
}