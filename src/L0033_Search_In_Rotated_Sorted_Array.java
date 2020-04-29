public class L0033_Search_In_Rotated_Sorted_Array
{
    public int search(int[] nums, int target)
    {
        int l = 0;
        int r = nums.length-1;
        int mid ;

        while (l<=r)
        {
            mid = l+(r-l)/2;
            if(target == nums[mid])
            {
                return mid;
            }

            ////说明左侧有序
            if(nums[mid]>=nums[l])
            {
                //target在左侧区间内
                if(target>=nums[l] && target<nums[mid])
                {
                    r = mid-1;
                }
                //target在右侧区间内
                else
                {
                    l= mid+1;
                }
            }
            else
            {
                //target在右侧区间内
                if(target>nums[mid] && target<=nums[r])
                {
                    l=mid+1;
                }
                else
                {
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}
