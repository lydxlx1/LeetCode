/**
 * LeetCode 331 - Verify Preorder Serialization of a Binary Tree
 *
 * Using the Property of a Full Binary Tree
 *
 * If we treat null's as leaves, then the binary will always be full.
 * A full binary tree has a good property that # of leaves = # of nonleaves + 1.
 * Since we are given a pre-order serialization, we just need to find the shortest prefix
 * of the serialization sequence satisfying the property above.
 * If such prefix does not exist, then the serialization is definitely invalid;
 * otherwise, the serialization is valid if and only if the prefix is the entire sequence.
 *
 */
public class _331_1 {
    public boolean isValidSerialization(String preorder) {
        int nonleaves = 0, leaves = 0, i = 0;
        String[] nodes = preorder.split(",");
        for (i = 0; i < nodes.length && nonleaves + 1 != leaves; i++)
            if (nodes[i].equals("#")) leaves++;
            else nonleaves++;
        return nonleaves + 1 == leaves && i == nodes.length;
    }
}