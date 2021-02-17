import java.util.Arrays;

public class TwoSum {

    public int[] twoSum (int[] num, int sum) {
        int[] indices = new int[2]; //int array used to store indices if solution if found

        for (int i = 0; i < num.length; i++) { //nested for loop to increment through the array
            for (int j = i+1; j < num.length; j++) {
                if (num[i] + num[j] == sum) { //if the two numbers added equal the target sum, it will store the indices
                    indices[0] = i;
                    indices[1] = j;
                    return indices; //returns the indices
                }
            }
        }
        return new int[]{-1}; //if no solution is found, will return -1
    }

    int[] search (int [] num, int target) {
        int[] indices = new int[2]; //int array used to store indices if solution is found
        int store; //used to swap numbers when sorting
        int low;
        int high;
        int x; //the number we are looking for in the array

        for (int i = 0; i < num.length; i++) { //bubble sorting algorithm
            for (int j = 1; j < num.length; j++) {
                if (num[j] < num[j-1]) {
                    store = num[j];
                    num[j] = num[j-1];
                    num[j-1] = store;
                }
            }
        }
        System.out.println("Sorted Array: " + Arrays.toString(num)); //for debugging sort

        for (int i = 0; i < num.length - 1; i++) { //binary search begins here
            x = target - num[i]; //sets the second number we are adding to get the target
            high = num.length - 1;
            low = i + 1; //do binary search
            while (low <= high) {
                int mid = (low + high) / 2;
                if (num[mid] == x) { //if solution found, stores and returns indices
                    indices[0] = i;
                    indices[1] = mid;
                    return indices;
                }
                else if (num[mid] < x) { //if middle less than x, sets new low to middle+1
                    low = mid + 1;
                }
                else if (num[mid] > x) { //if middle greater than x, sets new high to middle-1
                    high = mid - 1;
                }
            }
        }
        return new int[]{-1}; //returns -1 if no solution is found
    }

    public static void main(String[] args) {
        TwoSum bruteForce = new TwoSum(); //instancing class into object
        System.out.println(Arrays.toString(bruteForce.twoSum(new int[]{1, 4, 5, 10}, 10))); //Brute force method of linear search :)
        System.out.println("Indices of sorted array: " + Arrays.toString(bruteForce.search(new int[]{14, 12, 10, 2, 1}, 16))); //Recommendation #2 with binary search :)
    }
}