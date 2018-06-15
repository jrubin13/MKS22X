import java.util.*;
public class FrontierQueue implements Frontier {
    private LinkedList<Location> checks;
    public FrontierQueue() {
	checks = new LinkedList<Location>();
    }
    public void add(Location n) {
	checks.add(n);
    }
    public String toString() {
	String ans = "[";
	for (int i = 0; i < checks.size(); i++) {
	    ans += checks.get(i) + ", ";
	}
	if (ans.length() > 2) {
	    return ans.substring(0, ans.length()-2) + "]";
	}
	return "[]";
    }
    public Location next() {
	if (hasNext()) {
	    Location ans = checks.remove();
	    return ans;
	}
	throw new IllegalStateException();
    }
    public boolean hasNext() {
	return checks.size() > 0;
    }
}
