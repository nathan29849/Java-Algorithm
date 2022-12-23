package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1991 {

	private static final List<Character> PRE_ORDER = new ArrayList<>();
	private static final List<Character> IN_ORDER = new ArrayList<>();
	private static final List<Character> POST_ORDER = new ArrayList<>();


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Node root = new Node('A');

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			char a = st.nextToken().charAt(0);
			char b = st.nextToken().charAt(0);
			char c = st.nextToken().charAt(0);
			Node parent = root.find(a);
			if (b != '.') {
				parent.addLeft(new Node(b), true);
			}

			if (c != '.') {
				parent.addLeft(new Node(c), false);
			}
		}

		Node.getPreOrder(root, PRE_ORDER);
		Node.getInOrder(root, IN_ORDER);
		Node.getPostOrder(root, POST_ORDER);
		StringBuilder preSB = new StringBuilder();
		StringBuilder inSB = new StringBuilder();
		StringBuilder postSB = new StringBuilder();

		for (int i = 0; i < n; i++) {
			preSB.append(PRE_ORDER.get(i));
			inSB.append(IN_ORDER.get(i));
			postSB.append(POST_ORDER.get(i));
		}

		System.out.println(preSB);
		System.out.println(inSB);
		System.out.println(postSB);

	}

}

class Node {
	char value;
	Node left;
	Node right;

	public Node(char value) {
		this.value = value;
	}

	public void addLeft(Node n, boolean b) {
		if (b) {
			left = n;
		} else {
			right = n;
		}
	}

	public Node find(char v) {
		Node node1 = null;
		Node node2 = null;
		if (this.value == v) {
			return this;
		} else {
			if (left != null) {
				node1 = left.find(v);
			}

			if (right != null) {
				node2= right.find(v);
			}
		}
		if (node1 != null) {
			return node1;
		} else {
			return node2;
		}
	}

	public static void getPreOrder(Node now, List<Character> orders) {
		orders.add(now.value);
		if (now.left != null) {
			getPreOrder(now.left, orders);
		}
		if (now.right != null) {
			getPreOrder(now.right, orders);
		}

	}

	public static void getInOrder(Node now, List<Character> orders) {
		if (now.left == null) {
			orders.add(now.value);
		} else {
			getInOrder(now.left, orders);
			orders.add(now.value);
		}

		if (now.right != null) {
			getInOrder(now.right, orders);
		}
	}

	public static void getPostOrder(Node now, List<Character> orders) {
		if (now.left == null && now.right == null) {
			orders.add(now.value);
		}

		if (now.left != null){
			getPostOrder(now.left, orders);
		}

		if (now.right != null) {
			getPostOrder(now.right, orders);
		}

		if (now.left != null || now.right != null) {
			orders.add(now.value);
		}
	}

}
