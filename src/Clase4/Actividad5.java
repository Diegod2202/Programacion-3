/*package Clase4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Actividad5 {

    public static Map<String, Corredor> mejorTiempoPorCategoria(List<Corredor> runners, int start, int end) {
        if (start == end) {
            Map<String, Corredor> result = new HashMap<>();
            result.put(runners.get(start).categoria, runners.get(start));
            return result;
        }

        int mid = (start + end) / 2;

        Map<String, Runner> leftBest = mejorTiempoPorCategoria(runners, start, mid);
        Map<String, Runner> rightBest = mejorTiempoPorCategoria(runners, mid + 1, end);

        return mergeResults(leftBest, rightBest);
    }

    private static Map<String, Runner> mergeResults(Map<String, Runner> leftBest, Map<String, Runner> rightBest) {
        Map<String, Runner> result = new HashMap<>();

        for (String category : leftBest.keySet()) {
            if (rightBest.containsKey(category)) {
                result.put(category, leftBest.get(category).time < rightBest.get(category).time ? leftBest.get(category) : rightBest.get(category));
            } else {
                result.put(category, leftBest.get(category));
            }
        }

        for (String category : rightBest.keySet()) {
            if (!result.containsKey(category)) {
                result.put(category, rightBest.get(category));
            }
        }

        return result;
    }

    public static <Runner> void main(String[] args) {
        List<Runner> runners = new ArrayList<>();
        runners.add(new Runner("Alice", "Senior", 12.5));
        runners.add(new Runner("Bob", "Junior", 11.3));
        runners.add(new Runner("Charlie", "Senior", 10.8));
        runners.add(new Runner("Diana", "Junior", 12.1));
        runners.add(new Runner("Eve", "Senior", 11.0));

        Map<String, Runner> bestTimes = findBestTimesByCategory(runners, 0, runners.size() - 1);

        for (Map.Entry<String, Runner> entry : bestTimes.entrySet()) {
            System.out.println("Category: " + entry.getKey() + ", Best Runner: " + entry.getValue());
        }
    }

    class Corredor {
        String
    }
}*/