import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class Driver {
    public static void main(String[] args) {
	Quick a  = new Quick();
	int[] data = { 2, 10, 15, 23, 0,  5};
	a.quicksort(data);
	System.out.println(Arrays.toString(data));
    }
}
