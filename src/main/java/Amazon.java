import java.util.*;

public class Amazon {

    List<Pair> list;
    Map<Integer, Boolean> visited;

    public List<Integer> solution(int numRouters, int numLinks, ArrayList<ArrayList<Integer>> links) {
        ArrayList<Pair> connections = new ArrayList<>();
        for (ArrayList<Integer> ai : links) {
            connections.add(new Pair(ai.get(0), ai.get(1)));
        }

        Map<Integer, HashSet<Integer>> adj = new HashMap<>();
        for (Pair connection : connections) {
            int u = connection.first;
            int v = connection.second;
            if (adj.get(u) == null) {
                adj.put(u, new HashSet<Integer>());
            }
            adj.get(u).add(v);
            if (adj.get(v) == null) {
                adj.put(v, new HashSet<Integer>());
            }
            adj.get(v).add(u);
        }

        list = new ArrayList<>();
        for (int i = 0; i < numLinks; i++) {
            visited = new HashMap<>();
            Pair p = connections.get(i);
            int x = p.first;
            int y = p.second;
            adj.get(x).remove(y);
            adj.get(y).remove(x);
            DFS(adj, 1);
            if (visited.size() != numRouters) {
                if (p.first > p.second)
                    list.add(new Pair(p.second, p.first));
                else
                    list.add(p);
            }
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        ArrayList a = new ArrayList();
        for (Pair pair : list) {
            a.add(pair.first);
        }
        return a;

/**
 * Convert list of list into List of pairs
 * Group by source links to destinations links
 * Group by destination links to source links
 * Get ith element from connections
 * Get source and destination of ith connection from connections
 * Apply Depth first search and checked if all the destinations are
 * not visited then check source should be greater than destination
 * If yes then add it to list by flipping source and destination else add pair of source and destination as it as.
 * Finally, return all sources.
 *
 */
    }

    public void DFS(Map<Integer, HashSet<Integer>> adj, int u) {
        visited.put(u, true);
        if (adj.get(u).size() != 0) {
            for (int v : adj.get(u)) {
                if (visited.getOrDefault(v, false) == false) {
                    DFS(adj, v);
                }
            }
        }
    }

    public static void main(String[] args) {
        Amazon am = new Amazon();
        /*ArrayList<ArrayList<Integer>> aar = new ArrayList<>();
        aar.add(new ArrayList(Arrays.asList(1, 2)));
        aar.add(new ArrayList(Arrays.asList(1, 3)));
        aar.add(new ArrayList(Arrays.asList(2, 4)));
        aar.add(new ArrayList(Arrays.asList(3, 4)));
        aar.add(new ArrayList(Arrays.asList(3, 6)));
        aar.add(new ArrayList(Arrays.asList(6, 7)));
        aar.add(new ArrayList(Arrays.asList(4, 5)));*/

        ArrayList<ArrayList<Integer>> aar = new ArrayList<>();
        aar.add(new ArrayList(Arrays.asList(1, 2)));
        aar.add(new ArrayList(Arrays.asList(2, 3)));
        aar.add(new ArrayList(Arrays.asList(3, 4)));
        aar.add(new ArrayList(Arrays.asList(4, 5)));
        aar.add(new ArrayList(Arrays.asList(6, 3)));

        for (int p : am.solution(6, 5, aar)) {
            System.out.println(" " + p);
        }
    }
}

class Pair {

    Pair(int first, int second) {
        this.first = first;
        this.second = second;

    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    int first;

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    int second;
}