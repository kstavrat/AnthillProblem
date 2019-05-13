package AntsClasses;

/**
 * Implementation of "Red AntsClasses.Ant" class.
 * @author Stavratis Konstantinos AEM: 3137  e-mail: kstavrat@csd.auth.gr
 */

public class redAnt extends Ant {

    private final int basketCapacity;

    public redAnt(int id, double Xcoordinate, double Ycoordinate, int basketCapacity){
        super(id,Xcoordinate,Ycoordinate);
        /*
        Checking in the internal constructor whether the constructor of mother class "AntsClasses.Ant" was implemented successfully.
         */
        if(!this.getColour()){
            throw new java.lang.Error("This 'AntsClasses.redAnt' object is not red.");
        }
        this.basketCapacity = basketCapacity;
    }

    public int getBasketCapacity() { return basketCapacity; }

    public double getEuclidianDistanceFromBlackAnt(blackAnt a){
        return  Math.sqrt(Math.pow(this.getXcoordinate()-a.getXcoordinate(),2) + Math.pow(this.getYcoordinate()-a.getYcoordinate(),2));
    }
}
