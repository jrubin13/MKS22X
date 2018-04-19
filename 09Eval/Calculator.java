import java.util.*;
import java.io.*;
public class Calculator {
    LinkedList<String> data = new LinkedList<>();
    public double eval(String s) {
        String[] data1 = s.split(" ");
	for (int i = 0 ; i < data1.length; i++) {
	    /*if (data1[i] != "+" && data1[i] != "-" && data1[i] != "/" && data1[i] != "*" && data1[i] != "%") {
		Double.parseDouble(data1[i]);
		}*/
	    data.add(data1[i]);
	}
	//System.out.println(data);
	double ans = Double.parseDouble(data.get(0));
	data.pop();
	double num = 0.0;
        while (data.size() > 1) {
	    num = Double.parseDouble(data.get(0));
	    if (data.get(1).equals("+")) {
	        ans += num;
		data.pop();
		data.pop();
	    }
	    else if (data.get(1).equals("-")) {
		ans -= num;
		data.pop();
		data.pop();
	    }
	    else if (data.get(1).equals("*")) {
		ans = ans * num;
		data.pop();
		data.pop();
	    }
	    else if (data.get(1).equals("/")) {
		ans = ans / num;
		data.pop();
		data.pop();
	    }
	    else if (data.get(1).equals("%")) {
		ans = ans % num;
		data.pop();
		data.pop();
	    }
	    else {
	        data.pop();
	    }
	}
	return ans;
    }
    public static void main(String[] args) {
	Calculator a = new Calculator();
	System.out.println(a.eval("10 2.0 +"));
	System.out.println(a.eval("11 3 - 4 + 2.5 *"));
	System.out.println(a.eval("8 2 + 99 9 - * 2 + 9 -"));
	
    }
}
