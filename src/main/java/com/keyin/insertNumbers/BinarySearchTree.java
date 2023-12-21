package com.keyin.insertNumbers;

import jakarta.persistence.*;

@Entity
public class BinarySearchTree {

    @Id
    @SequenceGenerator(name = "tree_sequence", sequenceName = "tree_sequence",allocationSize = 1,initialValue = 1)
    @GeneratedValue(generator = "tree_sequence")
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Node root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }

    public String toJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        toJsonRecursive(root, sb);
        sb.append("}");
        return sb.toString();
    }

    private void toJsonRecursive(Node current, StringBuilder sb) {
        if (current != null) {
            sb.append("\"").append(current.value).append("\": {");
            if (current.left != null) {
                toJsonRecursive(current.left, sb);
                sb.append(",");
            }
            if (current.right != null) {
                toJsonRecursive(current.right, sb);
            }
            sb.append("}");
        }
    }

    public void setInputNumbers(String numbers) {
    }

    public void setTreeStructure(String jsonRepresentationOfTheTree) {
    }
}

