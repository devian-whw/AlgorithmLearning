package com.bj.mt.wwh.leetcode;

/**
 * @author wangwenhao06@meituan.com
 * @create 2020-07-01 下午8:41
 * LeetCode 260
 **/
public class SingleNumberIII {
    /**
     * 正数：原码表示
     * 负数：补码（原码取反加1）
     * 方式二：异或 + &  如果异或还不太懂的可以先看下相关的几个题目先把异或搞懂先
     * 第一步：所有数异或，所有数异或之后的值就是两个只出现一次的数a,b异或后的值s。
     * 第二步：那我们用s & (-s) 可以得出s最低位(也就是最右边)为1的bit位(这个操作不太会事先知道)对应的数k，
     * 这里有一个很关键点就是：这个为1的bit位肯定只来之a.b其中的一个数字中的对应二进制位的1，这里有点卡主理解，比如我们把数字转成二进制运算看下：
     * a：1 -> 0001
     * b：2 -> 0010  => 0011. 不全为1的bit为进行异或操作就为1，这是异或的基本流程，然后我们操作s & (-s)之后得到的是0001，可以看到这个1是来之数字a的
     * 第三步：我们得到s&(-s)之后在对所有数进行&操作的话，就意味着可以将a和b区分在0和1的两个组，至于其他的数字如果相同的数字自然会分到一个组，可以用纸笔写下整个过程
     * 第四步：经过第三步之后就变成了只有一个数字存在一个其他都存在两个的数组(也就变成题目：136. 只出现一次的数字)，
     * 然后我们分别对两个组的所有数字再进行异或之后不就得到了要求的那两个数了嘛
     * 思路就是找出两个都只有单个的数字异或后为1的位，再根据该位的0跟1将数据分为两组，在两组内分别异或就能得到两组内的单个数字
     *
     * @param nums
     * @return
     */
    public static int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        if (null == nums || nums.length <= 0) {
            return res;
        }

        int s = 0;
        for (int num : nums) {
            s ^= num;
        }
        int k = s & (-s);

        for (int num : nums) {
            if ((num & k) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
