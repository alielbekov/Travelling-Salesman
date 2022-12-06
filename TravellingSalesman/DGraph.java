import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DGraph {
	
	private ArrayList<LinkedList<Edge>> adjList = new ArrayList<>(); 
	private int numVertices;
	
	
	
	DGraph(int numVertices){
		
//		A weighted directed graph is needed to represent the ‘cities’ and their distances. The graph
//		should support operations that will be needed by the algorithms, mainly a method to find all
//		vertices that are adjacent to a given vertex. The graph class should be in DGraph.java.
		
		this.numVertices = numVertices;
		for(int i=0; i<numVertices; i++) {
			adjList.add(new LinkedList<Edge>());
		}
		
	}
	
	private class Edge{
		int label;
		double weight;
		Edge(int v, double w){
			this.label = v;
			this.weight = w;
		}
	}
	
	
	void addEdge(int u, int v, double w) {
		adjList.get(u-1).add(new Edge(v,w));
	}
	
	public String toString() {
		String ret = "";
		for(LinkedList<Edge> each : adjList) {
			ret += "[";
			for (Edge eachEdge : each) {
				ret +=  "to" + eachEdge.label + " with " + eachEdge.weight + ", ";
				
			}
			ret += "]";
			
		}
		
		return ret;
		
	}
	
	
	
	public double Heruistic() {
		
		List<Integer> visited = new ArrayList<>();
		int curPosition =  1;
		visited.add(curPosition);
		
		double pathCost = 0.0;
		int bestCityToGo = 0;
		double lastCitytoFirst = 0.0;
		
		
		
		while(visited.size() < numVertices) {
				double curLength = Double.MAX_VALUE;
				
				
				for(Edge eachEdge : adjList.get(curPosition-1)) {
					if(eachEdge.weight<curLength && !visited.contains(eachEdge.label)) {
						curLength  = eachEdge.weight;
						bestCityToGo = eachEdge.label;				
					}
					if (eachEdge.label == 1) {
						lastCitytoFirst = eachEdge.weight;
						
					}
				}
				
				
				visited.add(bestCityToGo);
				pathCost += curLength;
				curPosition = bestCityToGo;
	
		
		}
		
		for(Edge eachEdge : adjList.get(bestCityToGo-1)) {
			if(eachEdge.label==1) {
				pathCost += eachEdge.weight;
			}
		}

		
		for(int each :visited) {
			System.out.println(each);
		}
		System.out.println(pathCost);
	
		return 2.1;

		
	}
	
	
	
	
	
	public void myOwn() {
		
		
		
		
	}
	
	
	
	public void BackTracking() {
		int cityNumber = numVertices;
		boolean[] visited = new boolean[cityNumber];
		
		visited[0] = true;
		double retVal = Double.MAX_VALUE;
		
				
		
	}
	
	private void recBacktrack(boolean[] visited, int curPos, double curCost)
	
	{
			
	}
	
	

	
	
	
	
	
	

}
