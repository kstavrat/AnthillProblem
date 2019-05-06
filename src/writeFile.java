/**
 * In this class, the output files are written and given to the user.
 * @author Stavratis Konstantinos, AEM: 3137
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeMap;

public class writeFile {

    private readFile readFile;
    private LinkedList<Ant> allAnts;

    public writeFile(){
        this.readFile = new readFile();
        allAnts = new LinkedList<>();
        allAnts = readFile.readAnts();
    }

    public writeFile(String[] args){
        this.readFile = new readFile(args);
        allAnts = new LinkedList<>();
        allAnts = readFile.readAnts();
    }


    public void writeMSTproblem(){
        minimumSpanningTreeProblem minimumSpanningTreeProblem = new minimumSpanningTreeProblem(allAnts);
        minimumSpanningTreeProblem.calculateKruskalMST();

        try {
            PrintWriter printWriter = new PrintWriter("MSToutput.txt");
            printWriter.println(minimumSpanningTreeProblem.getWeightOfGraph());
            for(int i=0; i<minimumSpanningTreeProblem.getMST().size(); i++){
                printWriter.println(minimumSpanningTreeProblem.getMST().get(i).getNode1() +
                        " " + minimumSpanningTreeProblem.getMST().get(i).getNode2());
            }
            printWriter.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void writeStableMarriageProblem() {
        stableMarriageProblem stableMarriageProblem = new stableMarriageProblem(allAnts);
        TreeMap<redAnt, blackAnt> matchings = stableMarriageProblem.run();
        try {
            PrintWriter printWriter = new PrintWriter("StableMarriageProblemOutput.txt");
            for (redAnt red : matchings.keySet()) {
                printWriter.println(red.getId() + " " + matchings.get(red).getId());
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeChangeMakingProblem(){
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

        try{
            PrintWriter printWriter = new PrintWriter("ChangeMakingProblemOutput.txt");
            for(int i=0; i<AllAnts.size()/2;i++){
                ArrayList<Integer> tempSeedVarieties = new ArrayList<>();
                int tempBasketCapacity = 1;

                if(AllAnts.get(2*i) instanceof redAnt){
                    tempBasketCapacity = ((redAnt) AllAnts.get(2*i)).getBasketCapacity();
                }
                if(AllAnts.get(2*i+1) instanceof blackAnt){
                    tempSeedVarieties.addAll(((blackAnt) AllAnts.get(2*i+1)).getSeedVarieties());
                }
                ArrayList<Integer> counterOfSeedsReturned = new changeMakingProblem().run(tempSeedVarieties,tempBasketCapacity);
                if(counterOfSeedsReturned.size()>0) {
                    printWriter.print(AllAnts.get(2*i).getId() + " " + AllAnts.get(2*i + 1).getId());
                    for(int j=0; j<counterOfSeedsReturned.size(); j++) {
                        printWriter.print(" " + counterOfSeedsReturned.get(j));
                    }
                    printWriter.println();
                }
            }
            printWriter.close();
        }
        catch (FileNotFoundException e) { e.printStackTrace();}

    }
}
