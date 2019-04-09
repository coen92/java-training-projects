package com.coen92.projects.placarding;

import com.coen92.projects.placarding.model.Building;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Placarding challenge
 * Author: Piotr Kapica
 * Challenge from 1 part of IT Oplympics in Poland
 * More info at: https://oi.edu.pl/l/15oi_ksiazeczka/
 *
 */
public class Main implements Runnable {

    public static void main( String[] args )
    {
        new Thread(new Main()).start();
    }

    @Override
    public void run() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("pla.in"));
            Building[] buildings = loadBuildingsFromFile(bufferedReader);

            bufferedReader.close();

            PrintWriter writer = new PrintWriter(new FileWriter("pla.out"));
            saveNumberOfPlacardsToFile(buildings, writer);

            writer.close();

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    //method for Input Stream to read all data about number of buildings and their parameters
    private static Building[] loadBuildingsFromFile(BufferedReader inS) throws IOException {

        int numOfBuildings = Integer.parseInt(inS.readLine());
        Building[] buildings = new Building[numOfBuildings];

        for(int i=0; i<numOfBuildings; i++) {

            String line = inS.readLine();
            StringTokenizer tokens = new StringTokenizer(line);
            //read every record and get information divided by tokens
            int number = i+1;
            int lenght = Integer.parseInt(tokens.nextToken());
            int height = Integer.parseInt(tokens.nextToken());

            buildings[i] = new Building(number, lenght, height);
        }
        return buildings;
    }

    //method for Array of buildings to get their all heights
    private static int[] getAllBuildingsHeights(Building[] buildings) {
        int[] heights = new int[buildings.length];

        for(int i=0; i<buildings.length; i++) {
            heights[i] = buildings[i].getBuildingHeight();
        }
        return heights;
    }

    //method to save the output of minimum count of placards
    private static void saveNumberOfPlacardsToFile(Building[] buildings, PrintWriter outS) {

        int placards = 0;
        int[] buildingHeights = getAllBuildingsHeights(buildings);
        int indicator = 0;

        for(int i=0; i<buildings.length; ++i) {

            int heightOfFirstBuilding = buildingHeights[i];

            while(indicator > 0 && buildingHeights[indicator - 1] > heightOfFirstBuilding) {
                placards++;
                indicator--;
            }
            if(indicator == 0 || buildingHeights[indicator - 1] < heightOfFirstBuilding) {
                buildingHeights[indicator++] = heightOfFirstBuilding;
            }
        }
        int minPlacardsResult = indicator + placards;
        outS.println(minPlacardsResult);
    }
}
