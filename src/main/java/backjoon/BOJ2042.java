package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간 합 구하기
public class BOJ2042 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, m, k;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		SegmentTree tree = new SegmentTree(n);
		long[] nums = new long[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Long.parseLong(br.readLine());
		}
		tree.init(nums, 0, 0, n);

		long a, b, c;
		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			c = Long.parseLong(st.nextToken());
			if (a == 1) {
				tree.update(0, 0, tree.treeSize, (int) b, c);
			} else {
				System.out.println(tree.sum(0, 0, tree.treeSize, (int) b, (int) c));
			}
		}
	}

	private static class SegmentTree {
		// 참고 : https://hongjw1938.tistory.com/20
		private long[] tree;
		public int treeSize;

		SegmentTree(int n) {
			double treeHeight = Math.ceil(Math.log(n)/Math.log(2))+1;
			this.treeSize = (int) Math.pow(2, treeHeight);
			tree = new long[treeSize];
		}

		public long init(long[] nums, int nodeIdx, int start, int end) {

			if (start == end) {
				tree[nodeIdx] = nums[nodeIdx];
				return tree[nodeIdx];
			}

			tree[nodeIdx] = init(nums, nodeIdx * 2, start, (start + end) / 2)
				+ init(nums, (nodeIdx * 2) + 1, ((start + end) / 2) + 1, end);
			return tree[nodeIdx];
		}

		public void update(int nodeIdx, int start, int end, int updateNodeIdx, long updateValue) {

			if (updateNodeIdx < start || end < updateNodeIdx) {
				return;
			}

			tree[nodeIdx] += updateValue;

			if (start != end) {
				update(nodeIdx*2, start, (start+end)/2, updateNodeIdx, updateValue);
				update(nodeIdx*2, ((start+end)/2)+1, end, updateNodeIdx, updateValue);
			}
		}

		public long sum(int nodeIdx, int start, int end, int left, int right) {

			if (left > end || right < start) {
				return 0;
			}

			if (left <= start && right <= end) {
				return tree[nodeIdx];
			}

			return sum(nodeIdx * 2, start, (start + end) / 2, left, right) +
				sum(nodeIdx * 2 + 1, ((start + end) / 2) + 1, end, left, right);
		}
	}
}
