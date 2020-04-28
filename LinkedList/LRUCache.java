package LinkedList;

import java.util.HashMap;

public class LRUCache {

    /*
    Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

    get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
     it should invalidate the least recently used item before inserting a new item.

    The cache is initialized with a positive capacity.

    Follow up:
    Could you do both operations in O(1) time complexity?
     */
    int capacity, currentSize;
    HashMap<Integer, DoubleLinkedListNode> valueToNodeMap = new HashMap<>();
    DoubleLinkedListNode head, tail;


    public LRUCache(int capacity) {

        this.capacity = capacity;
        currentSize = 0;
        head = new DoubleLinkedListNode();
        tail = new DoubleLinkedListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleLinkedListNode node = valueToNodeMap.get(key);

        // as soon as a node is accessed, move it to front.
        moveNodeToHead(node);
        return node.value;
    }

    public void put(int key, int value) {

        // get node withe the vale:
        DoubleLinkedListNode node = valueToNodeMap.get(key);
        // if node is null, add it
        if( node == null){
            DoubleLinkedListNode newNode = new DoubleLinkedListNode();
            newNode.key = key;
            newNode.value = value;
            valueToNodeMap.put(key,newNode);
            addNode(newNode);
            currentSize++;

            if(currentSize > capacity) {
                //remove least accessed node, which is in tail
                DoubleLinkedListNode LeastAccessedNode = popTail();
                //remove from map
                valueToNodeMap.remove(key);
            }
        }else {
            // if not null
            // update value
            node.value = value;
            // since it was recently accessed, move to head
            moveNodeToHead(node);

        }

    }
     private class DoubleLinkedListNode {

         int key;
         int value;
         DoubleLinkedListNode prev, next;
     }


        private void addNode(DoubleLinkedListNode node){
            /*
             * Always add the new node right after head.
             */
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }
        private void deleteNode(DoubleLinkedListNode node){
            /**
             * Remove an existing node from the linked list.
             */

            DoubleLinkedListNode prevNode = node.prev;
            DoubleLinkedListNode nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;

        }
        private void moveNodeToHead( DoubleLinkedListNode node){
            /**
             * Move certain node in between to the head.
             */
            deleteNode(node);
            addNode(node);
        }

        private DoubleLinkedListNode popTail(){

        DoubleLinkedListNode NodeToRemove = tail.prev;
        deleteNode(NodeToRemove);
        return NodeToRemove;
    }
}
