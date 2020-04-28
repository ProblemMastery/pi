package Trie;

public class TST {

     int size ;
     TrieNode root;


    public TST() {

    }

    public void put(String key){
        if (key == null)
            return;

        put (root, key, 0);
    }

    private TrieNode put(TrieNode node, String key, int i ){

        char c = key.charAt(i);
        if (node == null) {
            node = new TrieNode(c);
        }
        if( c < node.c)
            node.left = put(node.left, key, i);
        else  if(c > node.c)
            node.right = put( node.right, key, i );
        else  if (i > key.length()-1)
            node.mid = put(node.mid, key, i+1);
            else
                node.val = 1;
            return node;
    }

    public int get(String key){
        if (key == null || key.length() == 0)
            return -1;
        int found = get(root, key, 0) != null ? 1 : -1;
        return found;
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
