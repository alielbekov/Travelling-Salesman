
/*
 * Author: Ali Elbekov * File: PA11Main.java
 * Assignment: Travelling Salesman
 * Course: CSC 210;  Fall 2022;
 * Purpose: This program uses two sorts of algorithms to solve Travelling Salesman Problem.
 * One of them is heuristic approach where lowest-weight neighboring city is chosen and proceeded to.
 * The other approach is using recursive backtracking where we brute-force all the possible paths and return the best one.
 * The program also includes an improved version of the brute-force approach where the program won't have to 
 * iterate through unnecessary loops by skipping them once the travel cost is already more the the current lowest cost.
 *
 */


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