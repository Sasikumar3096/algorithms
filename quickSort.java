
public class quickSort {

	public static void main(String[] args) {
		 int arr[] = {10, 7, 8, 9, 1, 5}; 
	        int n = arr.length; 
	        sort(arr, 0, n-1); 
	        System.out.println("sorted array"); 
	        printArray(arr); 
	}
	
	public static void sort(int arr[],int l,int h) {
		if(l<h) {
			int pos = partition(arr,l,h);
			sort(arr,l,pos-1);
			sort(arr,pos+1,h);
			}
		}
	public static int partition(int arr[],int low,int high) {
		int pivot = arr[high];
		int i =low-1;
		for(int j = low;j<high;j++)
		{
			if(arr[j]<=pivot) {
				++i;
				swap(arr,i,j);
			}
		}
		swap(arr,i+1,high);
		return i+1;
	}
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	public static void printArray(int arr[]) {
		for (int i :arr)
			System.out.print(i+" ");
	}

}
