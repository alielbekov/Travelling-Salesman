import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DGraph {

    private ArrayList < LinkedList < Edge >> adjList = new ArrayList < > ();
    private int numVertices;
    private double lowestCost = Double.MAX_VALUE;
    private List < Integer > lowestPath = new ArrayList < > ();
    private boolean forTimeOnly = false;
    private double herusiticCost;
    private double mineCost;
    private double backtrackCost;




    /**
     * 
     * This method adds an edge to our list of edges.
     * 
     * */
    DGraph(int numVertices) {

        //		A weighted directed graph is needed to represent the ‘cities’ and their distances. The graph
        //		should support operations that will be needed by the algorithms, mainly a method to find all
        //		vertices that are adjacent to a given vertex. The graph class should be in DGraph.java.

        this.numVertices = numVertices;
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new LinkedList < Edge > ());
        }

    }
    
    /**
     * 
     * A class I used to save our matrix data for each path.
     * 
     * */

    private class Edge {
        int label;
        double weight;
        Edge(int v, double w) {
            this.label = v;
            this.weight = w;
        }
    }
    
    
    /**
     * 
     * This method adds an edge to our list of edges
     * 
     * */

    void addEdge(int u, int v, double w) {
        adjList.get(u - 1).add(new Edge(v, w));
    }

    
    
    /**
     * 
     * This was a random toString method I used to see if my dataset is being
     * created as expected.
     * */
    public String toString() {
        String ret = "";
        for (LinkedList < Edge > each: adjList) {
            ret += "[";
            for (Edge eachEdge: each) {
                ret += "to" + eachEdge.label + " with " + eachEdge.weight + ", ";

            }
            ret += "]";

        }

        return ret;

    }


    
    /**
     * 
     * This is the Herusitc function that gets the lowest weight neighboring-city
     * path and proceed to move into that city unless this city has already been visited.
     * 
     * */

    public void Heruistic() {

        List < Integer > visited = new ArrayList < > ();
        int curPosition = 1;
        visited.add(curPosition);

        double pathCost = 0.0;
        int bestCityToGo = 0;
        double lastCitytoFirst = 0.0;



        while (visited.size() < numVertices) {
            double curLength = Double.MAX_VALUE;


            for (Edge eachEdge: adjList.get(curPosition - 1)) {
                if (eachEdge.weight < curLength && !visited.contains(eachEdge.label)) {
                    curLength = eachEdge.weight;
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
        for (Edge eachEdge: adjList.get(bestCityToGo - 1)) {
            if (eachEdge.label == 1) {
                pathCost += eachEdge.weight;
            }
        }
        printPathInfo(visited, pathCost);
        herusiticCost = pathCost;


    }




    /**
     * 
     * Initially, I was thinking of creating my own algorithm to get the fastest
     * output, but it seems we just need to improve either of the two.
     * I improved Backtracking algorithm by avoiding unnecessary loops in it!
     * 
     * 
     * */

    public void myOwn() {

        boolean improved = true;
        BackTracking(improved);
        mineCost = backtrackCost;
    }


    /**
     * 
     * This is the Backtracking function that brute forces all the options and
     * returns the lowest-cost path of cycling. It uses a recursion to accomplish
     * this task
     * 
     * */
    public void BackTracking(boolean myImprovedVersion) {
        double curCost = 0;
        int cityNumber = numVertices;
        boolean[] visited = new boolean[cityNumber];
        visited[0] = true;
        List < Integer > curPath = new ArrayList < > ();
        curPath.add(1);
        int curPos = 1;
        recBacktrack(myImprovedVersion, curPath, curPos, curCost);
        printPathInfo(lowestPath, lowestCost);
        backtrackCost = lowestCost;



    }

    /**
     * 
     * This is a helper function to our backtracking algorithm. Basically, it does the
     * recursion part of the process.
     * 
     * */
    private void recBacktrack(
        boolean myImproved,
        List < Integer > curPath,
        int curPos,
        double curCost
    ) {
    	
    	// Base case
        if (curPath.size() == numVertices) {
        	
        	

            for (Edge eachEdge: adjList.get(curPos - 1)) {
                if (eachEdge.label == 1) {
                    curCost += eachEdge.weight;
                    if (curCost < lowestCost) {
                        lowestCost = curCost;
                        lowestPath = new ArrayList < > (curPath);
                    }

                }
            }
        } 
        // Recursive case
        else {
            for (Edge eachEdge: adjList.get(curPos - 1)) {
                if (!curPath.contains(eachEdge.label)) {
                    curPath.add(eachEdge.label);
                    curCost += eachEdge.weight;
                    if (myImproved && !(curCost < lowestCost)) {
                        // this condition improves our program by avoiding 
                        // unnecessary loops!

                        curPath.remove(curPath.size() - 1);
                        curCost -= eachEdge.weight;
                        break;

                    }
                    curPos = eachEdge.label;
                    recBacktrack(myImproved, curPath, curPos, curCost);
                    curPath.remove(curPath.size() - 1);
                    curCost -= eachEdge.weight;
                    curPos = curPath.get(curPath.size() - 1);


                }



            }


        }




    }
    
    /**
     * 
     * Calculates the time for each of the algorithms
     * 
     * */
    public void time() {
    	forTimeOnly = true;
    	String retString = "";
    	long startTime = System.nanoTime();
    	Heruistic();
    	long endTime = System.nanoTime();
    	long duration = (endTime - startTime);
    	retString +="heuristic: cost = "+herusiticCost+", "+duration/1000000+" milliseconds\n";
    	
    	startTime = System.nanoTime();
    	myOwn();
    	endTime = System.nanoTime();
    	duration = (endTime - startTime);
    	retString +="mine: cost = "+mineCost+", "+duration/1000000+" milliseconds\n";
    	
    	startTime = System.nanoTime();
    	BackTracking(false);
    	endTime = System.nanoTime();
    	duration = (endTime - startTime);
    	retString +="Backtracking: cost = "+backtrackCost+", "+duration/1000000+" milliseconds\n";
    	
    	System.out.println(retString);

    	
    	
    }

    /**
     * 
     * Given a list of paths, this functions creates a retString for our program
     * 
     * */
    private void printPathInfo(List < Integer > lowestPath2, double pathCost) {
    	if(!forTimeOnly) {
    		
    
        String cost = String.format("%.1f", pathCost);
        String retString = "cost = " + cost + ", visitOrder = [";
        for (int each: lowestPath2) {
            retString += each + ", ";
        }
        retString = retString.substring(0, retString.length() - 2) + "]";
        System.out.println(retString);
        
    	}

    }









}