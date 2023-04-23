package Pair_Sum_BST;

import java.util.*;

public class PairSum {

	static class pair {
		int first, second;

		pair(int f, int s) {
			first = f;
			second = s;
		}
	}

	static class NewNode {
		int val;
		NewNode left, right;

		NewNode(int data) {
			val = data;
			left = null;
			right = null;
		}
	};

	static NewNode insert(NewNode root, int key) {
		if (root == null)
			return new NewNode(key);
		if (key < root.val)
			root.left = insert(root.left, key);
		else
			root.right = insert(root.right, key);
		return root;
	}

	static void inorder(NewNode root, ArrayList<Integer> v) {
		if (root == null) {
			return;
		}
		inorder(root.left, v);
		v.add(root.val);
		inorder(root.right, v);
	}

	static pair findTarget(NewNode root, int k) {

		ArrayList<Integer> v = new ArrayList<>();
		inorder(root, v);
		int n = v.size();
		int i = 0;
		int j = n - 1;
		while (j > i) {
			if (v.get(i) + v.get(j) == k) {
				return new pair(v.get(i), v.get(j));
			} else if (v.get(i) + v.get(j) > k) {
				j--;
			} else {
				i++;
			}
		}
		return new pair(-1, -1);
	}

	// Driver code
	public static void main(String[] args) {
		NewNode root = null;
		root = insert(root, 40);
		root = insert(root, 20);
		root = insert(root, 60);
		root = insert(root, 10);
		root = insert(root, 30);
		root = insert(root, 50);
		root = insert(root, 70);

		Scanner scan = new Scanner(System.in);
		int sum = scan.nextInt();
		pair ans = findTarget(root, sum);
		if (ans.first == -1 && ans.second == -1) {
			System.out.println("Nodes are not found");
		} else {
			System.out.println("Pair is (" + ans.first + ", " + ans.second + ")");
		}
	}
}
