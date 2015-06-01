package datastructure.graph;

import java.util.Stack;

/**
 * date: 25-04-2015
 * @author Rajmani Arya
 */
public class TopologicalSort extends AdjacencyList {
    public TopologicalSort(int V) {
        super(V);
    }
    void TopologicalUtil(int i, boolean [] visited, Stack<Integer> stack){
        if (visited[i])
            return;
        visited[i] = true;
        for (int j = 0; j < adj[i].size(); j++) {
            if(!visited[j])
                TopologicalUtil(j, visited, stack);
        }
        stack.push(i);
    }
    void Topological(int start){
        boolean [] visited=new boolean[V];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = start; i >=0 ; i--) {
            TopologicalUtil(i, visited, stack);
        }
        while (stack.empty() == false) {            
            System.out.print(stack.pop());
        }
    }
    public static void main(String[] args) {
        TopologicalSort graph = new TopologicalSort(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.Topological(4);
    }
}
