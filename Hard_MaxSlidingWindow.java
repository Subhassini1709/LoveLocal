// Given an array of Integers, return the maximum element in every window of given size

import java.util.*;

public class Hard_MaxSlidingWindow {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array: ");
        int size = in.nextInt();

        int[] nums = new int[size];

        System.out.println("\nEnter the array elements: ");
        for (int i = 0; i < size; i++) {
            nums[i] = in.nextInt();
        }
        
        System.out.println("\nEnter the size of the sliding window: ");
        int k = in.nextInt(); //k holds the size of the window

        List<Integer> maxOfEachWindow = findMaxOfEachWindow(nums, size, k);

        System.out.println("\nMax of all sliding windows of size " + k + " is given as follows: ");
        System.out.println(maxOfEachWindow);
        in.close();
    }

    public static List<Integer> findMaxOfEachWindow(int arr[], int n, int k)
    {
        List<Integer> maxOfEachWindow = new ArrayList<>();
        Deque<Integer> window = new ArrayDeque<>(); //window is used to keep track of the index of the possible max values for each window 
        int i; //loop variable
        
        // Processing first k elements
        for(i=0;i<k;i++) {
            while(!window.isEmpty() && arr[i]>=arr[window.peekLast()]) {
                window.removeLast(); //the element at the Last cannot be the max element for any window as the cur element is greater, hence we remove its index
            }
            window.addLast(i); // we add the current element's index as it could be a possible max value for a window
        }
        maxOfEachWindow.add(arr[window.peek()]); //window.peek() gives the index of the max value of the current window
        
        //Processing remaining elements
        for(;i<n;i++) {
            while (!window.isEmpty() && window.peek() <= i - k) {
                window.removeFirst(); //removing the index of the element that has moved out of the window
            }
            /* Performing the same operations as the previous block*/
            while(!window.isEmpty() && arr[i]>=arr[window.peekLast()]) {
                window.removeLast();
            }
            window.addLast(i);
            maxOfEachWindow.add(arr[window.peek()]);
        }
        return maxOfEachWindow;
    }
}

/*

Complexity of the code written:

Time complexity - O(N)
Space complexity - O(K)

*/
