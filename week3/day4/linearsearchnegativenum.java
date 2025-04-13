public class FirstNegativeFinder {


   public static int findFirstNegative(int[] arr) {
       for (int i = 0; i < arr.length; i++) {
           if (arr[i] < 0) {
               return i;
           }
       }
       return -1;
   }


   public static void main(String[] args) {
       int[] array = {5, 7, 3, -2, 8, -9};


       int index = findFirstNegative(array);


       if (index != -1) {
           System.out.println("First negative number found at index: " + index);
       } else {
           System.out.println("No negative number found in the array.");
       }
   }
}

