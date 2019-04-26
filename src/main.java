/**
 * main function of the program.
 * @author Stavratis Konstantinos AEM: 3137
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class main {
    public static void main(String[] args) {
        /*
        FILE READING STARTS HERE!!!
         */
        readFile readFile = new readFile();
        System.out.println("READING ANTS");
        LinkedList<Ant> allAnts = readFile.readAnts();
        for(Ant x : allAnts){
            System.out.print("id = " + x.getId() + " x = " + x.getXcoordinate() + " y = " + x.getYcoordinate());
            if(x instanceof redAnt){
                System.out.println(" basket capacity = " + ((redAnt) x).getBasketCapacity());
            }
            else{
                if(x instanceof blackAnt){
                    System.out.println(" seed varieties = " + ((blackAnt) x).getSeedVarieties());
                }
            }
        }
        /*
        FILE READING ENDS HERE!!!
         */

        /*
        CHANGE MAKING PROBLEM STARTS HERE!!!
         */
        ArrayList<Ant> AllAnts = new ArrayList<>();
        AllAnts.addAll(allAnts);
        /*
        Sorts Ants according to id ascending order, in order to take pairs.
         */
        AllAnts.sort(new Comparator<Ant>() {
            @Override
            public int compare(Ant o1, Ant o2) {
                if(o1.getId()>o2.getId()){ return 1; }
                else{ if(o1.getId()==o2.getId()){ return 0; } }
                return -1;
            }
        });

        changeMakingProblem changeMakingProblem = new changeMakingProblem();

        for(int i=0; i<AllAnts.size()/2;i++){
            ArrayList<Integer> tempSeedVarieties = new ArrayList<>();
            int tempBasketCapacity = 1;

            if(AllAnts.get(2*i) instanceof redAnt){
                tempBasketCapacity = ((redAnt) AllAnts.get(2*i)).getBasketCapacity();
            }
            if(AllAnts.get(2*i+1) instanceof blackAnt){
                tempSeedVarieties.addAll(((blackAnt) AllAnts.get(2*i+1)).getSeedVarieties());
            }
            System.out.println(AllAnts.get(2*i).getId() + " " +AllAnts.get(2*i+1).getId() + " "
                    +  changeMakingProblem.run(tempSeedVarieties,tempBasketCapacity));
        }

        /*
        CHANGE MAKING PROBLEM ENDS HERE!!!
         */

        /*
        MINIMUM SPANNING TREE STARTS HERE!!!
         */
        minimumSpanningTreeProblem minimumSpanningTreeProblem = new minimumSpanningTreeProblem(allAnts);
        minimumSpanningTreeProblem.calculateKruskalMST();
        System.out.println(minimumSpanningTreeProblem.getWeightOfGraph());
        for(int i=0; i<minimumSpanningTreeProblem.getMST().size(); i++){
            System.out.println(minimumSpanningTreeProblem.getMST().get(i).getNode1() + " " + minimumSpanningTreeProblem.getMST().get(i).getNode2() );
        }
    }
}
