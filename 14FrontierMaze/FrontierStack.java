import java.util.*;
public class FrontierStack implements Frontier{
    private LinkedList<Location> checks;
    public FrontierStack() {
	checks = new LinkedList<Location>();
    }
    public void add(Location n) {
	checks.add(n);
    }
    public Location next() {
        if (hasNext()) {
	    Location ans = checks.get(checks.size()-1);
	    checks.remove(checks.get(checks.size()-1));
	    return ans;
	}
	throw new IllegalStateException();
    }
    public boolean hasNext() {
	return checks.size() > 0;
    }
}
