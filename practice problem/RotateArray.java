public class RotateArray {
    public static int[] rotateArray(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        k = k % nums.length;
        if (k < 0) {
            k += nums.length;
        }

        int[] rotated = new int[nums.length];
        for (int index = 0; index < nums.length; index++) {
            rotated[(index + k) % nums.length] = nums[index];
        }
        return rotated;
    }

    public static void main(String[] args) {
        int[] rotated = rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        System.out.print("[");
        for (int index = 0; index < rotated.length; index++) {
            if (index > 0) {
                System.out.print(", ");
            }
            System.out.print(rotated[index]);
        }
        System.out.println("]");
    }
}