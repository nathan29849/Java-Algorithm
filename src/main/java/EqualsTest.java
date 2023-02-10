import java.util.Objects;

public class EqualsTest {

	public static void main(String[] args) {
		Long num1 = 1L;
		Long num2 = 1L;

		System.out.println(num1 == num2);
		System.out.println(Objects.equals(num1, num2));
		System.out.println(num1.equals(num2));

		Wiltord w1 = new Wiltord(20);
		Wiltord w2 = new Wiltord(20);
		System.out.println(w1.equals(w2));
		System.out.println(Objects.equals(w1, w2));
		System.out.println(w1 == w2);
		String a = "Asdasfad";
		a.equals(123);

	}

}
