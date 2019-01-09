public class FloydWarshall {
	private int V;

	public FloydWarshall(int v) {
		this.V = v;
	}

	public long timefloydWarshall(int graph[][]) {
		long startTime = System.nanoTime();
		floydWarshall(graph);
		long endTime = System.nanoTime();

		return (endTime - startTime);
	}

	public void floydWarshall(int graph[][]) {
		int dist[][] = new int[V][V];
		int i, j, k;

		for (i = 0; i < V; i++)
			for (j = 0; j < V; j++)
				dist[i][j] = graph[i][j];

		for (k = 0; k < V; k++) {
			for (i = 0; i < V; i++) {
				for (j = 0; j < V; j++) {
					if (dist[i][k] + dist[k][j] < dist[i][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}
	}
}