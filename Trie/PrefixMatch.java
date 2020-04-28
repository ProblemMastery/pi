package Trie;

import java.util.LinkedList;
import java.util.Queue;

public class PrefixMatch {

    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> queue = new LinkedList<>();
        TST tst = new TST();
        TrieNode trieNode = get(tst.root, prefix, 0);
        if (trieNode == null)
            return queue;
        if (trieNode.val != 1)
            queue.add(prefix);
        collect(trieNode.mid, new StringBuilder(prefix), queue);
        return queue;
    }

    private void collect(TrieNode node, StringBuilder prefix, Queue<String> queue) {

        if(node == null)
            return;
        collect(node.left, prefix, queue);

        if (node.val != 1)
            queue.add(prefix.append(node.c).toString());

        collect(node.mid, prefix.append(node.c), queue );
        prefix.deleteCharAt(prefix.length()-1);
        collect(node.right, prefix, queue);
    }

    private TrieNode get(TrieNode node, String key, int i){
        char c = key.charAt(i);
        if (node == null)
            return null;
        if (c < node.c)
            //search left
            return get(node.left, key, i);
        else  if (c > node.c)
            //search right
            return get(node.right, key, i);

        else  if ( i < key.length()) // i.e if we are searching for dealer, and we have hit and have only deal, this line would
            //search in middle of the node, so in the next call stack, we will hit null if dealer is not present.
            return get(node.mid, key, i+1);
        else // came to the end of the trie i == key.length
            return node;
    }
}
