public class BellmanFord {
	private int distances[];
	private int numberofvertices;
	public static final int INF = 9999;

	public BellmanFord(int numberofvertices) {
		this.numberofvertices = numberofvertices;
		distances = new int[numberofvertices + 1];
	}

	public long timeBellmanFord(int graph[][], int src) {
		long startTime = System.nanoTime();
		BellmanFordEvaluation(src, graph);
		long endTime = System.nanoTime();

		return (endTime - startTime);
	}

	public void BellmanFordEvaluation(int source, int adjacencymatrix[][]) {
		for (int node = 0; node < numberofvertices; node++) {
			distances[node] = INF;
		}

		distances[source] = 0;
		for (int node = 0; node <= numberofvertices - 1; node++) {
			for (int sourcenode = 0; sourcenode < numberofvertices; sourcenode++) {
				for (int destinationnode = 0; destinationnode < numberofvertices; destinationnode++) {
					if (adjacencymatrix[sourcenode][destinationnode] != INF) {
						if (distances[destinationnode] > distances[sourcenode]
								+ adjacencymatrix[sourcenode][destinationnode])
							distances[destinationnode] = distances[sourcenode]
									+ adjacencymatrix[sourcenode][destinationnode];
					}
				}
			}
		}
	}
}
