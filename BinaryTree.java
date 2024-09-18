import java.util.*;
import java.util.LinkedList;

public class binaryTree {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }
    //  root left right
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //  left root right
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    // left right root
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    //  acc to levels
    public static void levelOrder(Node root) {
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else {
                System.out.print(currNode.data+" ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }
    //  Number of nodes
    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        return leftNodes + rightNodes + 1;
    }
    //   Sum of nodes
    public static int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.data;
    }
    //  height of nodes
    public static int heightOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = heightOfNodes(root.left);
        int rightHeight = heightOfNodes(root.right);
        int Height = Math.max(leftHeight,rightHeight) + 1;
        return Height;
    }
    //   Diameter of Nodes
    public static int diaOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftDia = diaOfNodes(root.left);
        int rightDia = diaOfNodes(root.right);
        int Diameter = heightOfNodes(root.left) + heightOfNodes(root.right) + 1;

        return Math.max(Diameter,Math.max(leftDia,rightDia));
    }
    //  diameter and height of nodes
    static class TreeInfo {
        int height;
        int diameter;
        TreeInfo(int height, int diameter) {
            this.diameter = diameter;
            this.height = height;
        }
    }
    public static TreeInfo diaAndHeight(Node root) {
        if (root == null) {
            return new TreeInfo(0,0);
        }
        TreeInfo left = diaAndHeight(root.left);
        TreeInfo right = diaAndHeight(root.right);
        int myHeight = Math.max(left.height,right.height) + 1;

        int dia = left.height + right.height + 1;
        int myDiameter = Math.max(dia,Math.max(left.diameter, right.diameter));
        return new TreeInfo(myHeight,myDiameter);
    }
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder(root);
        System.out.println(countNodes(root));
        System.out.println(sumOfNodes(root));
        System.out.println(heightOfNodes(root));
        System.out.println(diaOfNodes(root));
        System.out.println(diaAndHeight(root).diameter);
    }
}