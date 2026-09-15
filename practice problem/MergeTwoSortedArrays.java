public class MergeTwoSortedArrays {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int first = 0;
        int second = 0;
        int mergedIndex = 0;

        while (first < arr1.length && second < arr2.length) {
            if (arr1[first] <= arr2[second]) {
                merged[mergedIndex++] = arr1[first++];
            } else {
                merged[mergedIndex++] = arr2[second++];
            }
        }

        while (first < arr1.length) {
            merged[mergedIndex++] = arr1[first++];
        }
        while (second < arr2.length) {
            merged[mergedIndex++] = arr2[second++];
        }
        return merged;
    }

    public static void main(String[] args) {
        int[] merged = mergeSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6});
        printArray(merged);
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