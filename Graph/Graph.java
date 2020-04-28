package Graph;


import java.util.ArrayList;

public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");


    private int Vertices;
    private int Edges;
    //array of arraylist. the index denotes the id of vertex
    private ArrayList<Integer>[] adj;

    public Graph(int v ){
        this.Vertices = v;
        this.Edges = 0;
        // array of arraylist. the array is of size V.
        adj = new ArrayList[v];
        for(int i = 0 ; i < v; i++){
            adj[i] = new ArrayList<>();
        }
    }

    //method to add an edge between vertex v and vertex w;
    public void addEdge(int v, int w){
        //since the index denotes the id of vertex
        adj[v].add(w);
        adj[w].add(v);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(Vertices + " vertices, " + Edges + " edges " + NEWLINE);
        for (int i = 0; i < Vertices; i++) {
            s.append(i + ": ");
            for (int w : adj[i]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    //given a vertex v, return all its edges
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int V() {
        return Vertices;
    }

    public int E() {
        return Edges;
    }



}
