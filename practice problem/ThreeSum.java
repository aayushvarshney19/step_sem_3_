import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> triplets = new ArrayList<>();

        for (int first = 0; first < nums.length - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            if (nums[first] > 0) {
                break;
            }

            int left = first + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[first] + nums[left] + nums[right];
                if (sum == 0) {
                    triplets.add(new int[]{nums[first], nums[left], nums[right]});
                    int leftValue = nums[left];
                    int rightValue = nums[right];
                    while (left < right && nums[left] == leftValue) {
                        left++;
                    }
                    while (left < right && nums[right] == rightValue) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplets.toArray(new int[triplets.size()][]);
    }

    public static void main(String[] args) {
        printTriplets(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        printTriplets(threeSum(new int[]{0, 0, 0}));
    }

    private static void printTriplets(int[][] triplets) {
        System.out.print("[");
        for (int row = 0; row < triplets.length; row++) {
            if (row > 0) {
                System.out.print(", ");
            }
            System.out.print("[" + triplets[row][0] + ", " + triplets[row][1] + ", " + triplets[row][2] + "]");
        }
        System.out.println("]");
    }
}