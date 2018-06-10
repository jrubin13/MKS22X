import java.util.*;
public class FrontierStack implements Frontier{
    private LinkedList<Location> checks;
    int size;
    public FrontierStack() {
	checks = new LinkedList<Location>();
	size = 0;
    }
    public void add(Location n) {
	checks.add(n);
	size +=1;
    }
    public Location next() {
        if (hasNext()) {
	    Location ans = checks.get(checks.size()-1);
	    checks.remove(checks.get(checks.size()-1));
	    size -= 1;
	    return ans;
	}
	throw new IllegalStateException();
    }
    public boolean hasNext() {
	return size > 0;
    }
}
