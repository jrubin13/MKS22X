public class FrontierQueue implements Frontier {
    private Queue<Location> checks;
    public FrontierQueue() {
	checks = new LinkedList<Location>();
    }
    public void add(Location n) {
	checks.add(n);
    }
    public Location next() {
	if (hasNext()) {
	    return checks.get(0);
	}
    }
    public boolean hasNext() {
	return checks.size() > 0;
    }
}
