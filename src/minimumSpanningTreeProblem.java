/**
 * This class is the implementation of the Minimum Spanning Tree problem using the Kruskal Algorithm,
 * needed for the 1st part of the project.
 * @author Stavratis Konstantinos AEM: 3137
 */

import java.util.*;

public class minimumSpanningTreeProblem {

    private int vertices;
    private ArrayList<edgesBetweenTwoAnts> allEdges = new ArrayList<>();
    private double weightOfGraph;
    private ArrayList<edgesBetweenTwoAnts> MST = new ArrayList<>();


    public minimumSpanningTreeProblem(int sizeOfAnts){
        this.vertices = sizeOfAnts;
    }

    public minimumSpanningTreeProblem(ArrayList<edgesBetweenTwoAnts> allEdges,int sizeOfAnts){
        this.allEdges.addAll(allEdges);
        this.vertices = sizeOfAnts;
    }

    public minimumSpanningTreeProblem(ArrayList<Ant> allAnts){
        this.vertices = allAnts.size();

        for(int i=0; i<allAnts.size();i++){
            for(int j= i+1; j<allAnts.size(); j++){
                this.allEdges.add(new edgesBetweenTwoAnts(allAnts.get(i),allAnts.get(j)));
            }
        }
    }

    public minimumSpanningTreeProblem(LinkedList<Ant> allAnts){
        this.vertices = allAnts.size();

        ArrayList<Ant> AllAnts = new ArrayList<>();
        AllAnts.addAll(allAnts);
        for(int i=0; i<AllAnts.size();i++){
            for(int j= i+1; j<AllAnts.size(); j++){
                this.allEdges.add(new edgesBetweenTwoAnts(AllAnts.get(i),AllAnts.get(j)));
            }
        }
    }

    public double getWeightOfGraph() { return weightOfGraph; }
    public ArrayList<edgesBetweenTwoAnts> getMST() { return MST; }

    public void calculateKruskalMST(){
        this.MST.addAll(KruskalMST());
    }

    /**
     * Adds a new edge between two ants to the list of edges.
     * @param node1 1st ant.
     * @param node2 2nd ant.
     */
    public void addEdge(Ant node1, Ant node2){
        allEdges.add(new edgesBetweenTwoAnts(node1,node2));
    }

    private ArrayList<edgesBetweenTwoAnts> KruskalMST(){
        /*
        Priority Queue in its general implementation uses the > operator when comparing. We override what is being compared,
        which in Kruskal's case is the weight of the edges.
        The Java implementation of Priority Queue sorts in descending order.
        NOTE: In Java versions of 8 and higher, this comparator can be replaced by the lambda expression " o -> o.weight() "
        */
        PriorityQueue<edgesBetweenTwoAnts> priorityQueue = new PriorityQueue<edgesBetweenTwoAnts>(allEdges.size(), new Comparator<edgesBetweenTwoAnts>(){
            public int compare(edgesBetweenTwoAnts lhs, edgesBetweenTwoAnts rhs){
                if(lhs.getWeight()> rhs.getWeight()){ return 1; }
                else{ if(lhs.getWeight()==rhs.getWeight()){ return 0; } }
                return -1;
            }
        });

        /*
        Adds all edges to the priorityQueue, which sorts the edges in ascending order of their weights.
         */
        priorityQueue.addAll(allEdges);

        /*
        create a parent[], having the needed number of cells.
        NOTE: In this problem, IDs start from 1, contradicting the "computer" arithmetic start from zero (0).
         */
        int[] parent = new int[vertices+1];
        makeSet(parent);

        /*Initializing an empty array list, which in turn will be the returned minimum spanning tree
         * of Kruskal's Algorithm.*/
        ArrayList<edgesBetweenTwoAnts> minimumSpanningTree = new ArrayList<>();


        int currentEdge = 0;
        /*The process is repeated until v-1 edges are included in the graph. */
        while(currentEdge<vertices-1){
            edgesBetweenTwoAnts edge = priorityQueue.remove();

            /*
            Checking whether this removal creates a circle in the graph.
             */
            int x_set = find(parent, edge.getNode1());
            int y_set = find(parent, edge.getNode2());

            //If it is equal, a circle is created.
            if(x_set!=y_set){
                /*add the node during this repetition in the graph.*/
                minimumSpanningTree.add(edge);
                currentEdge++;
                union(parent,x_set,y_set);
            }
        }
        calculateTotalWeight(minimumSpanningTree);

        /*
        Sorting in ascending order of the first ids and if they're equal,
        in ascending order of the second ids.
         */
        Collections.sort(minimumSpanningTree, new Comparator<edgesBetweenTwoAnts>() {
            @Override
            public int compare(edgesBetweenTwoAnts o1, edgesBetweenTwoAnts o2) {
                if(o1.getNode1()>o2.getNode1()) { return 1; }
                if(o1.getNode1()==o2.getNode1()) {
                    if (o1.getNode2() > o2.getNode2()) {
                        return 1;
                    } else {
                        if (o1.getNode2() == o2.getNode2()) { return 0; }
                        else { return -1; }
                    }
                }
                return -1;
            }
        });

        return minimumSpanningTree;

    }

    /**
     * This creates an array, where each position represents the id of the node and the value of every cell
     * describes its father node.
     * @param parent an allocated array having the needed positions.
     */
    private void makeSet(int[] parent){
        /*Originally, all nodes point to themselves.
         * In this problem, IDs start from value 1.*/
        for(int i=0; i<vertices+1; i++){
            parent[i] = i;
        }
    }

    private int find(int[] parent, int vertex){
        if (parent[vertex]!=vertex){
            return find(parent,parent[vertex]);
        }
        return vertex;
    }

    private void union(int[] parent, int x, int y){
        int x_set_parent = find(parent, x);
        int y_set_parent = find(parent, y);
        /*Making x parent of y.*/
        parent[y_set_parent] = x_set_parent;
    }


    /**
     * Calculates the total weight of the MST lastly calculated.
     * This function is called after the creation of the minimum spanning tree.
     * @param MST the minimum spanning tree.
     */
    private void calculateTotalWeight(ArrayList<edgesBetweenTwoAnts> MST){
        double sum=0;
        for (int i=0; i<MST.size();i++){
            sum+=MST.get(i).getWeight();
        }
        weightOfGraph = sum;
    }
}