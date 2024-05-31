package dev.alexandrevieira.advanced.c11_visitor_pattern;

import java.util.*;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int result = 0;

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {

    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private static final int MODULO = 1000000007;

    long result = 1L;

    public int getResult() {
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        multiplyIfRed(node);
    }

    public void visitLeaf(TreeLeaf leaf) {
        multiplyIfRed(leaf);
    }

    private void multiplyIfRed(Tree nodeOrLeaf) {
        if (nodeOrLeaf.getColor() == Color.RED) {
            result = (result * nodeOrLeaf.getValue()) % MODULO;
        }
    }
}

class FancyVisitor extends TreeVis {
    int sumOfNonLeafAtEvenDepth = 0;
    int sumOfGreenLeaf = 0;

    public int getResult() {
        return Math.abs(sumOfNonLeafAtEvenDepth - sumOfGreenLeaf);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) sumOfNonLeafAtEvenDepth += node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) sumOfGreenLeaf += leaf.getValue();
    }
}

class Solution {

    private static final List<Integer> values = new ArrayList<>();
    private static final List<Color> colors = new ArrayList<>();
    private static final Map<Integer, Set<Integer>> nodeEdges = new HashMap<>();

    public static List<String> nextLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static Tree solve() {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (String value : nextLine(sc)) {
            values.add(Integer.parseInt(value));
        }

        for (String color : nextLine(sc)) {
            colors.add(color.equals("0") ? Color.RED : Color.GREEN);
        }

        Tree rootNode;

        if (n == 1) {
            rootNode = new TreeLeaf(values.get(0), colors.get(0), 0);
        } else {
            rootNode = new TreeNode(values.get(0), colors.get(0), 0);

            for (int i = 0; i < (n - 1); i++) {

                int u = sc.nextInt();

                int v = sc.nextInt();

                Set<Integer> uEdges = nodeEdges.get(u);

                if (uEdges == null)
                    uEdges = new HashSet<>();

                uEdges.add(v);

                nodeEdges.put(u, uEdges);

                Set<Integer> vEdges = nodeEdges.get(v);

                if (vEdges == null)
                    vEdges = new HashSet<>();

                vEdges.add(u);

                nodeEdges.put(v, vEdges);
            }
            for (int nodeId : nodeEdges.get(1)) {
                nodeEdges.get(nodeId).remove(1);
                createEdge(rootNode, nodeId);
            }
        }
        return rootNode;
    }

    private static void createEdge(Tree parent, int nodeId) {

        Set<Integer> nodeEdges = Solution.nodeEdges.get(nodeId);

        boolean hasChild = nodeEdges != null && !nodeEdges.isEmpty();

        if (hasChild) {
            TreeNode node = new TreeNode(values.get(nodeId - 1), colors.get(nodeId - 1), parent.getDepth() + 1);
            ((TreeNode) parent).addChild(node);

            for (int neighborId : nodeEdges) {
                Solution.nodeEdges.get(neighborId).remove(nodeId);
                createEdge(node, neighborId);
            }
        } else {
            TreeLeaf leaf = new TreeLeaf(values.get(nodeId - 1), colors.get(nodeId - 1), parent.getDepth() + 1);
            ((TreeNode) parent).addChild(leaf);
        }
    }


    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}