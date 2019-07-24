
public class mergeSort {

	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6, 7}; 
		  
        sort(arr, 0, arr.length-1); 
  
        System.out.println("\nSorted array"); 
        printArray(arr);
	}

	private static void printArray(int[] arr) {
		for(int i:arr)
				System.out.print(i+" ");
	}

	private static void sort(int[] arr, int l, int r) {
		if(l<r) {
			int m = (l+r)/2;
			sort(arr,l,m);
			sort(arr,m+1,r);
			
			merge(arr,l,m,r);
		}	
	}

	private static void merge(int[] arr, int l, int m, int r) {
		int n1 = m-l+1, i, j, k;
		int n2 = r-m;
		int L[] = new int[n1];
		int R[] = new int[n2];

		for(i=0;i<n1;i++)
			L[i] = arr[l+i];

		for(i=0;i<n2;i++)
			R[i] = arr[m+i+1];
		
		i=j=0;
		k=l;
		while(i<n1 && j<n2) {
			if( L[i] <= R[j] ) {
				arr[k++] = L[i++];
			}
			else {
				arr[k++]  = R[j++];
			}
		}
		while(i<n1) {
			arr[k++] = L[i++];
		}
		while(j<n2)
			arr[k++] = R[j++];
		}
	}

