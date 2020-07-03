
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Test24 { 
	    static int min(int x, int y, int z) 
	    { 
	        if (x <= y && x <= z) 
	            return x; 
	        if (y <= x && y <= z) 
	            return y; 
	        else
	            return z; 
	    } 
	  
	    static int editDist(String str1, String str2, int m, int n) 
	    { 
	        
	        if (m == 0) 
	            return n; 
	  
	         
	        if (n == 0) 
	            return m; 
	  
	         
	        if (str1.charAt(m - 1) == str2.charAt(n - 1)) 
	            return editDist(str1, str2, m - 1, n - 1); 
	  
	         
	        return 1 + min(editDist(str1, str2, m, n - 1), // Insert 
	                       editDist(str1, str2, m - 1, n), // Remove 
	                       editDist(str1, str2, m - 1, n - 1) // Replace 
	                       ); 
	    } 
	  
	    public static void main(String args[]) throws Exception
	    { 
	    	String fil=args[0];
			String key=args[1];
			String line = "";  
			String splitBy = ",";  
		    ArrayList<String> list=new ArrayList<>();
			BufferedReader br = new BufferedReader(new FileReader(fil));  
			while ((line = br.readLine()) != null)     
			{  
			String[] temp = line.split(splitBy);  
			  list.add(temp[0]);
			} 
			int arr[][]=new int[list.size()][2];
	        for(int i=0;i<list.size();i++) 
	        { 
	        	arr[i][1]=i;
	        	arr[i][0]=editDist(list.get(i), key, list.get(i).length(), key.length()); 
	        }
	        for (int i=0;i<list.size()-1;i++)
			{
			for (int j=0;j<list.size()-1-i;j++)
			{ if (arr[j][0] > arr[j+1][0])
	                {
	                    int temp = arr[j][0];
	                    arr[j][0] = arr[j+1][0];
	                    arr[j+1][0] = temp;
	                    temp = arr[j][1];
	                    arr[j][1] = arr[j+1][1];
	                    arr[j+1][1] = temp;
	                    
	                }
			}
			
			}
	        for(int i=0;i<5;i++)
	        {
	        	System.out.println(list.get(arr[i][1]));
	        }
	        br.close();
	        }
	    
	} 