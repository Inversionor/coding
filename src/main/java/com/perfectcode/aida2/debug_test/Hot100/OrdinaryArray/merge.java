package com.perfectcode.aida2.debug_test.Hot100.OrdinaryArray;

/**
 * @Author: lzj
 * @Date: 2024/10/18 14:47
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 * 思路：先排序，然后将初始的数组放入到ans中，同时遍历二维数组，用left和right指向intervals的左右，然后比较left和
 * ans中最后一个元素的右边界，如果大于则更新，同时i++；如果不大于，则添加进入ans
 */
public class merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length==0){
            return new int[0][2];
        }
        Arrays.sort(intervals, (v1, v2)->Integer.compare(v1[0],v2[0]));
        List<int[]> ans=new ArrayList<int[]>();
        ans.add(intervals[0]);
        int index=0;
        for(int i=1;i<intervals.length;i++){
            int left=intervals[i][0];
            int right=intervals[i][1];
            while(i<intervals.length&&ans.get(index)[1]>=intervals[i][0]){
                ans.get(index)[1]=intervals[i][1];
                i++;
            }
            ans.add(new int[]{left,right});
            index++;
        }
        return ans.toArray(new int[ans.size()][]);

    }
    public static void main(String[] args) {
        int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        merge merge = new merge();
        int[][] ans = merge.merge(intervals);
        for (int[] an : ans) {
            System.out.println(an[0]+" "+an[1]);
        }
    }
}
