public class L0033_Search_In_Rotated_Sorted_Array
{
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
        {
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        while(left<right)
        {
            int mid = left + (right-left)/2;
            if(nums[mid]>nums[right])
            {
                left=mid+1;
            }
            else
            {
                right=mid;
            }
        }
        //找到转择点
        int midNum = left;


        if(nums[midNum]>target)
        {
            return -1;
        }
        else if (nums[midNum]==target)
        {
            return midNum;
        }
        else
        {
            //说明在左侧
            if(target>nums[nums.length-1])
            {
                int left1= 0;
                int right1 = midNum-1;

                while(left1<=right1)
                {
                    int midNum1 = left1 + (right1-left1)/2;
                    if(nums[midNum1]==target)
                    {
                        return midNum1;
                    }
                    else if(nums[midNum1]>target)
                    {
                        right1=midNum1-1;
                    }
                    else
                    {
                        left1 = midNum1 +1;
                    }
                }
                return -1;
            }
            else
            {
                int left2= midNum+1;
                int right2=nums.length;
                while(left2<=right2)
                {
                    int midNum2 = left2 + (right2-left2)/2;
                    if(nums[midNum2]==target)
                    {
                        return midNum2;
                    }
                    else if(nums[midNum2]>target)
                    {
                        right2=midNum2-1;
                    }
                    else
                    {
                        left2 = midNum2 +1;
                    }
                }
                return -1;
            }
        }
    }
}
