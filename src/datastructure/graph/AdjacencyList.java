package datastructure.graph;

import java.util.ArrayList;

/**
 *
 * @author rajmani
 */
public class AdjacencyList {
    final int V;
    final ArrayList [] adj;

    public AdjacencyList(int V) {
        this.V = V;
        adj = new ArrayList [V];
        for (int i=0; i<V; i++) {
            adj[i] = new ArrayList<>();
        }
    }
    public void addEdge(int src, int dest) {
        adj[src].add(dest);
        //adj[dest].add(src);
    }
    public void print () {
        System.out.println("Adjacency List Representation : \n");
        for(int i=0; i<adj.length; i++){
            System.out.print("["+i+"] -> ");
            for (int j = 0; j < adj[i].size(); j++) {
                System.out.print(" "+adj[i].get(j));
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        int V=5;
        AdjacencyList graph = new AdjacencyList(V);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 4);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.print();
    }
    public int getVertex(){
        return V;
    }
    public ArrayList[] getList() {
        return adj;
    }
}
