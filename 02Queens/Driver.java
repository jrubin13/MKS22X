public class Driver {
    public static void main(String[] args) {
	QueenBoard q = new QueenBoard(7);
	q.addQueen(0,0);
	q.addQueen(3,5);
	q.removeQueen(0,0);
	System.out.println(q);
    }
}
