import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FxClass extends Application {
    private static ArrayList<Line> lines = new ArrayList<>();

    public static void addLine(Line line) {
        lines.add(line);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group pane = new Group();
        Scene scene = new Scene(pane, 900, 900);
        stage.setScene(scene);
        stage.show();
        pane.getChildren().addAll(lines);
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        xAxis.setLayoutX(40);
        xAxis.setLayoutY(450);
        xAxis.setMinWidth(600);
        pane.getChildren().add(xAxis);
        xAxis.sideProperty().setValue(Side.BOTTOM);
        NumberAxis yAxis = new NumberAxis(0, 20, 1);
        yAxis.setLayoutX(15);
        yAxis.setLayoutY(50);
        yAxis.setMinHeight(400);
        pane.getChildren().add(yAxis);
        yAxis.sideProperty().setValue(Side.LEFT);
    }

    public static void launchApplication(String[] args) {
        launch(args);
    }
}
