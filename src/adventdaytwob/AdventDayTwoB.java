package adventdaytwob;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class AdventDayTwoB {

    public static void main(String[] args) throws IOException {
        Scanner scanN = new Scanner(System.in);
        ArrayList<String> values = new ArrayList<>();
        int count, i, j, k = 0;
        File file = new File("C:\\Users\\Chris\\Downloads\\question2input.txt");  
        Scanner inputFile = new Scanner(file);       
        while(inputFile.hasNext())
        {
            values.add(inputFile.nextLine());
        }         
        for(i = 0; i < values.size(); i++)
        {            
            for(k = (i + 1); k < (values.size()); k++)
            {
                count = 0;
                for(j = 0; j < 26; j++)
                {
                    if(values.get(i).charAt(j)==values.get(k).charAt(j))
                    {
                        count++;
                    }
                }
                if(count>24)
                {
                    System.out.println(values.get(i));
                    System.out.println(values.get(k));
                }
            }            
        }
        inputFile.close();
    }   
}