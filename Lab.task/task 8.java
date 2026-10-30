import java.util.*;

public class Main {

    static class Edge {
        int destination;
        int distance;

        Edge(int destination, int distance) {
            this.destination = destination;
            this.distance = distance;
        }
    }

    static class Node implements Comparable<Node> {
        int location;
        int distance;

        Node(int location, int distance) {
            this.location = location;
            this.distance = distance;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        int source = sc.nextInt();
        int destination = sc.nextInt();

        int[] distance = new int[n];
        int[] parent = new int[n];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        distance[source] = 0;
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            int u = current.location;

            if (current.distance != distance[u]) {
                continue;
            }

            for (Edge edge : graph.get(u)) {
                int v = edge.destination;
                int newDistance = distance[u] + edge.distance;

                if (newDistance < distance[v]) {
                    distance[v] = newDistance;
                    parent[v] = u;
                    pq.add(new Node(v, newDistance));
                }
            }
        }

        if (distance[destination] == Integer.MAX_VALUE) {
            System.out.println("No route available");
        } else {
            System.out.println("Shortest Distance: " + distance[destination]);

            List<Integer> path = new ArrayList<>();

            for (int current = destination; current != -1; current = parent[current]) {
                path.add(current);
            }

            Collections.reverse(path);

            System.out.print("Best Route: ");

            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));

                if (i < path.size() - 1) {
                    System.out.print(" -> ");
                }
            }

            System.out.println();
        }

        sc.close();
    }
}
OUTPUT:
5 6
0 1 4
0 2 2
1 2 1
1 3 5
2 3 8
3 4 2
0 4

Shortest Distance: 11
Best Route: 0 -> 1 -> 3 -> 4
