/*
Name: Laaibah Deedar Ali Motani
Id: Cs231144
Title: DSA LAB PROJECT -> Emergency Travel Plan
*/



import java.util.*;

public class EmergencyTravelPlan {

    public static int findMinimumDays(int cities, List<int[]> aerialRoutes) {
        // Step 1: Build the graph
        Map<Integer, List<Route>> graph = new HashMap<>();
        for (int i = 0; i < cities; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Add aerial routes
        for (int[] route : aerialRoutes) {
            graph.get(route[0]).add(new Route(route[1], "air"));
        }

        // Add road routes (up to 6 cities in one day)
        for (int i = 0; i < cities - 1; i++) {
            for (int j = 1; j <= 6 && i + j < cities; j++) {
                graph.get(i).add(new Route(i + j, "road"));
            }
        }

        // Step 2: Priority queue for BFS
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0)); // Start at city 0 with 0 days

        // Map to track the minimum days to reach each city
        Map<Integer, Integer> minDays = new HashMap<>();
        minDays.put(0, 0);

        int minResult = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            State current = queue.poll();
            int city = current.city;
            int days = current.days;

            // If we reach the destination, update the result
            if (city == cities - 1) {
                minResult = Math.min(minResult, days);
                continue;
            }

            // Explore all neighbors of the current city
            for (Route route : graph.get(city)) {
                int nextCity = route.destination;
                int nextDays = days;

                // For air travel, days remain the same
                if (route.type.equals("air")) {
                    nextDays = days;
                }
                // For road travel, increment days by 1
                else if (route.type.equals("road")) {
                    nextDays = days + 1;
                }

                // Allow revisiting a city if it's through a different path or with fewer days
                if (!minDays.containsKey(nextCity) || nextDays < minDays.get(nextCity)) {
                    minDays.put(nextCity, nextDays);
                    queue.add(new State(nextCity, nextDays));
                }
            }
        }

        return minResult == Integer.MAX_VALUE ? -1 : minResult;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of test cases: ");
        int numCases = scanner.nextInt();

        for (int i = 0; i < numCases; i++) {
            System.out.print("Enter number of cities: ");
            int cities = scanner.nextInt();

            System.out.print("Enter number of aerial routes: ");
            int numAirRoutes = scanner.nextInt();
            List<int[]> aerialRoutes = new ArrayList<>();

            System.out.println("Enter aerial routes (source destination): ");
            for (int j = 0; j < numAirRoutes; j++) {
                int src = scanner.nextInt();
                int dest = scanner.nextInt();
                aerialRoutes.add(new int[]{src, dest});
            }

            // Process each test case
            int result = findMinimumDays(cities, aerialRoutes);

            // Output results
            System.out.println("Minimum days: " + result);
        }

        scanner.close();
    }

    // Helper classes
    static class Route {
        int destination;
        String type;

        Route(int destination, String type) {
            this.destination = destination;
            this.type = type;
        }
    }

    static class State {
        int city;
        int days;

        State(int city, int days) {
            this.city = city;
            this.days = days;
        }
    }
}