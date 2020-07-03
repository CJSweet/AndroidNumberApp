package com.example.basicrandomnumberapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class StatsBackend {

    ///list of numbers, use a treemap
    ArrayList<Double> numset = new ArrayList<>();

    /// create Strings for all the stats
    String mean;
    String median;
    String mode;
    String range;
    String dataSet = "";



    StatsBackend() {

    }

    // method to add number to map
    // if new number, put new pair in map
    // if number already exists, increment value int
    public void addToMap(String numStr){

        double numDb = Double.valueOf(numStr);

        numset.add(numDb);
        Collections.sort(numset);
    }

    // method to begin calculating all stats
    public void calculate(){

        dataSetStr();
        calcMean();
        calcMedian();
        calcMode();
        calcRange();

    }

    public void dataSetStr(){

        for(int i = 0; i < numset.size(); i++){
            dataSet = dataSet.concat(String.valueOf(numset.get(i)) + ", ");
        }

        //get rid of last ", "
        dataSet = dataSet.substring(0, dataSet.length() - 2);

    }

    // calculate mean
    public void calcMean(){

        double sum = 0;
        for(int i = 0; i < numset.size(); i++){
            sum += numset.get(i);
        }

        double meanDb = sum / numset.size();

        mean = String.valueOf(meanDb);
    }

    //calculate median{
    public void calcMedian(){

        int i = numset.size() / 2;
        double medDb = 0;

        if(numset.size() % 2 == 0){
            medDb = (numset.get(i) + numset.get(i+1))/2;
        }
        else{
            medDb = numset.get(i);
        }

        median = String.valueOf(medDb);
    }

    // calculate mode
    // code inspired by: https://stackoverflow.com/questions/36416048/java-program-to-find-mode-in-an-array-list
    public void calcMode(){
        //TODO: make it so multiple numbers can be mode
        // TODO: also make a faster algorithm
        double modeDb = numset.get(0);
        int maxCount = 0;
        for(int i = 0; i < numset.size(); i++){
            double value = numset.get(i);
            int count = 0;
            for(int j = 0; j < numset.size(); j++){
                if(numset.get(j) == value)
                    count++;
                if(count > maxCount){
                    modeDb = value;
                    maxCount = count;
                }
            }
        }

        if(maxCount > 1 ){
            mode = String.valueOf(modeDb);
        }
        else
            mode =  "No Mode";

    }

    //calculate range
    public void calcRange(){

        double first = numset.get(0);
        double last = numset.get(numset.size()-1);

        double rngDb = last - first;

        range = String.valueOf(rngDb);
    }

    //reset all numbers/stats after submit button hit for next set
    public void clear(){
        dataSet = "";
        numset.clear();
    }

}
