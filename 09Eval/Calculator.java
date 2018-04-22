import java.util.*;
import java.io.*;
public class Calculator {
    LinkedList<Double> data = new LinkedList<>();
    public double eval(String s) {
        String[] data1 = s.split(" ");
	//System.out.println(Arrays.toString(data1));
	for (int i = 0 ; i < data1.length; i++) {
	    //System.out.println(data1[i]);
	    if (data1[i].equals("+")) {
	        data.push(data.pop() + data.pop());
	    }
	    else if (data1[i].equals("-")) {
		double num1 = data.pop();
		double num2 = data.pop();
	        data.push(num2 - num1);
	    }
	    else if (data1[i].equals("*")) {
	        data.push(data.pop() * data.pop());
	    }
	    else if (data1[i].equals("/")) {
	        double num1 = data.pop();
		double num2 = data.pop();
	        data.push(num2 / num1);
	    }
	    else if (data1[i].equals("%")) {
	        double num1 = data.pop();
		double num2 = data.pop();
	        data.push(num2 % num1);
	    }
	    else {
		data.push(Double.parseDouble(data1[i]));
		//System.out.println(data);
	    }
	    //System.out.println(data);
	}
	return data.pop();
    }
    public static void main(String[] args) {
	Calculator a = new Calculator();
	System.out.println(a.eval("10 2.0 +"));
	System.out.println(a.eval("11 3 - 4 + 2.5 *"));
	System.out.println(a.eval("8 2 + 99 9 - * 2 + 9 -"));
	
    }
}
