package adventdayfour;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class AdventDayFour {

    public static void main(String[] args) throws IOException {
        Scanner scanN = new Scanner(System.in);
        File file = new File("C:\\Users\\Chris\\Downloads\\question4input.txt");
        Scanner inputFile = new Scanner(file);
        boolean flag;
        int subtotal = 0;
        int oddoreven = 0;
        int num1 = 0, num2 = 0, difference;
        String[] str, str2;
        ArrayList<String> values = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();
        ArrayList<Integer> minutes = new ArrayList<>();
        int[] totalcounts = new int[4000];
        int[] minuteCounterFor2657 = new int[60];
        //Add all the lines of the text file to an arraylist - there are 986 lines
        while(inputFile.hasNext())
        {
            values.add(inputFile.nextLine());
        }
        
        //Sort the arraylist
        Collections.sort(values);
        for(int i = 0; i < values.size(); i++)
        {
            flag = false;
            for(int j = 0; j < values.get(i).length(); j++)
            {
                if(values.get(i).charAt(j)=='#')
                {
                    flag = true;
                }
            }
            if(flag == true)
            {
                if(i > 0)
                {
                    minutes.add(subtotal);
                }
                subtotal = 0;
                oddoreven = 0;
                str = values.get(i).split("#");
                str2 = str[1].split(" b");
                ids.add(Integer.parseInt(str2[0]));
            }
            else
            {
                if(oddoreven == 0)
                {
                    str = values.get(i).split(":");
                    str2 = str[1].split("]");    
                    num1 = Integer.parseInt(str2[0]);
                    oddoreven = 1;
                }
                else
                {
                    str = values.get(i).split(":");
                    str2 = str[1].split("]");      
                    num2 = Integer.parseInt(str2[0]);
                    difference = num2 - num1;
                    subtotal += difference;
                    oddoreven = 0;
                    if(ids.get(ids.size()-1)==2657)
                    {
                        for(int q = num1; q < num2; q++)
                        {
                            minuteCounterFor2657[q]++;
                        }
                    }
                }                
            }
        }
        /*for(int i = 0; i < ids.size()-1; i++)
        {
            System.out.println(ids.get(i));
            System.out.println(minutes.get(i));
        }*/
        for(int i = 0; i < ids.size()-1; i++)
        {
            totalcounts[ids.get(i)]+=minutes.get(i);
        }
        int largestvalue = 0;
        int largestposition = 0;
        for(int i = 0; i < totalcounts.length; i++)
        {
            if(totalcounts[i]>largestvalue)
            {
                largestvalue = totalcounts[i];
                largestposition = i;
            }
        }
        for(int i = 0; i < 60; i++)
        {
            System.out.println(i + " " + minuteCounterFor2657[i]);
        }
    }       
}