import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PA11Main {

    static DGraph dg;

    public static ArrayList < String[] > myData = new ArrayList < > ();
    
    /**
     * 
     * This fucntion bacisally runs our program. It reads input file path and
     * a command argument, and prints our the results of solving travelling salesman
     * problem!
     * */
    public static void main(String[] args) {
        try {
            File myObj = new File(args[0]);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();

                if (!data.startsWith("%")) {
                    myData.add(data.split("\\s+"));

                }
            }

            for (String[] each: myData) {

                if (dg == null) {
                    dg = new DGraph(Integer.parseInt(each[0]));

                } else {
                    int u = Integer.parseInt(each[0]);
                    int v = Integer.parseInt(each[1]);
                    double w = Double.parseDouble(each[2]);
                    dg.addEdge(u, v, w);

                }
            }
            String command = args[1];

            switch (command) {
                case "HEURISTIC":
                    dg.Heruistic();
                    break;
                case "BACKTRACK":
                    dg.BackTracking(false);
                    break;
                case "MINE":
                    dg.myOwn();
                    break;
                case "TIME":
                	dg.time();
                    break;

            }


        } catch (Exception e) {

            System.out.println(e.getMessage());

        }




    }






}