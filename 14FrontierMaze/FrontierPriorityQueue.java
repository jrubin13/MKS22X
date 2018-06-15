import java.util.*;
import java.io.FileNotFoundException;
import java.util.*;
public class FrontierPriorityQueue implements Frontier{
    private MyHeap<Location> checks;
    public FrontierPriorityQueue() {
	checks = new MyHeap<Location>();
    }
    public void add(Location n) {
	checks.add(n);
    }
    public Location next() {
	if (hasNext()) {
	    return checks.remove();
	}
	throw new IllegalStateException();
    }
    public boolean hasNext() {
	return checks.size() > 0;
    }
    public String toString() {
	String ans = "[";
	int i = 0;
	while (hasNext()) {
	    ans += "(" + checks.peek(i).row() + " , " + checks.peek(i).col() + "), ";
	    i += 1;
	}
	ans += "]";
	return ans;
    }
}
