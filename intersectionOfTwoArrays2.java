//approach1: using hashmap
//time complextity: O(m+n) where m and n are the lengths of the larger and smaller arrays
//space complexity: O(m) ; in worst case larger may have all distinct numbers
//approach: add all elements of larger array to a hashmap alongwith count.
// iterate over smaller array and then for every element found in hm, replace nums[k++] where k is initialized at 0 with the current element. reduce the count of the element by one in the hm
/**
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null) return new int[0];
        if(nums1.length<nums2.length) return intersect(nums2,nums1);
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i : nums1) map.put(i,map.getOrDefault(i,0)+1);
        int k=0;
        for(int i: nums2)
        {
            if(map.containsKey(i) && map.get(i)>0) //if >0 is not checked, we will be counting element as common even when its not sort of not present anymore for consideration
            {
                nums1[k++] = i;
                map.put(i,map.get(i)-1);
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }
}
**/

//using hashmap, we can store the elements from the smaller array to save on space
//time complexity : O(m+n)
//space complexity: O(n) where n is the size of the smaller array
/**
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null) return new int[0];
        if(nums1.length>nums2.length) return intersect(nums2,nums1);
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i : nums1) map.put(i,map.getOrDefault(i,0)+1);
        int k=0;
        for(int i: nums2)
        {
            if(map.containsKey(i) && map.get(i)>0)
            {
                nums1[k++] = i;
                map.put(i,map.get(i)-1);
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }
}

**/

//using sort

//time complexity: O(logm + logn)
//space complexity: O(1)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0; int j=0; int k=0;
        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i]<nums2[j]) i++;
            else if(nums1[i]>nums2[j]) j++;
            else
            {
                nums1[k++] = nums2[j];
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }
}


