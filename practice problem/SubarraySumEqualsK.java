import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixFrequencies = new HashMap<>();
        prefixFrequencies.put(0, 1);
        int currentSum = 0;
        int matchingSubarrays = 0;

        for (int number : nums) {
            currentSum += number;
            matchingSubarrays += prefixFrequencies.getOrDefault(currentSum - k, 0);
            prefixFrequencies.put(currentSum, prefixFrequencies.getOrDefault(currentSum, 0) + 1);
        }
        return matchingSubarrays;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));
    }
}