package datastructure.graph;

/**
 * @see www.rajmani1995.blogspot.com 
 * @author rajmani arya
 */
public class AdjacencyMatrix {
    
    private int[][] Adj;
    private int V;

    public AdjacencyMatrix(int V) {
        this.V = V;
        Adj = new int[V][V];
    }
    
    public void addEdge(int src , int dest){
        this.Adj[src][dest] = 1;
        this.Adj[dest][src] = 1;
    }
    
    public void print(){
        System.out.println("\n Adjacency Matrix ");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.printf(" %d " , Adj[i][j]);
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        int V=5;
        AdjacencyMatrix graph = new AdjacencyMatrix(V);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 4);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.print();
    }
}
