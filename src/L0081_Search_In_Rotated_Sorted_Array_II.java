public class L0081_Search_In_Rotated_Sorted_Array_II
{
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length ==0)
        {
            return false;
        }
        int low = 0;
        int high = nums.length-1;
        int mid=0;

        while(low<=high)
        {
            mid = low + (high-mid)/2 ;
            if(target==nums[mid])
            {
                return true;
            }
            //无法判断那边是有序的
            if(nums[mid]==nums[low])
            {
                low++;
                continue;
            }
            //说明左侧有序
            if(nums[mid]>nums[low])
            {
                //在左侧
                if(target>=nums[low] && target<nums[mid])
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            else
            {
                //说明右侧有序
                //target在右侧
                if(target>nums[mid] && target<=nums[high])
                {
                    low =mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
        }
        return false;
    }
}
