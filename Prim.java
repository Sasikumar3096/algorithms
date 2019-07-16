import java.util.Scanner;

public class Prim
{

  static int count = 15;
  static int n, i;
  static int[][] matrix;

  static int dist[];
  static int visited[];
  static int path[];

  private static void initialize ()
  {
	  matrix = new int[n][n];
      dist = new int[n];
      path = new int[n];
      visited = new int[n];

    for (int i = 1; i < n; i++)
        dist[i] = Integer.MAX_VALUE;

  }
  public static void main (String[]args)
  {
    int j;
    Scanner s = new Scanner (System.in);
    System.out.println ("Enter the number of vertices");
    n = s.nextInt ();
    initialize ();
    System.out.println ("Enter the graph");
    for (i = 0; i < n; i++)
      for (j = 0; j < n; j++)
    	  matrix[i][j] = s.nextInt ();
    System.out.println ("The Shortest path is");
    prim ();
    display ();
    s.close ();
  }

  static int min ()
  {
    int min_val = Integer.MAX_VALUE, min_index = 0;
    for (i = 0; i < n; i++)
      if (min_val > dist[i] && visited[i] != 1)
      {
    	  min_val = dist[i];
    	  min_index = i;
      }
    return min_index;
  }
  static void prim ()
  {
    for (int i = 0; i < n; i++)
      {
    	int min_index = min ();
    	visited[min_index] = 1;
    	for (int j = 0; j < n; j++)
    	{
    		if (matrix[min_index][j] > 0 && visited[j] == 0)
    		{
    			if (dist[j] > matrix[min_index][j])
    			{
    				dist[j] = matrix[min_index][j];
    				path[j] = min_index;
    			}
    		}
    	}
      }
  }
  static void display ()
  {
    int sum = 0;
    System.out.println ("Edge     Weight");
    for (i = 1; i < n; i++)
      {
    	System.out.println (path[i] + "-" + i + "      " + dist[i]);
    	sum += dist[i];
      }
    System.out.println ("The total cost is " + sum);
  }
}

/*
0 2 0 6 0
2 0 3 8 5  
0 3 0 0 7  
6 8 0 0 9  
0 5 7 9 0  
 */
