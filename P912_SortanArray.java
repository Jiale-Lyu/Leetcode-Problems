package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/10/2023.
 */
public class P912_SortanArray {

    /*
    * 各种排序总结:
    * https://leetcode.cn/problems/sort-an-array/solutions/742736/912-pai-xu-shu-zu-ji-chu-pai-xu-suan-fa-1qt5f/?q=%E5%BD%92%E5%B9%B6&orderBy=most_votes&languageTags=java
    * */

    /*
    * 选择排序，每一轮选最小的数交换到未排定的数头部
    * 两个for循环，i: [0, len-1), j：[i+1, len),内层循环结束交换min和i
    * time: O(n^2)
    * space: O(1)
    * 算法思想 1：贪心算法：每一次决策只看当前，当前最优，则全局最优。注意：这种思想不是任何时候都适用。
        算法思想 2：减治思想：外层循环每一次都能排定一个元素，问题的规模逐渐减少，直到全部解决，即「大而化小，小而化了」。运用「减治思想」很典型的算法就是大名鼎鼎的「二分查找」。
        优点：交换次数最少。
        「选择排序」看起来好像最没有用，但是如果在交换成本较高的排序任务中，就可以使用「选择排序」
    * */

    class Solution {
        public int[] sortArray(int[] nums) {
            int len = nums.length;
            //保证[0,i)有序，区间里所有的元素是排完序的样子
            for(int i = 0; i < len - 1; i++){
                int minIndex = i;
                //选择区间[i, len-1]中最小的数交换到i的位置
                for(int j = i + 1; j < len; j++){
                    if(nums[j] < nums[minIndex]){
                        minIndex = j;
                    }
                }
                swap(nums, minIndex, i);
            }
            return nums;

        }
        public void swap(int[] nums, int a, int b){
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
        //每一轮选最大的放最后
//        public int[] sortArray(int[] nums) {
//            int len = nums.length;
//            for(int i = len - 1; i > 0; i--){
//                int maxIndex = i;
//                for(int j = 0; j < i; j++){
//                    if(nums[j] > nums[maxIndex]){
//                        maxIndex = j;
//                    }
//                }
//                swap(nums, maxIndex, i);
//            }
//            return nums;
//
//        }
    }


    /*
    * 插入排序
    * time: O(n^2)
    * space: O(1)
    * 两层循环，外层for循环[1,len),内层while从i-1往前循环，大于i就向后挪位置
    * 特点：「插入排序」可以提前终止内层循环（体现在 nums[j] > temp 不满足时），在数组「几乎有序」的前提下，「插入排序」的时间复杂度可以达到 O(N);
        由于「插入排序」在「几乎有序」的数组上表现良好，特别地，在「短数组」上的表现也很好。因为「短数组」的特点是：每个元素离它最终排定的位置都不会太远。为此，在小区间内执行排序任务的时候，可以转向使用「插入排序」。
    *
    * */
    class Solution2 {
        public int[] sortArray(int[] nums) {
            int len = nums.length;
            //循环不变量：将nums[i]插入到[0,i)使之有序
            //i从第二个数循环到最后一个数
            for(int i = 1; i < len; i++){
                //暂存这个数，前面的数逐个后移，腾出空位
                int tmp = nums[i];
                //j是i之前的数，从后往前遍历有序数组
                int j = i - 1;
                while(j >= 0 && nums[j] > tmp){
                    nums[j + 1] = nums[j];
                    j--;
                }
                nums[j + 1] = tmp;
            }
            return nums;
        }
    }

