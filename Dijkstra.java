import java.util.Scanner;
public class Dijkstra {

	static int n;
	static boolean visited[];
	static int[] path;
	static int[] distance;
	static int matrix[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr= new Scanner(System.in);
		System.out.println("Enter number of Vertices");
			n = sr.nextInt();
		initialize();
		System.out.println("Enter the Graph");
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					matrix[i][j] = sr.nextInt();
		dijistra();
		display();
		sr.close();
		
	}
	private static void display() {
		for(int i = 0;i<n;i++)
			System.out.println(i +" visited through "+ path[i] + " at a cost " + distance[i]);
		
	}
	private static void dijistra() {
		
		for(int i=0;i<n;i++)
		{	int min_index = min();
			visited[min_index] = true;
			for(int j=0;j<n;j++)
			{
				if(matrix[min_index][j] != 0 && visited[j] == false)
				{
					if(distance[j] > distance[min_index]+matrix[min_index][j])
					{
						distance[j] = distance[min_index]+matrix[min_index][j];
						path[j]=min_index;
					
						System.out.println(matrix[min_index][i]);
					}
					
				}
			}
			
		}
	}
	static void initialize() {
		visited=new boolean[n];
		path = new int[n];
		distance=new int[n];
		matrix=new int[n][n];
		distance[0]=0;
		for(int i=1;i<n;i++)
			distance[i]= Integer.MAX_VALUE;
	}
	static int min()
	{
		int min_value=Integer.MAX_VALUE,min_index=0;
		for(int i=0;i<n;i++)
			if(visited[i] == false && distance[i]!=Integer.MAX_VALUE)
				if(min_value>distance[i]) {
						min_value=distance[i];
						min_index=i;
				}
		return min_index;
	}
}
/*
0 4 0 0 0 0 0 8 0  
4 0 8 0 0 0 0 11 0 
0 8 0 7 0 4 0 0 2  
0 0 7 0 9 14 0 0 0 
0 0 0 9 0 10 0 0 0 
0 0 4 14 10 0 2 0 0 
0 0 0 0 0 2 0 1 6  
8 11 0 0 0 0 1 0 7 
0 0 2 0 0 0 6 7 0 
*/

