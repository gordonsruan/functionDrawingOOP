package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FunctionTester extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Drawing Functions Test");
		Group root = new Group();
		Canvas canvas = new Canvas(600, 600);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Parabola parabola = new Parabola(-40,40, 1, 0, 0); //domain, slope, k,h 
		Quadratic quadratic = new Quadratic(-300,300, 0.25, - 0.5, -1,0 );
		Log log = new Log(-300,300,1,0,0);
		Cubic cubic = new Cubic(-300,300,.35,.25, - 0.5,-1,-2);
		Linear linear = new Linear(-300,300,1,0,0);
		Arc arc = new Arc(-300,300,40,0,-2);
		
		
		cubic.setColour(Color.AQUAMARINE);
		log.setColour(Color.RED);
		arc.draw(gc, arc);
		linear.draw(gc, linear);
		cubic.draw(gc, cubic);
		log.draw(gc, log);
		quadratic.draw(gc, quadratic);
		//parabola.draw(gc, parabola);
		drawShapes(gc);
		root.getChildren().add(canvas);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();

	}

	// test method for drawing - you can use this as an example for drawing various types of lines
	private void drawShapes(GraphicsContext gc) {
		gc.setFill(Color.GREEN);
		gc.setStroke(Color.BLUE);
		gc.setLineWidth(1);
		gc.strokeLine(300, 0, 300, 600);
		gc.strokeLine(0, 300, 600, 300);
		//gc.strokePolygon(new double[]{60, 90, 60, 90},
		//		new double[]{210, 210, 240, 240}, 4);
		//gc.strokePolyline(new double[]{110, 140, 110, 140},
		//		new double[]{210, 210, 240, 240}, 4);
	}

}