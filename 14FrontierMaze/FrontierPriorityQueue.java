import java.util.*;
import java.io.FileNotFoundException;
import java.util.*;
public class FrontierPriorityQueue implements Frontier{
    private PriorityQueue<Location> checks;
    public FrontierPriorityQueue() {
	checks = new PriorityQueue<Location>();
    }
    public void add(Location n) {
	checks.add(n);
    }
    /*public String toString() {
	String ans = "[";
	for (int i = 0; i < checks.size(); i++) {
	    ans += checks.peek(i) + ", ";
	}
	if (ans.length() > 2) {
	    return ans.substring(0, ans.length()-2) + "]";
	}
	return "[]";
	}*/
    public Location next() {
	if (hasNext()) {
	    return checks.remove();
	}
	throw new IllegalStateException();
    }
    public boolean hasNext() {
	return checks.size() > 0;
    }
}
