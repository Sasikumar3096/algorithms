
public class ClosestPairFromTwoSortedArray {

	public static void main(String[] args) {

	    int ar1[] = {1, 4, 5, 7}; 
	    int ar2[] = {10, 20, 30, 40}; 
	    int x = 38;
		int diff=Integer.MAX_VALUE,num1=0,num2 = 0;

		int m = ar1.length,n = ar2.length,l,r;
		l=0;
		r = n-1;
		
		while(l < m && r>=0) {
			int temp = Math.abs(ar1[l]+ar2[r]-x);
			if(temp < diff) {
				diff = temp;
				num1 = ar1[l];
				num2 = ar2[r];
			}
			if(ar1[l] + ar2[r] >x)
					l++;
			else
				r--;
		}
		System.out.println(num1 + " "+num2);
		//1 40
		//SWITCH l++ and r-- to GET ANOTHER RESULT 7 30
		
	}

}
