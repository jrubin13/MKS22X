public class Driver1{
    public static void main(String[] args) {
        
	MazeSolver test = new MazeSolver("data2.dat");
	test.setAnimate(true);
	test.solve(0);
    }
}
