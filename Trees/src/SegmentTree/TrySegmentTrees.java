package SegmentTree;

public class TrySegmentTrees {

    public static void main(String[] args) {
        SegmentTreeNode segmentTreeNode = new SegmentTreeNode();
        int[] arr = new int[]{1, 2, 3, -1, 5, 6};
        segmentTreeNode.build(arr);
        segmentTreeNode.displayPretty();
        System.out.println(segmentTreeNode.findSumBetweenRange(2,4));
        segmentTreeNode.updateIndexValue(3, 2);
    }
}
