package controller;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import java.util.ArrayList;

public class Calculator {
	
	//Numeric Buttons on calculator 
	protected Button btn1, btn2, btn3, btn4, btn5,
			  btn6, btn7, btn8, btn9;
	
	//Button Operators
	protected Button btnPlus, btnMinus, btnMultiply, btnDivide, btnEquals;
	
	//Miscellaneous Buttons 1
	protected Button btnDecimal, btnOnClear, btn0; 
	
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
		btn2 = new Button("2");
		btn3 = new Button("3");
		
		h123.getChildren().addAll(btn1, btn2, btn3);
		
		return h123;
		
	}
	
	public Pane buildButtons456() {
		HBox h456 = new HBox();
		
		btn4 = new Button("4");
		btn5 = new Button("5");
		btn6 = new Button("6");
		
		h456.getChildren().addAll(btn4, btn5, btn6);
		
		return h456;
		
	}
	
	public Pane buildButtons789() {
		HBox h789 = new HBox();
		
		btn7 = new Button("7");
		btn8 = new Button("8");
		btn9 = new Button("9");
		
		h789.getChildren().addAll(btn7, btn8, btn9);
		
		return h789;
		
	}
	
	public Pane buildZerosRow() {
		HBox h = new HBox();
		
		btnOnClear = new Button("ON/C");
		//maxWidth = btnOnClear.getMaxWidth();
		//System.out.println(maxWidth);
		btnOnClear.getStyleClass().add("redButtWhiteText");
		btn0 = new Button("0");
		btnDecimal = new Button(".");
		
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
		txaDisplay.setPrefColumnCount(25);
		txaDisplay.setPrefRowCount(0);
		h.getChildren().add(txaDisplay);
		return h;
	}
}
