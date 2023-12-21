package com.keyin.insertNumbers;

import jakarta.persistence.*;

@Entity
public class Node {
    @Id
    @SequenceGenerator(name = "node_sequence", sequenceName = "node_sequence",allocationSize = 1,initialValue = 1)
    @GeneratedValue(generator = "node_sequence")
    private long id;
        int value;
        @OneToOne(cascade = CascadeType.ALL)
        Node left;
        @OneToOne(cascade = CascadeType.ALL)
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

    public Node() {

    }
}



