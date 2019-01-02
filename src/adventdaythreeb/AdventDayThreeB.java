package adventdaythreeb;

import java.io.*;
import java.util.Scanner;

public class AdventDayThreeB {

    public static void main(String[] args) throws IOException {
        Scanner scanN = new Scanner(System.in);
        File file = new File("C:\\Users\\Chris\\Downloads\\question3input.txt");
        Scanner inputFile = new Scanner(file);        
        int[][] square = new int[1500][1500];
        int count = 0;
        String str;
        String[] tokens1, tokens2, tokens3, tokens4;
        int startx, starty, endx, endy;
        while(inputFile.hasNext())
        {
            str = inputFile.nextLine();
            tokens1 = str.split("@ ");
            tokens2 = tokens1[1].split(",");
            tokens3 = tokens2[1].split(": ");
            tokens4 = tokens3[1].split("x");
            startx = Integer.parseInt(tokens2[0]) + 1;
            starty = Integer.parseInt(tokens3[0]) + 1;
            endx = Integer.parseInt(tokens2[0]) + Integer.parseInt(tokens4[0]);
            endy = Integer.parseInt(tokens3[0]) + Integer.parseInt(tokens4[1]);
            for(int i = startx; i <= endx; i++)
            {
                for(int j = starty; j <= endy; j++)
                {
                    square[i][j]++;
                }
            }
        } 
        inputFile.close();
        file = new File("C:\\Users\\Chris\\Downloads\\question3input.txt");
        inputFile = new Scanner(file);
        while(inputFile.hasNext())
        {
            str = inputFile.nextLine();
            tokens1 = str.split("@ ");
            tokens2 = tokens1[1].split(",");
            tokens3 = tokens2[1].split(": ");
            tokens4 = tokens3[1].split("x");
            startx = Integer.parseInt(tokens2[0]) + 1;
            starty = Integer.parseInt(tokens3[0]) + 1;
            endx = Integer.parseInt(tokens2[0]) + Integer.parseInt(tokens4[0]);
            endy = Integer.parseInt(tokens3[0]) + Integer.parseInt(tokens4[1]);
            for(int i = startx; i <= endx; i++)
            {
                for(int j = starty; j <= endy; j++)
                {
                    if(square[i][j]==1)
                    {
                        count++;
                    }
                }
            }
            if(count == ((endx-startx+1)*(endy-starty+1)))
            {
                System.out.println(tokens1[0]);
            }
            count = 0;
        }
    }    
}