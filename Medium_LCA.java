// Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

import java.util.*;

// class to describe a node in a BST
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Medium_LCA {
    public static void main(String[] args) {
        List<String> treeList = new ArrayList<String>();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the elements of the tree [Enter null for non-existing nodes and -999 if all the nodes have been entered]: ");
        String nodeElement = in.next();

        while (!nodeElement.equals("-999")) { // termination condition
            treeList.add(nodeElement);
            nodeElement = in.next();
        }

        System.out.println("\nEnter the node values whose LCA has to be found: ");
        Node p = new Node(in.nextInt());
        Node q = new Node(in.nextInt());

        Node root = buildTree(treeList);
        Node lca = LowestCommonAncestor(root, p, q);

        if (lca != null) {
            System.out.println("\nThe Lowest Common Ancestor of nodes " + p.data + " and " + q.data + " is : " + lca.data);
        } 
        else {
            System.out.println("\nThe Lowest Common Ancestor of nodes " + p.data + " and " + q.data + " does not exist");
        }

        in.close();
    }

    public static Node buildTree(List<String> treeList) {

    if (treeList.size() == 0 || treeList.get(0) == null) {
        return null;
    }

    Node root = new Node(Integer.parseInt(treeList.get(0)));

    Queue<Node> nodeQueue = new LinkedList<>(); // queue to store tree nodes
    nodeQueue.add(root);

    int nodeNumber = 1; // root already stored in the queue hence we start with nodeNumber = 1
    while (nodeQueue.size() > 0 && nodeNumber < treeList.size()) {

        Node curNode = nodeQueue.remove();
        String nodeVal = treeList.get(nodeNumber);

        // creating left child
        if (!nodeVal.equals("null")) {
            curNode.left = new Node(Integer.parseInt(nodeVal));
            nodeQueue.add(curNode.left);
        }

        nodeNumber++;

        if (nodeNumber >= treeList.size()) {
            break;
        }

        nodeVal = treeList.get(nodeNumber);

        // creating right child
        if (!nodeVal.equals("null")) {
            curNode.right = new Node(Integer.parseInt(nodeVal));
            nodeQueue.add(curNode.right);
        }

        nodeNumber++;
    }

    return root;
    }

    public static Node LowestCommonAncestor(Node root, Node p, Node q) { // function to find LCA of 2 nodes in a BST
    if (root == null)
        return root;

    int curNode = root.data;
    if (p.data < curNode && q.data < curNode) { // the two nodes p and q found on the left of the root
        return LowestCommonAncestor(root.left, p, q);
    }

    if (p.data > curNode && q.data > curNode) { // the two nodes p and q found on the right of the root
        return LowestCommonAncestor(root.right, p, q);
    }

    return root;
    }
}

/*
* 
* Complexity of the code written:
* 
* Time complexity - O(N)
* Space complexity - O(N)
* 
*/