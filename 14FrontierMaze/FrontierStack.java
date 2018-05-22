public class FrontierStack implements Frontier{
    private LinkedListStack<Location> checks;
    public FrontierStack() {
	checks = new LinkedList<Location>();
    }
    public void add(Location n) {
	checks.add(n);
    }
    public Location next() {
	if (hasNext()) {
	    return checks.get(checks.size());
	}
    }
    public boolean hasNext() {
	return checks.size() > 0;
    }
}
