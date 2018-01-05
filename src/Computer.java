import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;
import java.util.ArrayList;

public class Computer {
	public ArrayList equation = new ArrayList<String>();
	
	public String solve() {
		int operatorCount = 0;
		int operatorIndex = 0;
		double answer = 0;
		
		String firstNum = "";
		String secondNum = "";
		
		if ((equation.get(0) == "+") || (equation.get(0) == "-") || (equation.get(0) == "*") || (equation.get(0) == "/")) {
			return "0.0";
		}
		
		for (int i = 0; i < equation.size(); i++) {
			if (equation.get(i) != "+") {
				firstNum += equation.get(i);
			} else {
				secondNum = concatenate(secondNum, i, numOfElementsUntilOperator(i, "forwards"));
				break;
			}
		}
		
		System.out.println(firstNum);
		System.out.println(secondNum);
		double num1 = Double.parseDouble(firstNum);
		double num2 = Double.parseDouble(secondNum);
		answer = num1 + num2;
		
		equation.clear();
		return Double.toString(answer);
	}
	
	public int numOfElementsUntilOperator(int indexOfOperator, String orientation) {
		int count = 0;
		int startingIndex;
		
		if (orientation == "forwards") {
			startingIndex = indexOfOperator + 1;
		} else {
			startingIndex = indexOfOperator - 1;
		}
		
		for (int i = startingIndex; i < equation.size(); i++) {
			if (equation.get(i) != "+") {
				count++;
			} else {
				return count;
			}
		}
		
		return count;
	}
	
	public String concatenate(String original, int startIndex, int lengthOfDesired) {
		int index = startIndex + 1;
		for (int i = lengthOfDesired; i >= 1; i--) {
			original += equation.get(index);
			index++;
		}
		
		return original;
	}
}
