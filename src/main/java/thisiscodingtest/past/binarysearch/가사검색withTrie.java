package thisiscodingtest.past.binarysearch;

import java.util.Arrays;

public class 가사검색withTrie {

	public static void main(String[] args) {
		가사검색withTrie m = new 가사검색withTrie();
		int[] result = m.solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
			new String[]{"fro??", "????o", "fr???", "fro???", "pro?"});
		System.out.println(result);
	}

	public int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];
		int[] wordLengths = new int[10001];
		Trie[] trie = new Trie[10001];
		Trie[] reverseTrie = new Trie[10001];
		for (int i = 0; i < 10001; i++) {
			trie[i] = new Trie();
			reverseTrie[i] = new Trie();
		}

		int length;
		StringBuffer sb;
		for (String word : words) {
			length = word.length();
			wordLengths[length]++;
			trie[length].insert(word);
			sb = new StringBuffer(word);
			sb.reverse();
			reverseTrie[length].insert(sb.toString());
		}
		int n = -1;

		for (String query : queries) {
			n++;
			length = query.length();
			if (query.charAt(0) != '?') {
				answer[n] = trie[length].search(query);
			} else {
				if (query.charAt(length - 1) == '?') {
					answer[n] = wordLengths[length];
					continue;
				}
				sb = new StringBuffer(query);
				sb.reverse();
				answer[n] = reverseTrie[length].search(sb.toString());
			}
		}

		return answer;
	}

	class Trie {
		Trie[] children = new Trie[26];
		int a = Character.getNumericValue('a');
		int cnt;

		Trie() {
			cnt = 0;
		}

		void insert(String word) {
			Trie now = this;
			for (char ch : word.toCharArray()) {
				int idx = Character.getNumericValue(ch) - a;
				if (now.children[idx] == null) {
					now.children[idx] = new Trie();
				}
				now = now.children[idx];
				now.cnt++;
			}
		}

		int search(String word) {
			Trie now = this;
			for (char ch : word.toCharArray()) {
				if (ch == '?') {
					return now.cnt;
				}
				int idx = Character.getNumericValue(ch)-a;
				now = now.children[idx];
				if (now == null) {
					return 0;
				}
			}
			return now.cnt;
		}

	}
}
