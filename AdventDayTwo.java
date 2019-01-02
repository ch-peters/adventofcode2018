package adventdaytwo;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class AdventDayTwo {

    public static void main(String[] args) throws IOException {
        //Here I am adding a commenthihiih
        Scanner scanN = new Scanner(System.in);
        int count;
        ArrayList<String> values = new ArrayList<>();
        ArrayList<Integer> numTwos = new ArrayList<>();
        ArrayList<Integer> numThrees = new ArrayList<>();
        boolean twosCount;
        boolean threesCount;
        File file = new File("C:\\Users\\Chris\\Downloads\\question2input.txt");  
        Scanner inputFile = new Scanner(file);       
        while(inputFile.hasNext())
        {
            values.add(inputFile.nextLine());
        }        
        for(int i = 0; i < values.size(); i++)
        {
            count = 0;
            twosCount = false;
            threesCount = false;
            for(char j = 'a'; j <= 'z'; j++)
            {
                for(int k = 0; k < values.get(i).length(); k++)
                {
                    if (values.get(i).charAt(k) == j)
                    {
                        count++;
                    }                    
                }
                if(count == 2 && twosCount == false)
                {
                    numTwos.add(1);
                    twosCount = true;
                    count = 0;
                }
                else if(count == 3 && threesCount == false)
                {
                    numThrees.add(1);
                    threesCount = true;
                    count = 0;
                }
                else
                {
                    count = 0;
                }
            }
        }
        inputFile.close();
        System.out.println(numTwos.size());
        System.out.println(numThrees.size());
        System.out.println(numTwos.size()*numThrees.size());
    }    
}