package SegmentTree;

public class SegmentTreeNode {

    /*
    Creating a Node class for the tree
     */
    static class Node {
        int value;
        Node right;
        Node left;
        int startInterval;
        int endInterval;

        public Node (int value) {
            this.value = value;
        }

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    private Node root;

    public void build(int[] arr) {
        root = buildIt(arr , 0, arr.length -1);
    }

    public Node buildIt(int[] arr, int start, int end) {
        if(start == end) {
            Node node = new Node(start, end);
            node.value = arr[start];
            return node;
        }

        Node curr = new Node(start, end);
        int mid = (start + end) / 2;
        curr.left = this.buildIt(arr, start, mid);
        curr.right = this.buildIt(arr, mid + 1, end);

        curr.value = curr.left.value + curr.right.value;
        return curr;
    }

    public void displayPretty() {
        displayPretty(root, 0);
    }

    public void displayPretty(Node node, int inden) {
        if(node == null) {
            return;
        }

        displayPretty(node.right, inden + 1);

        if (inden != 0) {
            for(int i = 0; i < inden; i++) {
                System.out.print("\t\t");
            }
            System.out.print(node.value + "[ " + node.startInterval + ", " + node.endInterval + " ]");
        } else {
            System.out.print(node.value + "[ " + node.startInterval + ", " + node.endInterval + " ]");
        }

        System.out.println();
        displayPretty(node.left, inden + 1);
    }

    public int findSumBetweenRange(int start, int end) {
        return findSumBetweenRange(root, start, end);
    }

    public int findSumBetweenRange(Node node, int start, int end) {
        if (node.startInterval >= start && node.endInterval <= end) {
            return node.value;
        } else if (start > node.endInterval || end < node.startInterval) {
            return 0;
        } else {
            return this.findSumBetweenRange(node.left, start, end) + this.findSumBetweenRange(node.right, start, end);
        }
    }

    public void updateIndexValue(int index, int value) {
        int total = updateIndexValue(root, index, value);
        System.out.println("Sum of the modified arr is "+ total);
    }

    public int updateIndexValue(Node node, int index, int value) {
        // condition to check if the index value is in-between start and end
        if (node.startInterval <= index && node.endInterval >= index) {
            if(node.startInterval == index && node.endInterval == index) {
                node.value = value;
                return node.value;
            } else {
                int left = updateIndexValue(node.left, index, value);
                int right = updateIndexValue(node.right, index, value);
                node.value = left + right;
                return node.value;
            }
        }
        return node.value;
    }
}
