public class LL0153_Find_Minimum_In_Rotated_Sort_Array
{
    public int findMin(int[] nums)
    {
        int left = 0;
        int right = nums.length-1;
        while (left<right)
        {
            int mid = left + (right-left)/2;
            //说明左侧连续递增，可以直接排除该区间
            if(nums[mid]>nums[left])
            {
                left=mid+1;
            }
            else
            {
                right =mid;
            }

        }
        return nums[left];
    }
}
