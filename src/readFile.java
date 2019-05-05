import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class readFile {
    private Scanner scanner;
    private static final int numberOfSeedVarieties = 5;

    readFile(){
        try {
            scanner = new Scanner(new File("input2.txt")).useLocale(Locale.US);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    readFile(String[] args){
        try {
            scanner = new Scanner(new File(args[0])).useLocale(Locale.US);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private redAnt readRedAnt(int id){
        //int id = scanner.nextInt();
        double x_position = scanner.nextDouble();
        double y_position = scanner.nextDouble();
        int basketCapacity = scanner.nextInt();
        return new redAnt(id,x_position,y_position,basketCapacity);
    }

    private blackAnt readBlackAnt(int id){
        //int id = scanner.nextInt();
        double x_position = scanner.nextDouble();
        double y_position = scanner.nextDouble();
        LinkedList<Integer> listSeedVarieties = new LinkedList<>();
        for(int i=0; i<numberOfSeedVarieties; i++){
            listSeedVarieties.add(scanner.nextInt());
        }
        ArrayList<Integer> arraySeedVarieties = new ArrayList<>();
        arraySeedVarieties.addAll(listSeedVarieties);

        return new blackAnt(id,x_position,y_position,arraySeedVarieties);
    }

    public LinkedList<Ant> readAnts(){

        LinkedList<Ant> allAnts = new LinkedList<>();

        while(scanner.hasNextInt()){
            int id = scanner.nextInt();
            if((id%2==1)){
                allAnts.add(readRedAnt(id));
            }
            else{
                allAnts.add(readBlackAnt(id));
            }
        }

        return allAnts;
    }
}
