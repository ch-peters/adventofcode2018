package adventdayone;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class AdventDayOne {

    public static void main(String[] args) throws IOException {
        //Here I am adding a comment!
        Scanner scanN = new Scanner(System.in);
        int num, total = 0;
        boolean flag = false;
        ArrayList<Integer> values = new ArrayList<>();
        while(flag == false)
        {
            File file = new File("C:\\Users\\Chris\\Downloads\\input.txt");  
            Scanner inputFile = new Scanner(file);  
            while(inputFile.hasNext())
            {
                num = inputFile.nextInt();
                total += num;
                values.add(total);
            }
            inputFile.close();
        Collections.sort(values);
        for(int j = 0; j < (values.size()-1); j++)
        {
            if(values.get(j).equals(values.get(j+1)))
            {
                System.out.println(values.get(j));
                flag = true;
            }
        }
        }
    }
        
}