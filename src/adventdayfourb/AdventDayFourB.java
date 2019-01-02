package adventdayfourb;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class AdventDayFourB {

    public static void main(String[] args) throws IOException {
        Scanner scanN = new Scanner(System.in);
        File file = new File("C:\\Users\\Chris\\Downloads\\question4input.txt");
        Scanner inputFile = new Scanner(file);
        ArrayList<String> values = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();
        String[] str, str2;
        int oddoreven = 0;
        int num1 = 0, num2, difference;
        boolean flag;
        int[][] guardsAndMinutes = new int[4000][60];
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
                    oddoreven = 0;
                    for(int q = num1; q < num2; q++)
                    {
                        guardsAndMinutes[ids.get(ids.size()-1)][q]++;
                    }
                }                
            }
        }       

        int largest = 0;
        int largestGuard = 0;
        int largestMinute = 0;
        for(int i = 0; i < 4000; i++)
        {
            for(int j = 0; j < 60; j++)
            {
                if(guardsAndMinutes[i][j]>largest){
                    largest = guardsAndMinutes[i][j];
                    largestGuard = i;
                    largestMinute = j;
                }
                
            }
        }
        System.out.println(largest);
        System.out.println(largestGuard);
        System.out.println(largestMinute);
        
    }
    
}
