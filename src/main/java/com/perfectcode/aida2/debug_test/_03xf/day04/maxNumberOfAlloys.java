package com.perfectcode.aida2.debug_test._03xf.day04;

import java.util.Collections;
import java.util.List;

/**
 * 2861.最大合金数
 * 1.二分答案要注意初始上下边界怎么算
 * 2.循环不变式要写清楚
 * 3.注意long类型
 */

public class maxNumberOfAlloys {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int ans = 0;
        int mx = Collections.min(stock)+budget;
        for (List<Integer> com : composition){
            int left = ans;
            int right = mx+1;
            while(left+1<right){
                int mid = left+(right-left)/2;
                //判断是否需要额外购买材料
                boolean ok = true;
                long money = 0;
                for (int i = 0; i < n; i++) {
                    //计算生产mid个合金需要的数量
                    long tmp = (long)com.get(i)*mid-stock.get(i);
                    //大于0说明需要额外购买
                    if (tmp>0){
                        //需要的金钱
                        money += tmp*cost.get(i);
                        if (money>budget){
                            ok = false;
                            break;
                        }
                    }
                }
                if(ok) {
                    left = mid;
                }else {
                    right = mid;
                }
            }
            ans=left;
        }
        return ans;

    }
}
