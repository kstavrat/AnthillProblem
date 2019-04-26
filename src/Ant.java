/**
 * Implementation of mother abstract class "Ant".
 * @author Stavratis Konstantinos AEM: 3137
 */

public abstract class Ant {

    private final int id;
    private final double Xcoordinate;
    private final double Ycoordinate;
    private final boolean colour; // true: red, false: black

    public double getXcoordinate() { return Xcoordinate; }
    public double getYcoordinate() { return Ycoordinate; }
    public boolean getColour() { return colour; }

    /**
     * Used in constructor to determine whether the ant given is red or black.
     * @param id of ant.
     * @return colour of ant.
     */
    private boolean calculateColour(int id){
        if (id%2 == 1) {
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Constructor of class "Ant", given an id, and a position (x,y).
     * @param id of ant
     * @param Xcoordinate position of ant in x-axis.
     * @param Ycoordinate position of ant in y-axis.
     */
    public Ant(int id, double Xcoordinate, double Ycoordinate){
        this.id = id;
        this.colour = calculateColour(id);
        this.Xcoordinate = Xcoordinate;
        this.Ycoordinate = Ycoordinate;
    }

    public int getId() {return id;}
}
