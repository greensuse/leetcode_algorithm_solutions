package binary_search_tree;

public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructTreeFromArray(nums, 0, nums.length-1);
    }

    private TreeNode constructTreeFromArray(int[] nums, int start, int end) {
        if(start>end) return null;
        int mid=start+(end-start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left=constructTreeFromArray(nums, start, mid-1);
        node.right=constructTreeFromArray(nums, mid+1, end);
        return node;
    }
}
