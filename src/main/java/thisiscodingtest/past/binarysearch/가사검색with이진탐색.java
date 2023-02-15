package thisiscodingtest.past.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 가사검색with이진탐색 {

	public static void main(String[] args) {
		가사검색with이진탐색 m = new 가사검색with이진탐색();
		int[] result = m.solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
			new String[]{"fro??", "????o", "fr???", "fro???", "pro?"});
		System.out.println(result);
	}

	public int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];
		Map<Integer, List<String>> wordMap = new HashMap<>();
		Map<Integer, List<String>> reverseWordMap = new HashMap<>();
		int size = 0;
		StringBuffer sb;
		for (String word : words) {
			size = word.length();
			List<String> t = wordMap.getOrDefault(size, new ArrayList<>());
			List<String> rt = reverseWordMap.getOrDefault(size, new ArrayList<>());
			sb = new StringBuffer(word);
			sb.reverse();
			t.add(word);
			rt.add(sb.toString());
			wordMap.put(size, t);
			reverseWordMap.put(size, rt);
		}

		for(int k : wordMap.keySet()){
			wordMap.get(k).sort(String::compareTo);
			reverseWordMap.get(k).sort(String::compareTo);
		}

		List<String> wordList;
		int n = 0;
		for (String query : queries) {
			size = query.length();
			if (query.charAt(0) == '?') {
				sb = new StringBuffer(query);
				sb.reverse();
				query = sb.toString();
				wordList = reverseWordMap.get(size);
				if (wordList == null) {
					n++;
					continue;
				}
				if (query.charAt(0)=='?') {
					answer[n++] = wordList.size();
					continue;
				}
			} else {
				wordList = wordMap.get(size);
			}

			if (wordList == null) {
				n++;
				continue;
			}


			String first = query.replace('?', 'a');
			String second = query.replace('?', 'z');

			// leftBinarySearch
			int left = leftBinarySearch(first, wordList);

			// rightBinarySearch
			int right = rightBinarySearch(second, wordList);
			answer[n++] = right-left;
		}

		return answer;
	}

	int leftBinarySearch(String word, List<String> wordList) {
		int n = wordList.size();
		int start = 0;
		int end = n;
		while (start < end) {
			int mid = (start+end) / 2;
			if (word.compareTo(wordList.get(mid)) <= 0) {
				end = mid;
			} else {
				start = mid+1;

			}
		}
		return start;
	}

	int rightBinarySearch(String word, List<String> wordList) {
		int n = wordList.size();
		int start = 0;
		int end = n;

		while (start < end) {
			int mid = (start+end) / 2;
			if (word.compareTo(wordList.get(mid)) <0) {
				end = mid;
			} else {
				start = mid + 1;

			}
		}
		return start;
	}

}
