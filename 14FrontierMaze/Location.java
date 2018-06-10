public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private int dist;
    private int totdist;
    public Location(int _x, int _y, Location prev, int d) {
	x = _x;
	y = _y;
	previous = prev;
	totdist = d;
	dist = d;
    }
    public Location(int _x, int _y, Location prev, int d, int combineddist) {
	x = _x;
	y = _y;
	previous = prev;
	dist = d;
	totdist = combineddist;
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
    public int getTotalDist() {
	return totdist;
    }
    public Location getPrev() {
	return previous;
    }
    public String toString() {
	return "(" + x + ", " + y + ")";
    }
    public int compareTo(Location o) {
	int a = getTotalDist();
	int b = o.getTotalDist();
	return b - a;
    }
}
