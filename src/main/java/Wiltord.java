import java.util.Arrays;
import java.util.List;

public class Wiltord {

	int point;

	public static void main(String[] args) {
		List<int[]> nums = Arrays.asList(new int[]{1, 2, 3});
		nums.add(new int[]{4, 5, 6});
		System.out.println(nums);
	}

	public Wiltord(int point) {
		this.point = point;
	}

}
