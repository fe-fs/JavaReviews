
/*what is an Unbalanced tree?
    > Random data normally isn't unbalanced
    >Ordered data tends to create unbalanced trees >> most of the nodes are in just one side of the tree

 Why use trees?
 >You can search, and insert/ delete items quickly in a tree
 >Ordered Arrays (also known as sorted arrays) are bad at Insertions/ Deletions -> Because to maintain the order organized is time consuming.
>Finding items in a Linked List is slow -> because it is like a chain that you have to follow till find what you are looking for
>Time needed to perform an operation on a tree is O(log N)
>On average a tree is more efficient if you need to perform many different types of operations -> because let you use
    divide and conquer going greater of less than the value of the root



    */


public class JavaTreesReview {

    Node root;

    //binary tree class
    //every single tree no matter what root is, is going to have a root value
    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);

        //checks if this is for sure the root element for the tree
        if (root == null) {
            root = newNode; //yes create a node here

        } else {
            Node focusNode = root; //that will be the node we will be focusing on, so it will have to be the root for the tree
            Node parent;


            while (true) {
                parent = focusNode; //set the parent as the focus node, the root
                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild; //so send data to the left if the value is less than the root

                    //if the parent has no children, go to top again to maybe create a new parent
                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else { //else there is greater values than the root, create parent nodes to the right side
                    focusNode = focusNode.rightChild;
                    //if the parent has no children, go to top again to maybe create a new parent
                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    //WAYS to TRAVERSE WITH THE TREE
    /*In Order Traversal
     * > Aim for the smallest value first
     * > Start at 1st Left Child
     * > When Null is reached then move up in value
     *
     * In an in-order traversal, the left subtree is visited first, then the current node,
     * and finally, the right subtree. If this method is called with the root node of a
     * binary search tree, it will print out the nodes in ascending order.
     * */
    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild); //recursive call - traverse the left node 1st
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild); //recursive call - traverse the right node 2nd
        }
    }

    /*Preoder Traversal
     *In a pre-order traversal, the current node is processed first (i.e., printed in this case),
     *  then the left subtree, and finally the right subtree. If this method is called with the
     *  root node of a binary tree, it will print out the nodes in pre-order sequence.
     * */

    public void preorderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode); //first get the focus node
            preorderTraverseTree(focusNode.leftChild); //recursive call - traverse the left node 1st
            preorderTraverseTree(focusNode.rightChild); //recursive call - traverse the right node 2nd
        }
    }

    /*Post Order Traversal
     *In a post-order traversal, the left subtree is visited first, then the right subtree,
     *  and finally the current node is processed (i.e., printed in this case).
     *  If this method is called with the root node of a binary tree, it will print out the nodes
     *  in post-order sequence.
     * */
    public void postorderTraverseTree(Node focusNode) {
        if (focusNode != null) {

            postorderTraverseTree(focusNode.leftChild); //recursive call - traverse the left node 1st
            postorderTraverseTree(focusNode.rightChild); //recursive call - traverse the right node 2nd
            System.out.println(focusNode); //Last get the focus node
        }

    }

    //HOW TO FIND NODES?
    /*This method leverages the property of binary search trees where for any given node,
     all nodes in its left subtree have keys less than the node’s key, and all nodes in
     its right subtree have keys greater than the node’s key. This allows the method to
     efficiently search the tree for a specific key.*/
    public Node findNode(int key) {
        Node focusNode = root;

        //This is the start of a loop that continues as long as the key of
        // the focusNode is not equal to the key we’re searching for.
        while (focusNode.key != key) {

            //using the divide and conquer here if focusNode is less go to the leftChield, if greater go to the right child
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            // If focusNode is null, it means we’ve reached a
            // leaf node and the key was not found in the tree, so the method returns null.
            if(focusNode == null)
                return null;
        }
        //If the loop exits, it means the key of the focusNode
        // is equal to the key we’re searching for, so the method returns the focusNode
        return focusNode;
    }

    //FOR LATER > REVIEW HOW TO DELETE NODES


    public static void main(String[] args) {
        //A binary tree is a type of tree data structure in which each node has at most two children,
        // referred to as the left child and the right child

        //create the tree
        JavaTreesReview theTree = new JavaTreesReview(); //this is a new BinaryTree object (has to be the name of the class)

        theTree.addNode(50, "Boss"); //1st added is the became root
        theTree.addNode(25, "Vice Pres");
        theTree.addNode(15, "Office Manager");
        theTree.addNode(30, "Secretary");
        theTree.addNode(75, "Sales Manager");
        theTree.addNode(85, "Salesmas 1");


        System.out.println("In Order Traverse Tree - Prints from the lesser value child in left\nand go till the greater in the right");
        theTree.inOrderTraverseTree(theTree.root);

        System.out.println("\n\nPre Order Traverse Tree: Prints from the root - parent - childs");
        theTree.preorderTraverseTree(theTree.root);

        System.out.println("\n\nPost Order Traverse Tree: Prints left subtree, then right subtree and current node");
        theTree.postorderTraverseTree(theTree.root);

        System.out.println("\n\nSearch for 30");
        System.out.println(theTree.findNode(30));

    }


    //class to create nodes for the tree
    class Node {
        int key;
        String name;


        //can have more than 1 left and one right child
        Node leftChild;
        Node rightChild;

        Node(int key, String name) {
            this.key = key;
            this.name = name;
        }

        //to be able to print the tree in the screen
        public String toString() {
            return name + " has a key " + key;
        }
    }
}