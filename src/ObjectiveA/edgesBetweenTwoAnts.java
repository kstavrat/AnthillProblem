package ObjectiveA;

import AntsClasses.Ant;

/**
 * This class creates an edge between two ants, disregarding their colour.
 * @author Stavratis Konstantinos AEM: 3137  e-mail: kstavrat@csd.auth.gr
 */
public class edgesBetweenTwoAnts {

    private final int node1;
    private final int node2;
    private final double weight;

    private double euclideanDistance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
    }

    public edgesBetweenTwoAnts(Ant node1, Ant node2){
        this.node1 = node1.getId();
        this.node2 = node2.getId();
        this.weight = euclideanDistance(node1.getXcoordinate(),node1.getYcoordinate(),node2.getXcoordinate(),node2.getYcoordinate());
    }

    public int getNode1() { return node1; }
    public int getNode2() { return node2; }
    public double getWeight() { return weight; }

    /**
     * Returns the other edge from the edge of the input.
     * @param id one of the two edges.
     * @return id of the other edge.
     */
    public int otherEdge(int id){
        if(id==this.node1){
            return this.node2;
        }
        if(id==this.node2){
            return this.node1;
        }
        else{
            throw new Error("There is no edge in this vertix with this id.");
        }
    }
}
