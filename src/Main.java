import java.util.Random;

public class Main {

	private static Random random = new Random();
	public static final int INF = 0;

	public static void main(String[] args) {
		int numberofvertices = 100;                 //Number of vertices in graph can be change(dont make it more than 10000, because bellmanford is very slow to solve it.) 
		int source = 1;								//The vertex index For single-pair algorithms
		Random r = new Random();

		int graph[][] = new int[numberofvertices][numberofvertices];
		for (int i = 0; i < numberofvertices; i++) {
			for (int j = 0; j < i; j++) {
				int value = r.nextInt(50) + 1;
				if (getRandomBoolean((float) 0.6) == true) {
					value = INF;
				}
				graph[i][j] = value;
				graph[j][i] = value;
			}
		}
		
		Dijkstra t = new Dijkstra(numberofvertices);
		System.out.println("Dijkstra's Algorithm:     " + t.timeDijkstra(graph, 0));
		BellmanFord bellmanford = new BellmanFord(numberofvertices);
		System.out.println("Bellman-Ford Algorithm:   " + bellmanford.timeBellmanFord(graph, source));
		FloydWarshall a = new FloydWarshall(numberofvertices); 
		System.out.println("Floyd-Warshall Algorithm: " + a.timefloydWarshall(graph));
	}

	public static boolean getRandomBoolean(float p) {
		return random.nextFloat() < p;
	}

}
