package AInterview;

import java.util.HashMap;
import java.util.Map;

public class Coinbase {

    private static class DirctoryNode {
        String name;
        Map<String, DirctoryNode> sub;

        DirctoryNode(String name) {
            this.name = name;
            this.sub = new HashMap<>();
        }
    }
    DirctoryNode root;
    Map<String, DirctoryNode> topLevelDir;

    Coinbase (DirctoryNode root){
        this.root = new DirctoryNode("/");
        topLevelDir = new HashMap<>();
    }

    public void mkdir(String path){


    }


}
