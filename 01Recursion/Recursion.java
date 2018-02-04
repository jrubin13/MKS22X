public class Recursion {
    public int fact(int n) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	if (n == 0) {
	    return 1;
	}
	else {
	    return n * fact(n-1);
	}
    }
    public int fib(int n) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	if (n <= 1) {
	    return n;
	}
        return fibHelp(n-1,n-2, 0);
    }
    private int fibHelp(int a, int b, int sum) {
	if (a <= 0 || b <= 0) {
	    return sum;
	}
	return fibHelp(a-1, a-2, sum);
    }
    public int badFib(int n) {
	if (n <= 1) {
	    return n;
	}
	return badFib(n-1) + badFib(n-2);
    }
    public double sqrt(double n) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	if (n == 0) {
	    return 0;
	}
	return sqrtHelp(n, 1.0);
    }
    private double sqrtHelp(double actual, double guess){
	guess = (actual/guess + guess)/2;
	if (good(actual, guess)) {
	    return guess;
	}
	return sqrtHelp(actual, guess);
    }
    private boolean good(double actual, double guess) {
	double num = guess * guess;
	double error = (Math.abs(num - actual)/actual)*100;
	if (error <= .001) {
	    return true;
	}
	return false;
    }
}
