package Trie;

import java.util.ArrayList;
import java.util.List;

public class LongestPrefix {


    /*
    Returns the string in the symbol table that is the longest prefix of query
    eg : given a list [ she, shell, shells, shelter] query = shellsort, should return shells.
     */

    public List<String> getLongestPrefixStrings(String query){

        List<String> result = new ArrayList<>();

        TST trie = new TST();
        int length = 0 ;
        TrieNode node = trie.root;
        int i = 0 ;
        //iterate until index is greater than query length
        while (node != null && i < query.length()){

            char c = query.charAt(i);

            if (c < node.c)
                node = node.left;
            else if (c > node.c)
                node = node.right;
            else {
                //match
                i++;
                //check if the current node has a value, i.e its a valid key
                //current implementation has value 1 for every key
                if (node.val != 1)
                    // this is required in retrieving the substring that matched in the query
                    length = i;
                result.add(query.substring(0, length));
                node = node.mid;
            }

        }
        return result;
    }
}
