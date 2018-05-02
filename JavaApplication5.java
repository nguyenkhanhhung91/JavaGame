/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.util.ArrayList;

/**
 *
 * @author Hung
 */
public class JavaApplication5 {

 class Solution {
    public int min(int a, int b){
        if (a>=b)
            return b;
        else return a;
    }
    
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        //find the maximum value of all rows in the original grid
        ArrayList<Integer> maxInRow = new ArrayList<Integer>();
        for (int i=0;i<grid.length;i++){
            int max=grid[i][0];
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]>max)
                    max=grid[i][j];
            }
            maxInRow.add(max);
        }
        
        
        //find the maximum value of all cols in the original grid
        ArrayList<Integer> maxInCol = new ArrayList<Integer>();
         for (int i=0;i<grid.length;i++){
            int max=grid[0][i];
            for(int j=0;j<grid.length;j++){
                if(grid[j][i]>max)
                    max=grid[j][i];
            }
            maxInCol.add(max);
        }      
        
        int sum=0;
        //for each position, increase the height to the min(max of col, max of row)
        for (int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                int temp=grid[i][j];
                grid[i][j]=min(maxInRow.get(i),maxInCol.get(j));
                sum+=grid[i][j]-temp;
            }
        }   
        return sum;
    }
   
}
    
}
