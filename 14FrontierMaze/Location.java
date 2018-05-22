public class Location{
    private int x,y;
    private Location previous;
    public Location(int _x, int _y, Location prev) {
	x = _x;
	y = _y;
	previous = prev;
    }
    public int row() {
	return x;
    }
    public int col() {
	return y;
    }
    public Location getPrev() {
	return previous;
    }
    public String toString() {
	return "(" + y + ", " + x + ")";
    }
}
