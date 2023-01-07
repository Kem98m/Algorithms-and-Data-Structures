import java.util.*;

public class ErdosNumber {
    TreeMap<String, Set<String>> myGraph;
    TreeMap<String, Integer> myDistance;

    public String[] calculateNumbers(String[] pubs) {
        makeGraph(pubs);
        ArrayList<String> list = new ArrayList<>();
        bfsErdos();
        for (String str : myGraph.keySet()) {
            if (myDistance.containsKey(str)) {
                str = str + " " + myDistance.get(str);
            }
            list.add(str);
        }
        return list.toArray(new String[0]);
    }
    // uses myDistance
    private Set<String> bfsErdos() {
        Set<String> visited = new TreeSet<>();
        Queue<String> qp = new LinkedList<>();
        String str = "ERDOS";
        visited.add(str);
        qp.add(str);
        // (0) code here for myDistance
        while (qp.size() > 0) {
            str = qp.remove();
            // (1) code here using myDistance
            for (String adj : myGraph.get(str)) {
                if (! visited.contains(adj)) {
                    visited.add(adj);
                    qp.add(adj);
                    // (2) code here using myDistance
                }
            }
        }
        return visited;
    }

    // Use Queue (BFS)
    // Alon, <Kleitman>
    // Dean, <Kleitman, Wayne, Goddard, Sturtevant>
    private void makeGraph(String[] pubs) {
        for (String s : pubs) {
            String[] names =  s.split(" ");

            for (String t: names) {
                //myGraph.putIfAbsent(t, )
            }

        }
    }
}