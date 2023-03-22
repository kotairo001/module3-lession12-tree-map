public class Main {
    public static void main(String[] args) {
        BST<Integer> BST = new BST<>();
        BST.insert(27);
        BST.insert(14);
        BST.insert(10);
        BST.insert(19);
        BST.insert(35);
        BST.insert(31);
        BST.insert(42);
//        BST.insert(59);
//        BST.insert(101);
//        System.out.println("Post Order");
//        BST.postOrder();
//        System.out.println("\n" + "Pre-Order");
//        BST.preOrder();
//        System.out.println("\n" + "In-Order" );
//        BST.inOrder();
//        System.out.println("\n" + "Breadth-First" );
        BST.deleteKey(35);
        BST.inOrder();
        System.out.println(BST.search(10)?"Exit":"Not exit");
    }
}
