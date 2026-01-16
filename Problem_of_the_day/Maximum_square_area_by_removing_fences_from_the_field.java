/**
 * Title: Maximum Square Area by Removing Fences
 *
 * Approach:
 * 1. A square can be formed only if there exists a horizontal distance and
 *    a vertical distance that are equal.
 * 2. Add the boundary fences (1 and m / n) to the given fence arrays
 *    to account for the outer edges.
 * 3. Generate all possible distances between every pair of horizontal fences.
 * 4. Generate all possible distances between every pair of vertical fences.
 * 5. Find the maximum distance that exists in both horizontal and vertical
 *    distance sets.
 * 6. If such a distance exists, return its square modulo 1e9+7.
 *    Otherwise, return -1.
 *
 * Time Complexity:
 * O(H² + V²)
 * - H = number of horizontal fences
 * - V = number of vertical fences
 * - Computing all pairwise distances dominates the runtime.
 *
 * Space Complexity:
 * O(H² + V²)
 * - Stores all possible distances in hash sets.
 */

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final long MOD = 1_000_000_007;

        Set<Long> hDistances = getAllDistances(hFences, m);
        Set<Long> vDistances = getAllDistances(vFences, n);

        long maxSide = -1;
        for (long dist : hDistances) {
            if (vDistances.contains(dist)) {
                maxSide = Math.max(maxSide, dist);
            }
        }

        return maxSide == -1 ? -1 : (int) ((maxSide * maxSide) % MOD);
    }

    private Set<Long> getAllDistances(int[] fences, int boundary) {
        List<Long> allFences = new ArrayList<>();
        allFences.add(1L);
        allFences.add((long) boundary);

        for (int fence : fences) {
            allFences.add((long) fence);
        }

        Collections.sort(allFences);
        Set<Long> distances = new HashSet<>();

        for (int i = 0; i < allFences.size(); i++) {
            for (int j = i + 1; j < allFences.size(); j++) {
                distances.add(allFences.get(j) - allFences.get(i));
            }
        }

        return distances;
    }
}