import javafx.geometry.Point2D;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class Skyline {
    private ArrayList<Point2D> points;
    private static Skyscraper[] skyscrapers;

    public Skyline() {
        points = new ArrayList<>();
    }

    public void addPoint(Point2D point) {
        points.add(point);
    }

    public ArrayList<Point2D> getPoints() {
        return points;
    }

    public static void drawSkyline(Skyscraper[] scrapers) {
        skyscrapers = scrapers;
        drawSkyline(drawSkyline(0, scrapers.length - 1));
    }

    private static Skyline drawSkyline(int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return skyscrapers[startIndex].getSkyline();
        }
        int middle = (startIndex + endIndex) / 2;
        Skyline firstSkyline = drawSkyline(startIndex, middle);
        Skyline secondSkyline = drawSkyline(middle + 1, endIndex);
        return mergeSkylines(firstSkyline, secondSkyline);
    }

    private static Skyline mergeSkylines(Skyline skyline1, Skyline skyline2) {
        ArrayList<Point2D> points1 = skyline1.getPoints();
        ArrayList<Point2D> points2 = skyline2.getPoints();
        Skyline skyline = new Skyline();
        double lastSeenHeight1 = 0, lastSeenHeight2 = 0;
        double x1, y1, x2, y2;
        while (points1.size() != 0 && points2.size() != 0) {
            x1 = points1.get(0).getX();
            x2 = points2.get(0).getX();
            y1 = points1.get(0).getY();
            y2 = points2.get(0).getY();
            if (x1 < x2) {
                lastSeenHeight1 = y1;
                skyline.addPoint(new Point2D(x1, Math.max(lastSeenHeight2, y1)));
                points1.remove(0);
            } else if (x1 > x2) {
                lastSeenHeight2 = y2;
                skyline.addPoint(new Point2D(x2, Math.max(lastSeenHeight1, y2)));
                points2.remove(0);
            } else {
                lastSeenHeight1 = y1;
                lastSeenHeight2 = y2;
                skyline.addPoint(new Point2D(x1, Math.max(y1, y2)));
                points1.remove(0);
                points2.remove(0);
            }
        }
        while (points1.size() != 0) {
            skyline.addPoint(points1.remove(0));
        }
        while (points2.size() != 0) {
            skyline.addPoint(points2.remove(0));
        }
        return skyline;
    }

    private static void drawSkyline(Skyline skyline) {
        double startX = (skyline.points.get(0).getX() + 2) * 20,
                startY = 450 - skyline.points.get(0).getY() * 20, endX, endY;
        Point2D point;
        for (int i = 1; i < skyline.points.size(); i++) {
            point = skyline.points.get(i);
            endX = (point.getX() + 2) * 20;
            endY = 450 - point.getY() * 20;
            FxClass.addLine(new Line(startX, startY, endX, endY));
            startX = endX;
            startY = endY;
        }
    }
}
