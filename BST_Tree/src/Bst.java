import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

public class Bst {

	private Node root;

	public class Node {
		int key;
		Node leftChild;
		Node rightChild;

		Node(int key) {
			this.key = key;
		}

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public String toString() {
			return "key" + this.key;
		}
	}

	public Node getRoot() {
		return this.root;
	}

	public void addNode(int key) {
		if (findNode(key) != null) // 이미 존재하면 그냥 리턴
			return;

		Node newNode = new Node(key);

		if (root == null) {
			root = newNode; // 트리가 비어있으면 root에 삽입
		} else {
			Node focusNode = root;  //탐색용 노드
			Node parent;			// 탐색용 노드의 부모 노드

			while (true) {
				parent = focusNode; // 이동
				if (key < parent.key) { 	//삽입하려는 키가 현재 노드보다 작으면
					focusNode = parent.leftChild;	// 왼쪽으로 이동

					if (focusNode == null) {	// 왼쪽 노드가 비어있으면
						parent.leftChild = newNode;	// 왼쪽 노드에 삽입
						return;
					}
				} else {		//삽입하려는 키가 현재 노드와 같거나 크다면
					focusNode = parent.rightChild; // 오른쪽으로 이동

					if (focusNode == null) {	// 오론쪽 노드가 비어있으면
						parent.rightChild = newNode;	// 오른쪽 노드에 삽입
						return;
					}
				}
			}
		}
	}

	public boolean deleteNode(int key) {
		Node focusNode = root;	// focusNode와 parent가 같을 수 있는 경우는 찾으려는 key가 root인 경우
		Node parent = root;
		boolean isLeftChild = true;

		while (focusNode.key != key) {	//while 문이 끝나고 나면 focusNode는 삭제될 노드를 가리키고, parent는 삭제될 노드의 부모노드를 가리킨다.
										//삭제될 노드가 부모노드의 left 인지 right 인지에 대한 정보를 가지게 된다
			parent = focusNode;  // 삭제할 노드를 찾는 과정중(while문)에서 focusNode 는 계속해서 바뀌고 parent 노드는 여기서 기억해둔다

			if (key < focusNode.key) {
				isLeftChild = true;			// 지우려는 노드가 왼쪽에 있는 노드냐 기록용
				focusNode = parent.leftChild;
			} else {
				isLeftChild = false; 		// 지우려는 노드가 오른쪽에 있는 노드냐 기록용
				focusNode = parent.rightChild;
			}
				
			if (focusNode == null) {	 // 찾으려는 노드가 없는 경우
				return false;
			}
		}

		Node replacementNode; 
		if (focusNode.leftChild == null && focusNode.rightChild == null) { // 지우려는 노드의 자식 노드가 없는 경우
			if (focusNode == root)
				root = null;
			else if (isLeftChild)
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}

		else if (focusNode.rightChild == null) { // 지우려는 노드의 오른쪽 자식노드가 없는 경우 (왼쪽 자식 노드만 있는 경우)
			replacementNode = focusNode.leftChild;
			if (focusNode == root)
				root = replacementNode;
			else if (isLeftChild)
				parent.leftChild = replacementNode;
			else
				parent.rightChild = replacementNode;
		}

		else if (focusNode.leftChild == null) { // 지우려는 노드의 왼쪽 자식노드가 없는 경우 (오른쪽 자식 노드만 있는 경우)
			replacementNode = focusNode.rightChild;
			if (focusNode == root)
				root = replacementNode;
			else if (isLeftChild)
				parent.leftChild = replacementNode;
			else
				parent.rightChild = replacementNode;
		}

		else {  // 지우려는 노드의 양쪽 자식노드가 모두 있는 경우
		    	// 오른쪽 자식 노드의 sub tree 에서 가장 작은 노드를 찾아서 지우려는 노드가 있던 자리에 위치시킨다
			
			
			Node rightSubTree = focusNode.rightChild;  // 삭제될 노드의 오른쪽 sub tree 를 저장해둔다
			
			replacementNode = focusNode.rightChild; // 삭제될 노드 자리에 오게 될 새로운 노드 (오른쪽 sub tree 에서 가장 작은 값을 가진 노드)
	        										// 이 노드는 왼쪽 child 가 없어야 한다 (가장 작은 값이기 때문에)

			if (focusNode == root)
				root = replacementNode;
			else if (isLeftChild)
				parent.leftChild = replacementNode;
			else
				parent.rightChild = replacementNode;

			replacementNode.rightChild = rightSubTree;	// 지우려는 노드의 오른쪽 sub tree 에 노드가 하나밖에 없는 경우
			if (replacementNode == rightSubTree)
				replacementNode.rightChild = null;

			replacementNode.leftChild = focusNode.leftChild;	// 지우려는 노드의 왼쪽 subtree 를 연결시킨다
		}
		return true;
	}

	private Node getRightMinNode(Node rightChildRoot) {
		Node parent = rightChildRoot;
		Node focusNode = rightChildRoot;

		while (focusNode.leftChild != null) {
			parent = focusNode;
			focusNode = focusNode.leftChild;
		}
		parent.leftChild = null;
		return focusNode;
	}

	public void inOrderTraverse(Node focusNode) {
		if (focusNode != null) {
			inOrderTraverse(focusNode.leftChild);
			System.out.print(focusNode.key + " ");
			inOrderTraverse(focusNode.rightChild);
		}
	}

	public void preOrderTraverse(Node focusNode) {
		if (focusNode != null) {
			System.out.print(focusNode.key + " ");
			preOrderTraverse(focusNode.leftChild);
			preOrderTraverse(focusNode.rightChild);
		}
	}

	public void postOrderTraverse(Node focusNode) {
		if (focusNode != null) {
			postOrderTraverse(focusNode.leftChild);
			postOrderTraverse(focusNode.rightChild);
			System.out.print(focusNode.key + " ");
		}
	}

	public Node findNode(int key) {
		if (root == null)		//트리가 비어있을 때
			return null;

		Node focusNode = root;

		while (focusNode.key != key) {
			if (key < focusNode.key) {		// 현재 노드보다 작으면
				focusNode = focusNode.leftChild;		// 왼쯕으로
			} else {						// 크면
				focusNode = focusNode.rightChild;		// 오른쪽으로
			}

			if (focusNode == null)		// 찾으려는 노드가 없을 때
				return null;

		}
		return focusNode;
	}

	public void BST() {
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			Node n = q.poll();
			System.out.println(n.key + " ");
			if (n.leftChild != null)
				q.offer(n.leftChild);
			if (n.rightChild != null)
				q.offer(n.rightChild);
		}
	}
}
