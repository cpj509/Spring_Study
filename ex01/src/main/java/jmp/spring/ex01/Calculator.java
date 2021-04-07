package jmp.spring.ex01;

public class Calculator {
	public int calculator(String operandA, String operandB, String operator) {
		if("+".equals(operator)) {
			return Integer.parseInt(operandA) + Integer.parseInt(operandB);
		}
		if("-".equals(operator)) {
			return Integer.parseInt(operandA) - Integer.parseInt(operandB);
		}
		if("*".equals(operator)) {
			return Integer.parseInt(operandA) * Integer.parseInt(operandB);
		}
		if("/".equals(operator)) {
			return Integer.parseInt(operandA) / Integer.parseInt(operandB);
		}
		
		return 0;
	}

}
