package bst.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Frankenstein code to print binary search trees.
 *
 * @author michel.mercera & the www
 */
public class BSTPrinter<E extends Comparable<E>> {

    public void printNode(Node<E> root) {
        int maxLevel = maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private void printNodeInternal(List<Node<E>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) {
            return;//yuk
        }

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<Node<E>> newNodes = new ArrayList<Node<E>>();
        for (Node<E> node : nodes) {
            if (node != null) {
                System.out.print(node.getElement());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getLeft() != null) {
                    System.out.print("/");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(i + i - 1);

                if (nodes.get(j).getRight() != null) {
                    System.out.print("\\");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(edgeLines + edgeLines - i);
            }

            System.out.println();
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private int maxLevel(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxLevel(node.getLeft()), maxLevel(node.getRight())) + 1;
    }

    private boolean isAllElementsNull(List<Node<E>> list) {
        for (Object object : list) {
            if (object != null) {
                return false;
            }
        }
        return true;
    }

}
