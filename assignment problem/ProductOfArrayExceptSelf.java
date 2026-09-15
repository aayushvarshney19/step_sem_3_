public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int leftProduct = 1;

        for (int index = 0; index < nums.length; index++) {
            answer[index] = leftProduct;
            leftProduct *= nums[index];
        }

        int rightProduct = 1;
        for (int index = nums.length - 1; index >= 0; index--) {
            answer[index] *= rightProduct;
            rightProduct *= nums[index];
        }
        return answer;
    }

    public static void main(String[] args) {
        printArray(productExceptSelf(new int[]{1, 2, 3, 4}));
        printArray(productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
    }

    private static void printArray(int[] values) {
        System.out.print("[");
        for (int index = 0; index < values.length; index++) {
            if (index > 0) {
                System.out.print(", ");
            }
            System.out.print(values[index]);
        }
        System.out.println("]");
    }
}