    /*
    * 归并排序MergeSort
    * 跟快排一样也利用了分治思想
    * mergeSort方法：
        1. 将数组nums分成左边一半和右边一半，两边分别排序
        2. 将已排序好的左边一半和右边一半合并
    * mergeTwoArrays方法：
        建立一个临时数组tmp用于存储排序后的数组分片
        进入循环，分别从两个数组分片的头部开始遍历，比较大小，加到tmp中
        两个数组分片未必完全等分，所以在循环完成后将剩余的值也加到tmp中
        将tmp的值依次替换原本nums的对应位置的值
    *
    * time: O(nlogn)
    * space: O(n)
    * */
    class Solution3 {
        public int[] sortArray(int[] nums) {
            mergeSort(nums, 0, nums.length-1);
            return nums;
        }
        public void mergeSort(int[] nums, int low, int high){
            if(high > low){
                int mid = low + (high - low) / 2;
                mergeSort(nums, low, mid);
                mergeSort(nums, mid + 1, high);
                mergeTwoArray(nums, low, high, mid);
            }
        }
        public void mergeTwoArray(int[] nums, int low, int high, int mid){
            int[] tmp = new int[high - low + 1];
            int i = low, j = mid + 1, k = 0;
            while(i <= mid && j <= high){
                if(nums[i] < nums[j]){
                    tmp[k++] = nums[i++];
                }else{
                    tmp[k++] = nums[j++];
                }
            }
            while(i <= mid){
                tmp[k++] = nums[i++];
            }
            while(j <= high){
                tmp[k++] = nums[j++];
            }
            for(int index = 0; index < k; index++){
                nums[index + low] = tmp[index];
            }
        }
    }

    /*
    * 快速排序
    * 快慢双指针+分治（递归）
    * 随即找一个值，比他小的放左边，比他大的放右边，再分别对左右区间进行递归
    * */
    class Solution4 {
        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }
        public void quickSort(int[] nums, int low, int high){
            if(low < high){
                int mid = partition(nums, low, high);
                quickSort(nums, low, mid - 1); //mid左边都是比它小的数
                quickSort(nums, mid + 1, high); //mid右边都是比它大的数
            }
        }
        public int partition(int[] nums, int low, int high){
            int pivot = low + (int)(Math.random() * (high - low + 1)); //Math.Random()返回的是double型的[0，1）随机数
            swap(nums, low, pivot); //随机数放到low
            int i = low, j = low + 1; //i和左边都是比pivot小的数，j从第二个数遍历到最后一个数
            while(j <= high){
                if(nums[j] < nums[low]){ //如果nums[j]小于pivot,i前进一步并把小的数交换过来
                    swap(nums, ++i, j);
                }
                j++; //否则j前进一步
            }
            swap(nums, i, low);//此时i之前都是小数，i之后都是大数，pivot和nums[i]交换之后，pivot的位置就是排完序后它应该在的位置
            return i;
        }

        public void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    /*
    * 堆排序
    * 建堆+排序
    * 1. 建堆：从最后一个父节点向前heapify O(N)
    * 2. 排序：交换根节点和最后一个节点，heapify根节点
    * heapify维护大根堆：和左右孩子比较，大的上去小的下来，再递归维护 O(logN)
    * time：O(NlogN)
    * space: O(1)
    * */
    class Solution5 {
        public int[] sortArray(int[] nums) {
            int n = nums.length;
            //建堆：从最后一个父节点向前heapify
            for(int i = n / 2 - 1; i >= 0; i--){
                heapify(nums, i, n);
            }
            //排序：交换根节点和最后一个节点，heapify根节点
            for(int i = n - 1; i > 0; i--){
                swap(nums, 0, i);
                heapify(nums, 0, i);
            }
            return nums;
        }
        //维护大根堆：和左右孩子比较，大的上去小的下来，再递归维护
        public void heapify(int[] nums, int i, int n){
            int largest = i;
            int lson = i * 2 + 1;
            int rson = i * 2 + 2;
            if(lson < n && nums[lson] > nums[largest]){
                largest = lson;
            }
            if(rson < n && nums[rson] > nums[largest]){
                largest = rson;
            }
            if(largest != i){
                swap(nums, largest, i);
                heapify(nums, largest, n);
            }
        }
        public void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}


