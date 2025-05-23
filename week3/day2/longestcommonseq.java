import java.util.HashMap;
import java.util.Map;
public class TwoSum {
   public static int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> map = new HashMap<>(); // value -> index


       for (int i = 0; i < nums.length; i++) {
           int complement = target - nums[i];


           if (map.containsKey(complement)) {
               return new int[]{map.get(complement), i}; // Found the pair
           }


           map.put(nums[i], i);
       }
       return new int[]{-1, -1};
   }


   public static void main(String[] args) {
       int[] nums = {2, 7, 11, 15};
       int target = 9;
       int[] result = twoSum(nums, target);
       System.out.println("Indices: " + result[0] + ", " + result[1]);
       System.out.println("Values: " + nums[result[0]] + ", " + nums[result[1]]);
   }
}
