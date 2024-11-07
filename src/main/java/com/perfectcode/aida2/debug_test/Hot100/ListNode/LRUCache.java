package com.perfectcode.aida2.debug_test.Hot100.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lzj
 * @Date: 2024/10/19 15:56
 */

/**
 * 146. LRU 缓存
 * 使用了 HashMap keyToNode 来实现 O(1) 的快速查
 *
 */
public class LRUCache {
    private static class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    private final int capacity;
    private final Node dummyHead = new Node(-1,-1);

    private final Map<Integer,Node> keyToNode = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyHead.next = dummyHead;
        dummyHead.prev = dummyHead;
    }
    public int get(int key){
        Node node = getNode(key);
        return node !=null ? node.value :-1;
    }
    public void put(int key,int value){
        Node node = getNode(key);
        if(node!=null){
            node.value = value;
            return;
        }
        node = new Node(key,value);
        keyToNode.put(key,node);
        pushFront(node);
        if (keyToNode.size()>capacity){
            Node backNode = dummyHead.prev;
            keyToNode.remove(backNode.key);
            remove(backNode);
        }
    }

    private Node getNode(int key) {
        if (!keyToNode.containsKey(key)) { // 没有这本书
            return null;
        }
        Node node = keyToNode.get(key); // 有这本书
        remove(node); // 把这本书抽出来
        pushFront(node); // 放在最上面
        return node;
    }

    private void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }
    private void pushFront(Node x) {
        x.prev = dummyHead;
        x.next = dummyHead.next;
        x.prev.next = x;
        x.next.prev = x;
    }




    
}
