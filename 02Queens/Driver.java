public class Driver {
    public static void main(String[] args) {
	QueenBoard q = new QueenBoard(11);
	//System.out.println(q.addQueen(0));
	//System.out.println(q.addQueen(3,5));
	//System.out.println(q.removeQueen(0));
	//System.out.println(q.removeQueen(3,5));
	System.out.println(q);
	System.out.println(q.solve());
	System.out.println(q);
    }
}
