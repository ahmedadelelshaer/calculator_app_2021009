package ejb;

import javax.ejb.Stateless;

@Stateless
public class calcculationFunction {
	public int number1;
	public int number2;
	public String operation;
	public float calculate(calcculationFunction cale) {
		float result=0;
		
		if (cale.operation=="+") {
			result=cale.number1+cale.number2;
		}
		else if (cale.operation== "-") {
			result=cale.number1-cale.number2;
		}
		
		else if (cale.operation== "*") {
			result=cale.number1*cale.number2;
		}
		
		else if (cale.operation== "/") {
			result=cale.number1/cale.number2;
		}
		return result;
	}
}
