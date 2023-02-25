package readme;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class README {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(
			new FileReader("src/main/resources/message.txt", StandardCharsets.UTF_8)
		);

		String str;
		String[] split;
		Map<String, String> problems = new HashMap<>();
		while ((str = br.readLine()) != null) {
			split = str.split("]");
			problems.put(split[0] + "]", split[1]);
		}

		List<String> problemList = new ArrayList<>(problems.keySet());
		Collections.shuffle(problemList);

		StringBuffer sb = new StringBuffer();
		int no = 0;
		sb.append("|순서|문제|\n")
			.append("|---|---|\n");
		for (String p : problemList) {
			sb.append("|")
				.append(++no).append("|")
				.append(p).append(problems.get(p))
				.append("|")
				.append("\n");
		}

		System.out.println(sb);
	}
}
