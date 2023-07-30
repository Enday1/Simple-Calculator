package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
//import javafx.scene.layout.VBox;
import controller.Calculator;


public class Main extends Application {
	protected Calculator calc = new Calculator();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = buildPane();
			Scene scene = new Scene(root,400,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("TI-108");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private Pane buildPane() {
		//VBox vbox = new VBox();
		GridPane gp = new GridPane();
		Pane hBoxDisplay = calc.buildDisplay();
		GridPane grdPane = new GridPane();
		
		Pane col0Row0 = calc.buildSSS();
		grdPane.add(col0Row0, 0, 0);
		
		Pane col0Row1 = calc.buildButtons789();
		grdPane.add(col0Row1, 0, 1);
		
		Pane col0Row2 = calc.buildButtons456();
		grdPane.add(col0Row2, 0, 2);
		
		Pane col0Row3 = calc.buildButtons123();
		grdPane.add(col0Row3, 0, 3);
		
		Pane col0Row4 = calc.buildZerosRow();
		grdPane.add(col0Row4, 0, 4);
		
		Pane col1Row0 = calc.buildDivide();
		grdPane.add(col1Row0, 1, 0);
		
		Pane col1Row1 = calc.buildMultiply();
		grdPane.add(col1Row1, 1, 1);
		
		Pane col1Row2 = calc.buildMinus();
		grdPane.add(col1Row2, 1, 2);
		
		Pane col1Row3 = calc.buildPlus();
		grdPane.add(col1Row3, 1, 3);
		
		Pane col1Row4 = calc.buildEquals();
		grdPane.add(col1Row4, 1, 4);
		
		//vbox.getChildren().addAll(hBoxDisplay, grdPane);
		gp.add(hBoxDisplay, 0, 0, 5, 1);
		
		gp.add(grdPane, 0, 1, 5, 1);
		//return vbox;
		
		return gp;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
