import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;
import java.util.ArrayList;

public class MainWindow extends Application implements EventHandler<ActionEvent> {
	// Screen size 432 x 600
	// buttons are 100 x 100 and result screen is 432 x 100
	Stage window;
	Scene scene;	
	Text answer;
	Computer computer = new Computer();
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setResizable(false);
				
		GridPane grid = new GridPane();
		grid.setVgap(1);
		grid.setHgap(1);
		
		grid.getColumnConstraints().add(new ColumnConstraints(100));
		grid.getColumnConstraints().add(new ColumnConstraints(100));
		grid.getColumnConstraints().add(new ColumnConstraints(100));
		grid.getColumnConstraints().add(new ColumnConstraints(100));
		
		grid.getRowConstraints().add(new RowConstraints(100));
		grid.getRowConstraints().add(new RowConstraints(100));
		grid.getRowConstraints().add(new RowConstraints(100));
		grid.getRowConstraints().add(new RowConstraints(100));
		grid.getRowConstraints().add(new RowConstraints(100));
		
		// ---------- Begin Button Section ----------
		
			// Clear
			Button clear = new Button("Clear");
			clear.setOnAction(this);
			clear.setPrefSize(100, 100);
			GridPane.setConstraints(clear, 0, 0);
		
			// Zero
			Button zero = new Button("0");
			zero.setOnAction(this);
			zero.setPrefSize(100, 100);
			GridPane.setConstraints(zero, 0, 4);
			
			// Comma
			Button comma = new Button(",");
			comma.setOnAction(this);
			comma.setPrefSize(100, 100);
			GridPane.setConstraints(comma, 1, 4);
			
			// Equals Sign
			Button solve = new Button("=");
			solve.setOnAction(this);
			solve.setPrefSize(100, 100);
			GridPane.setConstraints(solve, 2, 4);
					
			// One
			Button one = new Button("1");
			one.setOnAction(this);
			one.setPrefSize(100, 100);
			GridPane.setConstraints(one, 0, 3);
			
			// Two
			Button two = new Button("2");
			two.setOnAction(this);
			two.setPrefSize(100, 100);
			GridPane.setConstraints(two, 1, 3);
			
			// Three
			Button three = new Button("3");
			three.setOnAction(this);
			three.setPrefSize(100, 100);
			GridPane.setConstraints(three, 2, 3);
			
			// Four
			Button four = new Button("4");
			four.setOnAction(this);
			four.setPrefSize(100, 100);
			GridPane.setConstraints(four, 0, 2);
			
			// Five
			Button five = new Button("5");
			five.setOnAction(this);
			five.setPrefSize(100, 100);
			GridPane.setConstraints(five, 1, 2);
			
			// Six
			Button six = new Button("6");
			six.setOnAction(this);
			six.setPrefSize(100, 100);
			GridPane.setConstraints(six, 2, 2);
			
			// Seven
			Button seven = new Button("7");
			seven.setOnAction(this);
			seven.setPrefSize(100, 100);
			GridPane.setConstraints(seven, 0, 1);
	
			// Eight
			Button eight = new Button("8");
			eight.setOnAction(this);
			eight.setPrefSize(100, 100);
			GridPane.setConstraints(eight, 1, 1);
	
			// Nine
			Button nine = new Button("9");
			nine.setOnAction(this);
			nine.setPrefSize(100, 100);
			GridPane.setConstraints(nine, 2, 1);
			
			// Addition
			Button add = new Button("+");
			add.setOnAction(this);
			add.setPrefSize(100, 100);
			GridPane.setConstraints(add, 3, 1);
			
			// Subtraction
			Button subtract = new Button("-");
			subtract.setOnAction(this);
			subtract.setPrefSize(100, 100);
			GridPane.setConstraints(subtract, 3, 2);
	
			// Multiplication
			Button multiply = new Button("*");
			multiply.setOnAction(this);
			multiply.setPrefSize(100, 100);
			GridPane.setConstraints(multiply, 3, 3);
	
			// Division
			Button divide = new Button("/");
			divide.setOnAction(this);
			divide.setPrefSize(100, 100);
			divide.setId("divide");
			GridPane.setConstraints(divide, 3, 4);			
				
		// ---------- End Button Section ----------
			
		answer = new Text("");
		GridPane.setConstraints(answer, 0, 0, 4, 1);
		answer.setId("display");
		
		grid.getChildren().addAll(clear, zero, one, two, three, four, five, six, seven, eight, nine, comma, add, subtract, multiply, divide, solve, answer);
		grid.getStylesheets().add("stylesheet.css");
		scene = new Scene(grid, 392, 494);
		scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		window.setScene(scene);
		window.setTitle("Simple Calculator");
		window.show();
	}
	
	public void handle(ActionEvent event) {
		String button = ((Button)event.getSource()).getText();
		
		if (button.equals("Clear")) {
			computer.equation.clear();
			answer.setText("0.0");
		} else if (button.equals("=")) {
			answer.setText(computer.solve());		
		} else {
			answer.setText(button);
			computer.equation.add(button);	
		}
	}
}
