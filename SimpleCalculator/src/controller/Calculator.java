package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import java.util.ArrayList;

public class Calculator {
	
	//Numeric Buttons on calculator 
	protected Button btn0, btn1, btn2, btn3, btn4, btn5,
			  btn6, btn7, btn8, btn9;
	
	//Button Operators
	protected Button btnPlus, btnMinus, btnMultiply, btnDivide, btnEquals;
	
	//Miscellaneous Buttons 1
	protected Button btnDecimal, btnOnClear; 
	
	//Miscellaneous Buttons 2
	protected Button btnSqRoot, btnNumSign, btnSquare;
	
	//Display Area
	protected TextArea txaDisplay;
	
	//MaxWidth used to make buttons all the same size
	//double maxWidth;
	
	//ArrayList to hold calculator inputs for calculations
	ArrayList<String> calcInputs = new ArrayList<>();
	
	//No-Args Constructor
	public Calculator() {}
	
	public Pane buildButtons123() {
		HBox h123 = new HBox();
		
		btn1 = new Button("1");
		btn1.setOnAction(new ButtonOneEventHandler());
		
		btn2 = new Button("2");
		btn2.setOnAction(new ButtonTwoEventHandler());
		
		btn3 = new Button("3");
		btn3.setOnAction(new ButtonThreeEventHandler());
		
		h123.getChildren().addAll(btn1, btn2, btn3);
		
		return h123;
		
	}
	
	public Pane buildButtons456() {
		HBox h456 = new HBox();
		
		btn4 = new Button("4");
		btn4.setOnAction(new ButtonFourEventHandler());
		
		btn5 = new Button("5");
		btn5.setOnAction(new ButtonFiveEventHandler());
		
		btn6 = new Button("6");
		btn6.setOnAction(new ButtonSixEventHandler());
		
		h456.getChildren().addAll(btn4, btn5, btn6);
		
		return h456;
		
	}
	
	public Pane buildButtons789() {
		HBox h789 = new HBox();
		
		btn7 = new Button("7");
		btn7.setOnAction(new ButtonSevenEventHandler());
		
		btn8 = new Button("8");
		btn8.setOnAction(new ButtonEightEventHandler());
		
		btn9 = new Button("9");
		btn9.setOnAction(new ButtonNineEventHandler());
		
		h789.getChildren().addAll(btn7, btn8, btn9);
		
		return h789;
		
	}
	
	public Pane buildZerosRow() {
		HBox h = new HBox();
		
		btnOnClear = new Button("ON/C");
		//maxWidth = btnOnClear.getMaxWidth();
		//System.out.println(maxWidth);
		btnOnClear.getStyleClass().add("redButtWhiteText");
		btnOnClear.setOnAction(new ButtonOnClearEventHandler());
		
		
		btn0 = new Button("0");
		btn0.setOnAction(new ButtonZeroEventHandler());
		
		btnDecimal = new Button(".");
		btnDecimal.setOnAction(new ButtonDecimalEventHandler());
		
		h.getChildren().addAll(btnOnClear, btn0, btnDecimal);
		
		return h;
	}

	//Builds the HBox for numSign, square root, and square buttons 
	public Pane buildSSS() {
		HBox h = new HBox();
		
		btnSqRoot = new Button("√");
		btnSqRoot.getStyleClass().add("redButtWhiteText");
		btnNumSign = new Button("+/-");
		btnNumSign.getStyleClass().add("redButtWhiteText");
		btnSquare = new Button("x²");
		btnSquare.getStyleClass().add("redButtWhiteText");
		
		h.getChildren().addAll(btnNumSign, btnSqRoot, btnSquare);
		
		return h;
	}
	
	public Pane buildPlus() {
		HBox h = new HBox();
		btnPlus = new Button("+");
		btnPlus.getStyleClass().add("redButtWhiteText");
		h.getChildren().add(btnPlus);
		return h;
	}
	
	public Pane buildMinus() {
		HBox h = new HBox();
		btnMinus = new Button("-");
		btnMinus.getStyleClass().add("redButtWhiteText");
		h.getChildren().add(btnMinus);
		return h;
	}
	
	public Pane buildMultiply() {
		HBox h = new HBox();
		btnMultiply = new Button("*");
		btnMultiply.getStyleClass().add("redButtWhiteText");
		h.getChildren().add(btnMultiply);
		return h;
	}
	
	public Pane buildDivide() {
		HBox h = new HBox();
		btnDivide = new Button("÷");
		btnDivide.getStyleClass().add("redButtWhiteText");
		h.getChildren().add(btnDivide);
		return h;
	}
	
	public Pane buildEquals() {
		HBox h = new HBox();
		btnEquals = new Button("=");
		btnEquals.getStyleClass().add("redButtWhiteText");
		h.getChildren().add(btnEquals);
		return h;
	}
	
	public Pane buildDisplay() {
		HBox h = new HBox();
		txaDisplay = new TextArea();
		txaDisplay.setEditable(false);
		txaDisplay.getStyleClass().add("text-area *.text");
		txaDisplay.setPrefColumnCount(25);
		txaDisplay.setPrefRowCount(0);
		h.getChildren().add(txaDisplay);
		return h;
	}
	
	
	
	
	
	
	
	/*----------------------------------------------------------------------------
	 * Event handlers
	 ----------------------------------------------------------------------------
	 */
	
	
	
	
	
	private class ButtonZeroEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			String strZero = "0";
			calcInputs.add(strZero);
			txaDisplay.setText(strZero);
		}
	}
	
	private class ButtonOneEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			String strOne = "1";
			calcInputs.add(strOne);
			txaDisplay.setText(strOne);
		}
	}
	
	private class ButtonTwoEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			String strTwo = "2";
			calcInputs.add(strTwo);
			txaDisplay.setText(strTwo);
		}
	}
	
	private class ButtonThreeEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			String strThree = "3";
			calcInputs.add(strThree);
			txaDisplay.setText(strThree);
		}
	}
	
	private class ButtonFourEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			String strFour = "4";
			calcInputs.add(strFour);
			txaDisplay.setText(strFour);
		}
	}
	
	private class ButtonFiveEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			String strFive = "5";
			calcInputs.add(strFive);
			txaDisplay.setText(strFive);
		}
	}
	
	private class ButtonSixEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			String strSix = "6";
			calcInputs.add(strSix);
			txaDisplay.setText(strSix);
		}
	}
	
	private class ButtonSevenEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			String strSeven = "7";
			calcInputs.add(strSeven);
			txaDisplay.setText(strSeven);
		}
	}
	
	private class ButtonEightEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			String strEight = "8";
			calcInputs.add(strEight);
			txaDisplay.setText(strEight);
		}
	}
	
	private class ButtonNineEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			String strNine = "9";
			calcInputs.add(strNine);
			txaDisplay.setText(strNine);
		}
	}
	
	private class ButtonOnClearEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			calcInputs.clear();
			txaDisplay.setText("0");
		}
	}
	
	private class ButtonDecimalEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			int lastElementIndex = calcInputs.size() - 1;
			String lastElement = calcInputs.get(lastElementIndex);
			String newLastElement = "";
			char lastChar = lastElement.charAt(0);
			
			if(!calcInputs.contains(".")) {
				if(Character.isDigit(lastChar)) {
					calcInputs.add(".");
					newLastElement = calcInputs.get(calcInputs.size() - 1);
					txaDisplay.setText(lastElement + newLastElement);
					
					//removes decimal so that when other buttons are pressed they can use the
					//decimal point as well
					calcInputs.remove("."); 
				}
			}
		}
	}
	
}
