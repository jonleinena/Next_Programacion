
public class Recursividad2 {
	
	
	public static int utopianTree(int n) {
		return 0;
	}
/*
	 public static String getNewString(String n, int k){
	        String newString = "";
	            for(int i = 0; i<k; i++){
	                newString += n;
	            }
	        return (newString);
	  }

	 public static int super_digit(String p, int n){
	        int sum = 0;
	        if(n == 0){
	            return Character.getNumericValue(p.charAt(n));
	        }else{
	            return Character.getNumericValue(p.charAt(n)) + super_digit(p, n-1);
	        }
	        
	    }
	 
	 public static int superDigit(String n, int k) {
    // Write your code here
        String p = getNewString(n, k);
        String ans = "" + super_digit(p, p.length()-1);
        while(ans.length() != 1){
            ans = ""+ super_digit(ans, ans.length()-1);
        }
        return Integer.parseInt(ans);
	 }
	 */
	 
	 
	 public static int superDigit(String n, int k) {
	        
	        int res = 0;
	        for(int i = 0; i<n.length(); i++){
	            res += Integer.parseInt(n.charAt(i) + ""); //1 + 4 + 8
	        }
	        res *= k;
	        
	        
	       return findSuperDigit(res);
	    
	    }
	    
	    public static int findSuperDigit(int n){
	        
	        if(0 < n  && n < 10){
	            return n;
	        } else {
	        	System.out.println(n%10 + n/10);
	            return findSuperDigit(n%10 + n/10);
	        }
	        
	    }
	    
	    
	    public static void main(String[] args) {
	    	
	    	
	    	
	    	System.out.println(superDigit("439", 1));
	    }
}
