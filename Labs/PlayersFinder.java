package Labs;


import java.awt.Point;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


interface IPlayersFinder {

    /**
     * Search for players locations at the given photo
     * @param photo
     *     Two dimension array of photo contents
     *     Will contain between 1 and 50 elements, inclusive
     * @param team
     *     Identifier of the team
     * @param threshold
     *     Minimum area for an element
     *     Will be between 1 and 10000, inclusive
     * @return
     *     Array of players locations of the given team
     */
    java.awt.Point[] findPlayers(String[] photo, int team, int threshold);
}


public class PlayersFinder implements IPlayersFinder{
    /*
       Implement your class here
    */
    static int c=0;
    public java.awt.Point[] findPlayers(String[] photo, int team, int threshold)
    {
        Point[] Players_Loc = new Point[photo.length*photo[0].length()];
        char[][] charPhoto = new char[photo.length][photo[0].length()];
        // Converting the photo to a 2-D Char Array
        for(int i=0 ; i<photo.length ; i++)
        {
            for(int j=0 ; j<photo[i].length() ; j++)
            {
                charPhoto[i][j] = photo[i].charAt(j);
            }
        }
        // Finding Players
        for(int i=0 ; i<photo.length ; i++)
        {
            for(int j=0 ; j<photo[i].length() ; j++)
            {
                if(charPhoto[i][j] == (char)(team + '0'))
                {
                    int[] tempInfo = new int[] {i,j,i,j,0}; // {min_I,min_j,max_i,max_j}
                    chainFinder(charPhoto, i , j,tempInfo,team);
                    if (tempInfo[4]>=threshold)
                    {
                        Players_Loc[c] = new Point((tempInfo[1]+tempInfo[3]+1),(tempInfo[0]+tempInfo[2]+1));
                        c ++;
                    }
                }
            }
        }        
        return Players_Loc;
    }
    public void chainFinder(char[][] charPhoto, int i , int j, int[] tempInfo,int team)
    {
        if(i<0 || j<0 || i>=charPhoto.length || j >= charPhoto[0].length || charPhoto[i][j] != (char)(team + '0'))
            return;
        else
        {
            if(i<tempInfo[0])
                tempInfo[0]=i;
            
            if(i>tempInfo[2])
                tempInfo[2]=i;
            
            if(j<tempInfo[1])
                tempInfo[1]=j;
            
            if(j>tempInfo[3])
                tempInfo[3]=j;
            
            tempInfo[4]+=4;
            charPhoto[i][j] = 'F';
            chainFinder(charPhoto, i+1 , j,tempInfo,team);
            chainFinder(charPhoto, i-1 , j,tempInfo,team);
            chainFinder(charPhoto, i , j+1,tempInfo,team);
            chainFinder(charPhoto, i , j-1,tempInfo,team);
            
        }
    }
    public static void Display_Points(Point[] Players_Loc)
    {
        System.out.print("[");
        for(int i = 0 ; i < c ; i++)
        {
        	if(i != c-1)
        		System.out.print("("+(int)Players_Loc[i].getX()+", "+(int)Players_Loc[i].getY()+"), ");
        	else
        		System.out.print("("+(int)Players_Loc[i].getX()+", "+(int)Players_Loc[i].getY()+")");
        }
        System.out.print("]\n");
    }
    public static void Sort_Points(Point[] Players_Loc)
    {
    	for(int i=0 ; i<c  ; i++)
    	{
    		int min = i;
    		for(int j=i+1 ; j<c  ; j++)
    		{
    			if(Players_Loc[j].getX() < Players_Loc[min].getX())
    				min = j;
    			else if(Players_Loc[j].getX()==Players_Loc[min].getX())
    			{
    				if(Players_Loc[j].getY()<Players_Loc[min].getY())
    					min = j;
    			}
    		}
    		Point temp = new Point(Players_Loc[i]);
			Players_Loc[i] = Players_Loc[min];
			Players_Loc[min] = temp;
    	}
    }
    
    
    public static void main(String[] args) {
        /* Implement main method to parse the input from stdin and print output to stdout */
        Scanner sc = new Scanner(System.in);
        int m,n;
        String[] temp;
        temp = sc.nextLine().split(", ");
        m = Integer.parseInt(temp[0]);
        n = Integer.parseInt(temp[1]);
        String[] tempPhoto = new String[m];
        for(int i=0 ; i<m ; i++)
        {
            tempPhoto[i] = sc.next();
        }
        int team = sc.nextInt();
        int threshold = sc.nextInt();
        Point[] var = new PlayersFinder().findPlayers(tempPhoto,team,threshold);
//        Point[] var = new Point[2];
//        Point A = new Point(3,4);
//        Point B = new Point(5,7);
//        var[0] = A;
//        var[1] = B;
        PlayersFinder.Sort_Points(var);
        PlayersFinder.Display_Points(var);
    }
}