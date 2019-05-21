import java.io.*;

class GFG 
{ 
      
    // function to find maximum sum path 
    static int maxSum(int tri[][], int n) 
    { 
        if (n > 1) 
            tri[1][1] = tri[1][1] + tri[0][0]; 
            tri[1][0] = tri[1][0] + tri[0][0]; 
      
        for(int i = 2; i < n; i++) { 
            tri[i][0] = tri[i][0] + tri[i-1][0]; 
            tri[i][i] = tri[i][i] + tri[i-1][i-1]; 
      
            for (int j = 1; j < i; j++){ 
                
                if (tri[i][j] + tri[i-1][j-1] >=  
                           tri[i][j] + tri[i-1][j]) 
                      
                    tri[i][j] = tri[i][j]  
                                  + tri[i-1][j-1]; 
                      
                else
                    tri[i][j] = tri[i][j] 
                                    + tri[i-1][j]; 
            } 
        } 
        
        int max = tri[n-1][0]; 
          
        for(int i = 1; i < n; i++) 
        { 
            if(max < tri[n-1][i]) 
                max = tri[n-1][i]; 
        } 
          
        return max; 
    }  
    
    public static void main (String[] args) 
    { 
        int tri[][] = {{1,0,0}, {3,0,0}, {1,2,5},{1,6,3},{8,7,4,6}}; 
          
        System.out.println(maxSum(tri, 3)); 
    } 
} 
