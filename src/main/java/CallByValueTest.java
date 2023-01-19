public class CallByValueTest {
	// call by reference (X)
	// call by value (O)
	static int X = 10;
	public static void main(String[] args) {
		int x = 100;
		System.out.println("---before---");
		System.out.println(x);
		System.out.println(X);
		run(x);
		run2();
		System.out.println("---after---");
		System.out.println(x);
		System.out.println(X);
	}

	private static void run(int x) {
		x++;
	}

	private static void run2() {
		X++;
	}

}
