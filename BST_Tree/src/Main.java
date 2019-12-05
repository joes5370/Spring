public class Main {
	public static void main(String[] args) {
//		Bst bTree = new Bst();
//
//		bTree.addNode(50);
//		bTree.addNode(25);
//		bTree.addNode(75);
//		bTree.addNode(15);
//		bTree.addNode(30);
//		bTree.addNode(70);
//		bTree.addNode(85);
//		bTree.addNode(2);
//		bTree.addNode(18);
//		bTree.addNode(26);
//		bTree.addNode(32);
//		bTree.addNode(32);
//		bTree.addNode(32);
//		bTree.addNode(32);
//
//		bTree.BST();
//
//		System.out.println("\n---------- In Order Traversal ----------");
//		bTree.inOrderTraverse(bTree.getRoot());
//		System.out.println("\n");
//
//		System.out.println("---------- Pre Order Traversal ----------");
//		bTree.preOrderTraverse(bTree.getRoot());
//		System.out.println("\n");
//
//		System.out.println("---------- Post Order Traversal ----------");
//		bTree.postOrderTraverse(bTree.getRoot());
//		System.out.println("\n");
//
//		System.out.println("---------- Find Node ----------");
//		Bst.Node found = bTree.findNode(25);
//		System.out.println(found == null ? "not exists" : found);
//		System.out.println("\n");
//
//		// Deleting node
//		System.out.println("---------- Delete Node Test ----------");
//		bTree.deleteNode(15);
//		bTree.BST();
//
//		System.out.print("\n");


//		Node nA = new Node('A');
//		Node nB = new Node('B');
//		Node nC = new Node('C');
//		Node nD = new Node('D');
//		Node nE = new Node('E');
//		Node nF = new Node('F');

		// Create the graph, add nodes, create edges between nodes

		Dfs dTree = new Dfs();
		
		dTree.addNode(50);
		dTree.addNode(25);
		dTree.addNode(75);
		dTree.addNode(15);
		dTree.addNode(30);
		dTree.addNode(70);
		dTree.addNode(85);
		dTree.addNode(2);
		dTree.addNode(18);
		dTree.addNode(26);
		dTree.addNode(32);
		dTree.addNode(32);
		dTree.addNode(32);
		dTree.addNode(32);
		
		dTree.dfs();

		System.out.println("\n---------- In Order Traversal ----------");
		dTree.inOrderTraverse(dTree.getRootNode());
		System.out.println("\n");

		System.out.println("---------- Pre Order Traversal ----------");
		dTree.preOrderTraverse(dTree.getRootNode());
		System.out.println("\n");

		System.out.println("---------- Post Order Traversal ----------");
		dTree.postOrderTraverse(dTree.getRootNode());
		System.out.println("\n");

		System.out.println("---------- Find Node ----------");
		Dfs.Node found = dTree.findNode(25);
		System.out.println(found == null ? "not exists" : found);
		System.out.println("\n");

		// Deleting node
		System.out.println("---------- Delete Node Test ----------");
		dTree.deleteNode(15);
		dTree.dfs();
		System.out.println();
	}
}
