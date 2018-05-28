public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private int dist;
    private int distfromstart;
    public Location(int _x, int _y, Location prev, int d, int distfroms) {
	x = _x;
	y = _y;
	previous = prev;
	dist = d;
	distfromstart = distfroms;
    }
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
    public int getDist() {
	return dist;
    }
    public int getDistFromStart() {
	return distfromstart;
    }
    public Location getPrev() {
	return previous;
    }
    public String toString() {
	return "(" + y + ", " + x + ")";
    }
    public int compareTo(Location o) {
	int a = getDist();
	int b = o.getDist();
	return a - b;
    }
}
