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
		btnSqRoot.setOnAction(new ButtonSquareRootEventHandler()); 
		
		btnNumSign = new Button("+/-");
		btnNumSign.getStyleClass().add("redButtWhiteText");
		btnNumSign.setOnAction(new ButtonSignEventHandler());
		
		btnSquare = new Button("x²");
		btnSquare.getStyleClass().add("redButtWhiteText");
		btnSquare.setOnAction(new ButtonSquaredEventHandler());
		
		h.getChildren().addAll(btnNumSign, btnSqRoot, btnSquare);
		
		return h;
	}
	
	public Pane buildPlus() {
		HBox h = new HBox();
		btnPlus = new Button("+");
		btnPlus.getStyleClass().add("redButtWhiteText");
		btnPlus.setOnAction(new ButtonPlusEventHandler());
		h.getChildren().add(btnPlus);
		return h;
	}
	
	public Pane buildMinus() {
		HBox h = new HBox();
		btnMinus = new Button("-");
		btnMinus.getStyleClass().add("redButtWhiteText");
		btnMinus.setOnAction(new ButtonMinusEventHandler());
		h.getChildren().add(btnMinus);
		return h;
	}
	
	public Pane buildMultiply() {
		HBox h = new HBox();
		btnMultiply = new Button("*");
		btnMultiply.getStyleClass().add("redButtWhiteText");
		btnMultiply.setOnAction(new ButtonMultiplyEventHandler());
		h.getChildren().add(btnMultiply);
		return h;
	}
	
	public Pane buildDivide() {
		HBox h = new HBox();
		btnDivide = new Button("÷");
		btnDivide.getStyleClass().add("redButtWhiteText");
		btnDivide.setOnAction(new ButtonDivideEventHandler());
		h.getChildren().add(btnDivide);
		return h;
	}
	
	public Pane buildEquals() {
		HBox h = new HBox();
		btnEquals = new Button("=");
		btnEquals.getStyleClass().add("redButtWhiteText");
		btnEquals.setOnAction(new ButtonEqualsEventHandler());
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
			
			if (txaDisplay.getText().isEmpty()) {
				calcInputs.clear();
				return;
			}
			
			if(elementSizeGreaterThanOne() == true) {
				return;
			}
			
			if(calcInputs.get(calcInputs.size() - 1).equals("+") || calcInputs.get(calcInputs.size() - 1).equals("-") || calcInputs.get(calcInputs.size() - 1).equals("*") || calcInputs.get(calcInputs.size() - 1).equals("/")) {
				calcInputs.add(strZero);
				txaDisplay.setText(strZero);
			}
			
			else if(!txaDisplay.getText().isEmpty() && txaDisplay.getText().length() >= 1 && calcInputs.size() >= 1) {
				if(txaDisplay.getText().charAt(0) == '1' || txaDisplay.getText().charAt(0) == '2' || txaDisplay.getText().charAt(0) == '3' ||
						txaDisplay.getText().charAt(0) == '4' || txaDisplay.getText().charAt(0) == '5' || txaDisplay.getText().charAt(0) == '6' ||
						txaDisplay.getText().charAt(0) == '7' || txaDisplay.getText().charAt(0) == '8' || txaDisplay.getText().charAt(0) == '9' || txaDisplay.getText().indexOf(".") >= 0) {
					
					
					calcInputs.add(strZero);
					String msg = txaDisplay.getText() + "0";
					txaDisplay.setText(msg);
				}
				
			}
			
			
			else {
				calcInputs.add(strZero);
				txaDisplay.setText(strZero);
			}
			
		}
	}
	
	private boolean elementSizeGreaterThanOne() {
		if(calcInputs.get(calcInputs.size() - 1).length() > 1) {
			return true;
		}
		return false;
	}
	
	private class ButtonOneEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (txaDisplay.getText().isEmpty()) {
				calcInputs.clear();
				return;
			}
			
			if(elementSizeGreaterThanOne() == true) {
				return;
			}
			
			String strOne = "1";
			calcInputs.add(strOne);
		
			if(calcInputs.get(calcInputs.size() - 2).equals("+") || calcInputs.get(calcInputs.size() - 2).equals("-") || calcInputs.get(calcInputs.size() - 2).equals("*") || calcInputs.get(calcInputs.size() - 2).equals("/")) {
				txaDisplay.setText(strOne);
			}
						
			else if(!txaDisplay.getText().isEmpty() && txaDisplay.getText().length() >= 1 && calcInputs.size() >= 1) {
				if(txaDisplay.getText().equals("0")) {
					txaDisplay.clear();
					
					//Takes away any 0 that appears in the array before a number without a decimal (ex: 09)
					if(calcInputs.size() >= 4) {
						calcInputs.remove(calcInputs.size() - 2);	
					}
					
				}
				String msg = txaDisplay.getText() + "1";
				txaDisplay.setText(msg);
			}
			
			
			else {
				txaDisplay.setText(strOne);
			}
		}
	}
	
	private class ButtonTwoEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (txaDisplay.getText().isEmpty()) {
				calcInputs.clear();
				return;
			}
			
			
			if(elementSizeGreaterThanOne() == true) {
				return;
			}
			
			String strTwo = "2";
			calcInputs.add(strTwo);
		
			if(calcInputs.get(calcInputs.size() - 2).equals("+") || calcInputs.get(calcInputs.size() - 2).equals("-") || calcInputs.get(calcInputs.size() - 2).equals("*") || calcInputs.get(calcInputs.size() - 2).equals("/")) {
				txaDisplay.setText(strTwo);
			}
			
			else if(!txaDisplay.getText().isEmpty() && txaDisplay.getText().length() >= 1 && calcInputs.size() >= 1) {
				if(txaDisplay.getText().equals("0")) {
					txaDisplay.clear();
					
					//Takes away any 0 that appears in the array before a number without a decimal (ex: 09)
					if(calcInputs.size() >= 4) {
						calcInputs.remove(calcInputs.size() - 2);	
					}
					
				}
				String msg = txaDisplay.getText() + "2";
				txaDisplay.setText(msg);
			}
			
			else {
				txaDisplay.setText(strTwo);
			}
		}
	}
	
	private class ButtonThreeEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (txaDisplay.getText().isEmpty()) {
				calcInputs.clear();
				return;
			}
			
			if(elementSizeGreaterThanOne() == true) {
				return;
			}
			
			String strThree = "3";
			calcInputs.add(strThree);

			if(calcInputs.get(calcInputs.size() - 2).equals("+") || calcInputs.get(calcInputs.size() - 2).equals("-") || calcInputs.get(calcInputs.size() - 2).equals("*") || calcInputs.get(calcInputs.size() - 2).equals("/")) {
				txaDisplay.setText(strThree);
			}
			
			else if(!txaDisplay.getText().isEmpty() && txaDisplay.getText().length() >= 1 && calcInputs.size() >= 1) {
				if(txaDisplay.getText().equals("0")) {
					txaDisplay.clear();
					
					//Takes away any 0 that appears in the array before a number without a decimal (ex: 09)
					if(calcInputs.size() >= 4) {
						calcInputs.remove(calcInputs.size() - 2);	
					}
					
				}
				String msg = txaDisplay.getText() + "3";
				txaDisplay.setText(msg);
			}
			
		
			else {
				txaDisplay.setText(strThree);
			}
		}
	}
	
	private class ButtonFourEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (txaDisplay.getText().isEmpty()) {
				calcInputs.clear();
				return;
			}
			
			if(elementSizeGreaterThanOne() == true) {
				return;
			}
			
			String strFour = "4";
			calcInputs.add(strFour);
			
			if(calcInputs.get(calcInputs.size() - 2).equals("+") || calcInputs.get(calcInputs.size() - 2).equals("-") || calcInputs.get(calcInputs.size() - 2).equals("*") || calcInputs.get(calcInputs.size() - 2).equals("/")) {
				txaDisplay.setText(strFour);
			}
			
			else if(!txaDisplay.getText().isEmpty() && txaDisplay.getText().length() >= 1 && calcInputs.size() >= 1) {
				if(txaDisplay.getText().equals("0")) {
					txaDisplay.clear();
					
					//Takes away any 0 that appears in the array before a number without a decimal (ex: 09)
					if(calcInputs.size() >= 4) {
						calcInputs.remove(calcInputs.size() - 2);	
					}
					
				}
				String msg = txaDisplay.getText() + "4";
				txaDisplay.setText(msg);
			}
			
			
			else {
				txaDisplay.setText(strFour);
			}
		}
	}
	
	private class ButtonFiveEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (txaDisplay.getText().isEmpty()) {
				calcInputs.clear();
				return;
			}
			
			if(elementSizeGreaterThanOne() == true) {
				return;
			}
			
			String strFive = "5";
			calcInputs.add(strFive);

			if(calcInputs.get(calcInputs.size() - 2).equals("+") || calcInputs.get(calcInputs.size() - 2).equals("-") || calcInputs.get(calcInputs.size() - 2).equals("*") || calcInputs.get(calcInputs.size() - 2).equals("/")) {
				txaDisplay.setText(strFive);
			}
			
			else if(!txaDisplay.getText().isEmpty() && txaDisplay.getText().length() >= 1 && calcInputs.size() >= 1) {
				if(txaDisplay.getText().equals("0")) {
					txaDisplay.clear();
					
					//Takes away any 0 that appears in the array before a number without a decimal (ex: 09)
					if(calcInputs.size() >= 4) {
						calcInputs.remove(calcInputs.size() - 2);	
					}
					
				}
				String msg = txaDisplay.getText() + "5";
				txaDisplay.setText(msg);
			}
			
			else {
				txaDisplay.setText(strFive);
			}
		}
	}
	
	private class ButtonSixEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (txaDisplay.getText().isEmpty()) {
				calcInputs.clear();
				return;
			}
			
			if(elementSizeGreaterThanOne() == true) {
				return;
			}
			
			String strSix = "6";
			calcInputs.add(strSix);

			if(calcInputs.get(calcInputs.size() - 2).equals("+") || calcInputs.get(calcInputs.size() - 2).equals("-") || calcInputs.get(calcInputs.size() - 2).equals("*") || calcInputs.get(calcInputs.size() - 2).equals("/")) {
				txaDisplay.setText(strSix);
			}
			
			else if(!txaDisplay.getText().isEmpty() && txaDisplay.getText().length() >= 1 && calcInputs.size() >= 1) {
				if(txaDisplay.getText().equals("0")) {
					txaDisplay.clear();
					
					//Takes away any 0 that appears in the array before a number without a decimal (ex: 09)
					if(calcInputs.size() >= 4) {
						calcInputs.remove(calcInputs.size() - 2);	
					}
					
				}
				String msg = txaDisplay.getText() + "6";
				txaDisplay.setText(msg);
			}
			
			else {
				txaDisplay.setText(strSix);
			}
		}
	}
	
	private class ButtonSevenEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (txaDisplay.getText().isEmpty()) {
				calcInputs.clear();
				return;
			}
			
			if(elementSizeGreaterThanOne() == true) {
				return;
			}
			
			String strSeven = "7";
			calcInputs.add(strSeven);
			
			if(calcInputs.get(calcInputs.size() - 2).equals("+") || calcInputs.get(calcInputs.size() - 2).equals("-") || calcInputs.get(calcInputs.size() - 2).equals("*") || calcInputs.get(calcInputs.size() - 2).equals("/")) {
				txaDisplay.setText(strSeven);
			}
			
			else if(!txaDisplay.getText().isEmpty() && txaDisplay.getText().length() >= 1 && calcInputs.size() >= 1) {
				if(txaDisplay.getText().equals("0")) {
					txaDisplay.clear();
					
					//Takes away any 0 that appears in the array before a number without a decimal (ex: 09)
					if(calcInputs.size() >= 4) {
						calcInputs.remove(calcInputs.size() - 2);	
					}
					
				}
				String msg = txaDisplay.getText() + "7";
				txaDisplay.setText(msg);
			}
			
			else {
				txaDisplay.setText(strSeven);
			}
		}
	}
	
	private class ButtonEightEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (txaDisplay.getText().isEmpty()) {
				calcInputs.clear();
				return;
			}
			
			if(elementSizeGreaterThanOne() == true) {
				return;
			}
			
			String strEight = "8";
			calcInputs.add(strEight);
			
			if(calcInputs.get(calcInputs.size() - 2).equals("+") || calcInputs.get(calcInputs.size() - 2).equals("-") || calcInputs.get(calcInputs.size() - 2).equals("*") || calcInputs.get(calcInputs.size() - 2).equals("/")) {
				txaDisplay.setText(strEight);
			}
			
			
			else if(!txaDisplay.getText().isEmpty() && txaDisplay.getText().length() >= 1 && calcInputs.size() >= 1) {
				if(txaDisplay.getText().equals("0")) {
					txaDisplay.clear();
					
					//Takes away any 0 that appears in the array before a number without a decimal (ex: 09)
					if(calcInputs.size() >= 4) {
						calcInputs.remove(calcInputs.size() - 2);	
					}
					
				}
				String msg = txaDisplay.getText() + "8";
				txaDisplay.setText(msg);
			}
			
			
			else {
				txaDisplay.setText(strEight);
			}
		}
	}
	
	private class ButtonNineEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (txaDisplay.getText().isEmpty()) {
				calcInputs.clear();
				return;
			}
			
			if(elementSizeGreaterThanOne() == true) {
				return;
			}
			
			String strNine = "9";
			calcInputs.add(strNine);
			

			if(calcInputs.get(calcInputs.size() - 2).equals("+") || calcInputs.get(calcInputs.size() - 2).equals("-") || calcInputs.get(calcInputs.size() - 2).equals("*") || calcInputs.get(calcInputs.size() - 2).equals("/")) {
				txaDisplay.setText(strNine);
			}
			
			else if(!txaDisplay.getText().isEmpty() && txaDisplay.getText().length() >= 1 && calcInputs.size() >= 1) {
				if(txaDisplay.getText().equals("0")) {
					txaDisplay.clear();
					txaDisplay.setText("9");
					
					//Takes away any 0 that appears in the array before a number without a decimal (ex: 09)
					if(calcInputs.size() >= 4) {
						calcInputs.remove(calcInputs.size() - 2);	
					}
					
					return;
				}
				String msg = txaDisplay.getText() + "9";
				txaDisplay.setText(msg);
			}
			
			
			else {
				txaDisplay.setText(strNine);
			}
		}
	}
	
	private class ButtonOnClearEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			calcInputs.clear();
			calcInputs.add("0");
			txaDisplay.setText("0");
		}
	}
	
	private class ButtonDecimalEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (txaDisplay.getText().isEmpty()) {
				calcInputs.clear();
				return;
			}
			
			if(elementSizeGreaterThanOne() == true) {
				return;
			}
			
			
			int lastElementIndex = calcInputs.size() - 1;
			String lastElement = calcInputs.get(lastElementIndex);
			//String newLastElement = "";
			char lastChar = lastElement.charAt(0);
			
			if(!calcInputs.contains(".")) {
				//allows for # (+,-,*,/) .# without a zero in front
				if(calcInputs.size() > 1 && !Character.isDigit(lastChar)) {
					calcInputs.add(".");
					String msg = ".";
					txaDisplay.setText(msg);
				}
				if(calcInputs.size() == 0 || Character.isDigit(lastChar)) {
					calcInputs.add(".");
					//newLastElement = calcInputs.get(calcInputs.size() - 1);
					//txaDisplay.setText(lastElement + newLastElement);
					
					String msg = txaDisplay.getText() + ".";
					txaDisplay.setText(msg);
					
					//removes decimal so that when other buttons are pressed they can use the
					//decimal point as well
					//calcInputs.remove("."); 
				}
			}
			
		
			
			if(calcInputs.lastIndexOf(".") >= 0 && (calcInputs.lastIndexOf("+") >= 0 || calcInputs.lastIndexOf("-") >= 0 || calcInputs.lastIndexOf("*") >= 0 || calcInputs.lastIndexOf("/") >= 0)
					&& (calcInputs.lastIndexOf(".") < calcInputs.lastIndexOf("+") || calcInputs.lastIndexOf(".") < calcInputs.lastIndexOf("-") || calcInputs.lastIndexOf(".") < calcInputs.lastIndexOf("*") || calcInputs.lastIndexOf(".") < calcInputs.lastIndexOf("/"))) {
				
				if(calcInputs.size() == 0 || lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/') {
					calcInputs.add(".");
					//newLastElement = calcInputs.get(calcInputs.size() - 1);
					//txaDisplay.setText(lastElement + newLastElement);
					String msg = /*txaDisplay.getText() +*/  ".";
					txaDisplay.setText(msg);
					
					
				}
				
				if(Character.isDigit(lastChar)) {
					calcInputs.add(".");
					String msg = txaDisplay.getText() +  ".";
					txaDisplay.setText(msg);
				}
			
			}
			
			
		}
	}
	
	
	private class ButtonSignEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (txaDisplay.getText().isEmpty()) {
				calcInputs.clear();
				return;
			}
			
			if(calcInputs.size() == 3 && calcInputs.get(calcInputs.size() - 1).equals("0") && !Character.isDigit(calcInputs.get(1).charAt(0))) {
				return;
			}
			
			if(calcInputs.size() > 1 && calcInputs.get(calcInputs.size() - 1).length() > 1 && calcInputs.get(calcInputs.size() - 1).equals("0.0")) {
				return;
			}
			
			
			if(calcInputs.lastIndexOf("+") >= 0 || calcInputs.lastIndexOf("-") >= 0 || calcInputs.lastIndexOf("*") >= 0 || calcInputs.lastIndexOf("/") >= 0) {
				if(calcInputs.size() >= 3 && calcInputs.get(calcInputs.size() - 1).equals("0") && !Character.isDigit(calcInputs.get(calcInputs.size() - 2).charAt(0))) {
					getFullNumber();
					return;
				}
				
			}
			
			if(calcInputs.size() == 1 && calcInputs.get(0).equals("0")) {
				calcInputs.set(calcInputs.size() - 1, "0");
				return;
			}
			
			if(calcInputs.get(calcInputs.size() - 1).length() > 1) {
				String lastElement = calcInputs.get(calcInputs.size() - 1);
				double numToTurnNeg = Double.parseDouble(lastElement);
				double numNowIsNeg = (-1) * numToTurnNeg;
				String numNowIsNegStr = "" + numNowIsNeg;
				calcInputs.set(calcInputs.size() - 1, numNowIsNegStr);
				txaDisplay.setText(calcInputs.get(calcInputs.size() - 1));
				return;
			}
			
			else if(calcInputs.lastIndexOf("+") >= 0 || calcInputs.lastIndexOf("-") >= 0 || calcInputs.lastIndexOf("*") >= 0 || calcInputs.lastIndexOf("/") >= 0) {
				if(calcInputs.get(calcInputs.size() - 1).length() == 1 && !Character.isDigit(calcInputs.get(calcInputs.size() - 1).charAt(0))) {
					return;
				}
				getFullNumber();
			}
			
			else if (calcInputs.lastIndexOf("+") <= 0 || calcInputs.lastIndexOf("-") <= 0 || calcInputs.lastIndexOf("*") <= 0 || calcInputs.lastIndexOf("/") <= 0) {
				getFullNumberVersion2();
			}
			
			//Does nothing. Just helps method to function correctly for the else if statements above. 
			else {
				
			}
			

			String lastElement = calcInputs.get(calcInputs.size() - 1);
			double numToTurnNeg = Double.parseDouble(lastElement);
			double numNowIsNeg = (-1) * numToTurnNeg;
			String numNowIsNegStr = "" + numNowIsNeg;
			calcInputs.set(calcInputs.size() - 1, numNowIsNegStr);
			txaDisplay.setText(calcInputs.get(calcInputs.size() - 1));
		}
	}
	
	private void getFullNumber() {
		if(calcInputs.get(calcInputs.size() - 1).length() > 1) {
			return;
		}
		
		int lastPlus = calcInputs.lastIndexOf("+");
		int lastMinus = calcInputs.lastIndexOf("-");
		int lastMultiply = calcInputs.lastIndexOf("*");
		int lastDivide = calcInputs.lastIndexOf("/");
		String number = "";
		
		int maxIndex = Math.max(lastPlus,Math.max(lastMinus, Math.max(lastMultiply, lastDivide)));
		
		for(int i = calcInputs.size() - 1; i > maxIndex; i--) {
			number += calcInputs.remove(i);
		}
		
		String reverseStrNum = "";
		for(int i = number.length() - 1; i >= 0; i--) {
			reverseStrNum += number.charAt(i);
		}
		
		calcInputs.add(reverseStrNum);
	}
	
	private void getFullNumberVersion2() {
		if(calcInputs.get(calcInputs.size() - 1).length() > 1) {
			return;
		}
		
		String number = "";
		
		for(int i = calcInputs.size() - 1; i > 0; i--) {
			number += calcInputs.remove(i);
		}
		
		String reverseStrNum = "";
		for(int i = number.length() - 1; i >= 0; i--) {
			reverseStrNum += number.charAt(i);
			//System.out.println(reverseStrNum);
		}
		
		calcInputs.add(reverseStrNum);
	}
	
	private class ButtonSquareRootEventHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			if (txaDisplay.getText().isEmpty()) {
				calcInputs.clear();
				return;
			}
			
			if(calcInputs.size() == 1 && calcInputs.get(0).equals("0")) {
				calcInputs.set(calcInputs.size() - 1, "0");
				return;
			}
			
			if(calcInputs.get(calcInputs.size() - 1).length() > 1 && Double.parseDouble(calcInputs.get(calcInputs.size() - 1)) < 0) {
				return;
			}
			
			//once a number is square rooted, that number is then placed into the last index with a length
			//longer than 1. If one wants to square root this number again, this conditional takes care of that
			//so as not to cause the string to be reversed, then squared. Any element longer then one will be taken care of this way.
			//need to find a better method to do this. But for now, this will do.
			if(calcInputs.get(calcInputs.size() - 1).length() > 1) {
				String strToSquare = calcInputs.get(calcInputs.size() - 1);
				double numToSquare = Double.parseDouble(strToSquare);
				double sqRootNum = Math.sqrt(numToSquare);
				String sqRootedStr = "" + sqRootNum;
				calcInputs.set(calcInputs.size() - 1, sqRootedStr);
				txaDisplay.setText(sqRootedStr);
				return;
			}
			
			//This loops gets a number that is longer then a digit long to be used for the squareroot or squared function
			//Ex: if one desires to square root 234 in array it will be [0, 2, 3, 4]. the conditional calls method to organize
			//those digits into the number 234 to be square rooted
			else if(calcInputs.lastIndexOf("+") >= 0 || calcInputs.lastIndexOf("-") >= 0 || calcInputs.lastIndexOf("*") >= 0 || calcInputs.lastIndexOf("/") >= 0) {
				getFullNumber();
			}
			
			//used if square rooting without any operators in the ArrayList. Works for elements that are of length 1 in the ArrayList
			else if (calcInputs.lastIndexOf("+") <= 0 || calcInputs.lastIndexOf("-") <= 0 || calcInputs.lastIndexOf("*") <= 0 || calcInputs.lastIndexOf("/") <= 0) {
				getFullNumberVersion2();
			}
			
			//Does nothing. Just helps method to function correctly for the else if statements above. 
			else {
				
			}
			
			String strToSquare = calcInputs.get(calcInputs.size() - 1);
			double numToSquare = Double.parseDouble(strToSquare);
			double sqRootNum = Math.sqrt(numToSquare);
			String sqRootedStr = "" + sqRootNum;
			calcInputs.set(calcInputs.size() - 1, sqRootedStr);
			txaDisplay.setText(sqRootedStr);
		}
	}
	
	private class ButtonSquaredEventHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			if (txaDisplay.getText().isEmpty()) {
				calcInputs.clear();
				return;
			}
			 
			if(calcInputs.size() == 1 && calcInputs.get(0).equals("0")) {
				calcInputs.set(calcInputs.size() - 1, "0");
				return;
			}
			
			//see comment for square root event handler. replace square root with squared to get 
			//what is taking place
			if(calcInputs.get(calcInputs.size() - 1).length() > 1) {
				String strToSquare = calcInputs.get(calcInputs.size() - 1);
				double numToSquare = Double.parseDouble(strToSquare);
				double sqrdNum = Math.pow(numToSquare, 2);
				//String sqrdStr = String.format("%.0f", sqrdNum);
				String sqrdStr = "" + sqrdNum;
				calcInputs.set(calcInputs.size() - 1, sqrdStr);
				txaDisplay.setText(sqrdStr);
				return;
			}
			//This loops gets a number that is longer then a digit long to be used for the squareroot or squared function
			else if(calcInputs.lastIndexOf("+") >= 0 || calcInputs.lastIndexOf("-") >= 0 || calcInputs.lastIndexOf("*") >= 0 || calcInputs.lastIndexOf("/") >= 0) {
				getFullNumber();
			}
			
			else if(calcInputs.lastIndexOf("+") <= 0 || calcInputs.lastIndexOf("-") <= 0 || calcInputs.lastIndexOf("*") <= 0 || calcInputs.lastIndexOf("/") <= 0) {
				getFullNumberVersion2();
			}
			
			//Does nothing. Just helps method to function correctly for the else if statements above. 
			else {
				
			}
			
			String strToSquare = calcInputs.get(calcInputs.size() - 1);
			double numToSquare = Double.parseDouble(strToSquare);
			double sqrdNum = Math.pow(numToSquare, 2);
			//String sqrdStr = String.format("%.0f", sqrdNum);
			String sqrdStr = "" + sqrdNum;
			calcInputs.set(calcInputs.size() - 1, sqrdStr);
			txaDisplay.setText(sqrdStr);
		}
	}
	
	
	private class ButtonPlusEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (txaDisplay.getText().isEmpty()) {
				calcInputs.clear();
				return;
			}
			
			if(calcInputs.get(calcInputs.size() - 1).equals("+") || calcInputs.get(calcInputs.size() - 1).equals("-") || calcInputs.get(calcInputs.size() - 1).equals("*") || calcInputs.get(calcInputs.size() - 1).equals("/")) {
				return;
			}
			calcInputs.add("+");
		}
	}
	
	private class ButtonMinusEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (txaDisplay.getText().isEmpty()) {
				calcInputs.clear();
				return;
			}
			
			if(calcInputs.get(calcInputs.size() - 1).equals("+") || calcInputs.get(calcInputs.size() - 1).equals("-") || calcInputs.get(calcInputs.size() - 1).equals("*") || calcInputs.get(calcInputs.size() - 1).equals("/")) {
				return;
			}
			
			calcInputs.add("-");
		}
	}
	
	private class ButtonMultiplyEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (txaDisplay.getText().isEmpty()) {
				calcInputs.clear();
				return;
			}

			if(calcInputs.get(calcInputs.size() - 1).equals("+") || calcInputs.get(calcInputs.size() - 1).equals("-") || calcInputs.get(calcInputs.size() - 1).equals("*") || calcInputs.get(calcInputs.size() - 1).equals("/")) {
				return;
			}
			
			calcInputs.add("*");	
		}
	}
	
	private class ButtonDivideEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (txaDisplay.getText().isEmpty()) {
				calcInputs.clear();
				return;
			}
			
			if(calcInputs.get(calcInputs.size() - 1).equals("+") || calcInputs.get(calcInputs.size() - 1).equals("-") || calcInputs.get(calcInputs.size() - 1).equals("*") || calcInputs.get(calcInputs.size() - 1).equals("/")) {
				return;
			}
			
			calcInputs.add("/");	
		}
	}
	
	
	private class ButtonEqualsEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			System.out.println("Beginning:");
			System.out.println(calcInputs.toString());
			
			ArrayList<Double> operands = new ArrayList<>();
			
			ArrayList<Integer> indexOfOperators = new ArrayList<>();
			
			String concatElements = "";
			
			int indexStartPos = 0;
			
			if (txaDisplay.getText().isEmpty()) {
				calcInputs.clear();
				return;
			}
			
			if(calcInputs.size() == 1) {
				txaDisplay.setText("0");
				return;
			}
			
			if(calcInputs.get(calcInputs.size() - 1).length() == 1 && !Character.isDigit(calcInputs.get(calcInputs.size() - 1).charAt(0))) {
				return;
			}
			
			if(calcInputs.get(1).length() == 1 && !Character.isDigit(calcInputs.get(1).charAt(0))) {
				indexStartPos = 0;
			}
			
			if(calcInputs.get(1).length() > 1 || Character.isDigit(calcInputs.get(1).charAt(0))) {
				indexStartPos = 1;
			}
			
			for(int i = indexStartPos; i < calcInputs.size(); i++) {
				if(calcInputs.get(i).length() > 1) {
					if(i + 1 == calcInputs.size()) {
						concatElements += calcInputs.get(i);
						double toDouble = Double.parseDouble(concatElements);
						operands.add(toDouble);
					}
					
					else {
						double toDouble = Double.parseDouble(calcInputs.get(i));
						operands.add(toDouble);
					}
				}
				
				else if((Character.isDigit(calcInputs.get(i).charAt(0))|| calcInputs.get(i).charAt(0) == '.') && calcInputs.get(i).length() == 1) {
					concatElements += calcInputs.get(i);
					
					if(i + 1 == calcInputs.size()) {
						double toDouble = Double.parseDouble(concatElements);
						operands.add(toDouble);
					}
				}
				
				else {
					if(concatElements.length() == 0) {
						indexOfOperators.add(calcInputs.indexOf(calcInputs.get(i)));
					}
					
					else {
						double toDouble = Double.parseDouble(concatElements);
						operands.add(toDouble);
						concatElements = "";
						indexOfOperators.add(calcInputs.indexOf(calcInputs.get(i)));
					}
				}
			}
			
			AdditionTime(operands, indexOfOperators);
			
			txaDisplay.setText("" + operands.get(0));
			calcInputs.clear();
			calcInputs.add("0");
			String strNum = "" +operands.get(0);
			//for(int i = 0; i < strNum.length(); i++) {
				//if(strNum.length() == 1) {
					//calcInputs.add(strNum.substring(i));
				//}
				
				//else {
					calcInputs.add(strNum);
				//}
			//}
			
			System.out.println("End:");
			System.out.println(calcInputs.toString());
			System.out.println("\n");
			
		}
	}
	
	private void AdditionTime(ArrayList<Double> operands, ArrayList<Integer> indexOfOperators) {
		//System.out.println(operands.size());
		//System.out.println(operands.toString());
		for(int i = 0; i < indexOfOperators.size(); i++) {
			String stringOperator = calcInputs.get(indexOfOperators.get(i));
			double newNum = 0;
			switch(stringOperator) {
			case "+":
				newNum = operands.get(0) + operands.get(1);
				operands.remove(0);
				operands.remove(0);
				operands.add(0, newNum);
				break;
				
			case "-": 
				newNum = operands.get(0) - operands.get(1);
				operands.remove(0);
				operands.remove(0);
				operands.add(0, newNum);
				break;
				
			case "*":
				newNum = operands.get(0) * operands.get(1);
				operands.remove(0);
				operands.remove(0);
				operands.add(0, newNum);
				break;
				
			case "/":
				newNum = operands.get(0) / operands.get(1);
				operands.remove(0);
				operands.remove(0);
				operands.add(0, newNum);
				break;
				
			default:
				break;
			}
		}
	}
}
