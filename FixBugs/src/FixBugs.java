import java.util.Arrays;

public class FixBugs {
    public static void main(String[] args) {
        
        int[] arrayToSort = {5, 2, 9, 1, 5, 6};
        System.out.println("Original Array: " + Arrays.toString(arrayToSort));

        
        quickSort(arrayToSort, 0, arrayToSort.length - 1);

        System.out.println("Sorted Array: " + Arrays.toString(arrayToSort));

        
        int[] sortedArray = {1, 2, 5, 5, 6, 9};
        int targetElement = 6;

        
        int result = binarySearch(sortedArray, targetElement);

        if (result != -1) {
            System.out.println("Element " + targetElement + " found at index " + result);
        } else {
            System.out.println("Element " + targetElement + " not found in the array");
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        
    	
    	 if (low < high) {
             int partitionIndex = partition(arr, low, high);

             // Recursively sort elements before and after partition
             quickSort(arr, low, partitionIndex - 1);
             quickSort(arr, partitionIndex + 1, high);
         }
     }

     private static int partition(int[] arr, int low, int high) {
         int pivot = arr[high];
         int i = low - 1;

         for (int j = low; j < high; j++) {
             if (arr[j] < pivot) {
                 i++;

                 
                 int temp = arr[i];
                 arr[i] = arr[j];
                 arr[j] = temp;
             }
         }

         
         int temp = arr[i + 1];
         arr[i + 1] = arr[high];
         arr[high] = temp;

         return i + 1;
     }
    
   
    	
    	
    		
    	    public static int binarySearch(int[] arr, int target) {
    	        int left = 0;
    	        int right = arr.length - 1;

    	        while (left <= right) {
    	            int mid = left + (right - left) / 2;

    	            if (arr[mid] == target) {
    	                return mid; // Target found
    	            } else if (arr[mid] < target) {
    	                left = mid + 1; // Discard left half
    	            } else {
    	                right = mid - 1; // Discard right half
    	            }
    	        }

    	        return -1; 
    	    }
    	}

    

