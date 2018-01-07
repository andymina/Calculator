import java.util.ArrayList;

public class Computer {
	public ArrayList equation = new ArrayList<String>();
	public String firstNum = "";
	public String secondNum = "";
			
	public String solve() {
		double answer = 0;
		String operator = "";
		
		if (((equation.get(0).equals("+") || equation.get(0).equals("-")) || (equation.get(0).equals("*") || equation.get(0).equals("/")))) {
			return "0.0";
		}
		
		int i = 0;
		while (i < equation.size()) {
			if (!((equation.get(i).equals("+") || equation.get(i).equals("-")) || (equation.get(i).equals("*") || equation.get(i).equals("/")))) {
				firstNum += equation.get(i);
				i++;
			} else {
				operator = (equation.get(i)).toString();
				secondNum = concatenate(secondNum, i, numOfElementsUntilOperator(i, "forwards"));
				
				double num1 = Double.parseDouble(firstNum);
				double num2 = Double.parseDouble(secondNum);
				answer = checkOperator(operator, num1, num2);
				
				int upperLimit = i + numOfElementsUntilOperator(i, "forwards");
				for (int j = upperLimit; j >= 0; j--) {
					equation.remove(j);
				}
				
				equation.add(0, Double.toString(answer));
				i = 0;
				firstNum = "";
				secondNum = "";
			}
		}
		
		firstNum = "";		
		return Double.toString(answer);
	}
	
	private int numOfElementsUntilOperator(int indexOfOperator, String orientation) {
		int count = 0;
		int startingIndex;
		
		if (orientation.equals("forwards")) {
			startingIndex = indexOfOperator + 1;
		} else {
			startingIndex = indexOfOperator - 1;
		}
		
		for (int i = startingIndex; i < equation.size(); i++) {
			if (!((equation.get(i) == "+") || (equation.get(i) == "-") || (equation.get(i) == "*") || (equation.get(i) == "/"))) {
				count++;
			} else {
				return count;
			}
		}
		
		return count;
	}
	
	private String concatenate(String original, int startIndex, int lengthOfDesired) {
		int index = startIndex + 1;
		for (int i = lengthOfDesired; i >= 1; i--) {
			original += equation.get(index);
			index++;
		}
		
		return original;
	}
	
	private double checkOperator(String operatorSign, double numFirst, double numSecond) {
		if (operatorSign.equals("+")) {
			return numFirst + numSecond;
		} else if (operatorSign.equals("-")) {
			return numFirst - numSecond;
		} else if (operatorSign.equals("*")) {
			return numFirst * numSecond;
		} else {
			return numFirst / numSecond;
		}
	}
}
