import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    HashMap<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> journey = new ArrayList<>();
    boolean found = false;

    public List<String> findItinerary(List<List<String>> tickets) {

        for (int i = 0; i < tickets.size(); ++i) {
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);

            PriorityQueue<String> value = map.getOrDefault(from, new PriorityQueue<>());
            value.add(to);

            map.put(from, value);
        }

        search("JFK");

        return journey.reversed();
    }

    public void search(String currentPlace) {

        PriorityQueue<String> pq = map.get(currentPlace);

        while (pq != null && !pq.isEmpty()) {

            String place = pq.poll();

            search(place);
        }

        journey.add(currentPlace);
    }
}