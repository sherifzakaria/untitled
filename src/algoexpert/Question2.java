package algoexpert;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question2 {
    public static void main(String[] args) {

    }

    public static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
//        Map<String, Integer> scoreboard = new HashMap<>();
        // Write your code here.
//        competitions.forEach(competition -> competition.forEach(team -> {
//            scoreboard.putIfAbsent(team, 0);
//        }));

//        competitions.stream().flatMap(Collection::stream).distinct().forEach(team -> scoreboard.put(team, 0));

        ConcurrentMap<String, Integer> scoreboard = competitions.stream().flatMap(Collection::stream).distinct()
                .collect(Collectors.toConcurrentMap(k -> k, v -> 0));

        IntStream.range(0, competitions.size()).forEach(index -> {
            if (results.get(index) == 0) {
                String key = competitions.get(index).get(1);
                Integer val = scoreboard.get(key);
                scoreboard.put(key, val + 1);
            } else {
                String key = competitions.get(index).get(0);
                Integer val = scoreboard.get(key);
                scoreboard.put(key, val + 1);
            }
        });

        return Collections.max(scoreboard.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }
}
