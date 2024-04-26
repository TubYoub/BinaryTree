package de.tubyoub.morsecode;

import de.tubyoub.lib.BinaryTree;

public class Analyzer {
    public Analyzer(){

    }
    public <ContentType> int getDepth(BinaryTree<ContentType> binaryTree){
        if(binaryTree == null || binaryTree.isEmpty()) {
            return -1;
        }
        int leftDepth = getDepth(binaryTree.getLeftTree());
        int rightDepth = getDepth(binaryTree.getRightTree());
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public <ContentType> int getNodeCount(BinaryTree<ContentType> binaryTree){
        if(binaryTree == null || binaryTree.isEmpty()) {
            return 0;
        }
        return 1 + getNodeCount(binaryTree.getLeftTree()) + getNodeCount(binaryTree.getRightTree());
    }

    public <ContentType> int getLeaveCount(BinaryTree<ContentType> binaryTree){
        if((binaryTree.getLeftTree() == null &&  binaryTree.getRightTree() == null) || (binaryTree.getLeftTree().isEmpty() && binaryTree.getRightTree().isEmpty())) {
            return 1;
        }
        return getLeaveCount(binaryTree.getLeftTree()) + getLeaveCount(binaryTree.getRightTree());
    }

    public int getHighestNumber(BinaryTree<Integer> binaryTree){
        if(binaryTree == null || binaryTree.isEmpty()) {
            return 0;
        }
        int maxLeft = getHighestNumber(binaryTree.getLeftTree());
        int maxRight = getHighestNumber(binaryTree.getRightTree());
        return Math.max(binaryTree.getContent(), Math.max(maxLeft, maxRight));
    }

    public int getSumOfNodes(BinaryTree<Integer> binaryTree){
        if(binaryTree == null || binaryTree.isEmpty()) {
            return 0;
        }
        return binaryTree.getContent() + getSumOfNodes(binaryTree.getLeftTree()) + getSumOfNodes(binaryTree.getRightTree());
    }

    public static void main(String[] args) {
        Analyzer analyzer = new Analyzer();
        BinaryTree <Integer> binaryTree = new BinaryTree<Integer>(0, new BinaryTree<Integer>(1, new BinaryTree<Integer>(3), new BinaryTree<Integer>(5)), new BinaryTree<Integer>(2, new BinaryTree<Integer>(4), new BinaryTree<Integer>(6)));
        System.out.println("Tiefe: " + analyzer.getDepth(binaryTree));
        System.out.println("Knoten Anzahl: " + analyzer.getNodeCount(binaryTree));
        System.out.println("Blätter Anzahl: " + analyzer.getLeaveCount(binaryTree));
        System.out.println("Größte Nummer: " + analyzer.getHighestNumber(binaryTree));
        System.out.println("Sume: " + analyzer.getSumOfNodes(binaryTree));

    }
}