import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int [] left_three   = new int [6];
        int [] left_middle  = new int [6];
        int [] right_middle = new int [6];
        int [] right_three  = new int [6];
        int [] total_values = new int [16];
        
        for(int i = 0; i < 6; i++){
            for(int y = 0; y < 3; y++){
                left_three[i]   += arr[i][y];
                left_middle[i]  += arr[i][y+1];
                right_middle[i] += arr[i][y+2];
                right_three[i]  += arr[i][y+3];
            }
        }
        
        for(int i = 0; i < 4; i++){
            total_values[i]    += left_three[i]   + arr[i+1][1] + left_three[i+2];
            total_values[i+4]  += left_middle[i]  + arr[i+1][2] + left_middle[i+2];
            total_values[i+8]  += right_middle[i] + arr[i+1][3] + right_middle[i+2];
            total_values[i+12] += right_three[i]  + arr[i+1][4] + right_three[i+2];
        }  
        
        int largest_value = total_values[0];
        
        for(int i = 1; i < 15; i++){
            if(total_values[i] > largest_value){
                largest_value = total_values[i];
            }
        }
        
        return largest_value;
    }
}