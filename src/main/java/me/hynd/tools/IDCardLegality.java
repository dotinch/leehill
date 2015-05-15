package me.hynd.tools;

import com.google.common.base.Splitter;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;

/**
 * 校验码：是根据前面十七位数字码，按照ISO 7064:1983.MOD 11-2校验码计算出来的检验码。
 关于身份证号码最后一位的校验码的算法如下：

 ∑(a[i]*W[i]) mod 11 ( i = 2, 3, ..., 18 )

 　 　"*" ： 表示乘号
 　　   i：  表示身份证号码每一位的序号，从右至左，最左侧为18，最右侧为1。
 　　a[i]： 表示身份证号码第 i 位上的号码
 　　W[i]： 表示第 i 位上的权值 W[i] = 2^(i-1) mod 11
 　　设：R = ∑(a[i]*W[i]) mod 11 ( i = 2, 3, ..., 18 )
 　　C = 身份证号码的校验码
 　　则R和C之间的对应关系如下表：
 　　　R：0 1 2 3 4 5 6 7 8 9 10
 　　　C：1 0 X 9 8 7 6 5 4 3 2
 　　由此看出 X 就是 10，罗马数字中的 10 就是X，所以在新标准的身份证号码中可能含有非数字的字母X。
 */
public class IDCardLegality {

    //private static int[] R = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static char[] C = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
    private static int[] W = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    public static boolean valid(String IDCardNum) {

        int sum = 0;
        for (int i = 0; i < 17; i++) {
            sum += Integer.valueOf(String.valueOf(IDCardNum.charAt(i))) * W[i];
        }

        int r = IntMath.mod(sum, 11);

        System.out.println("校验位：" + r);
        System.out.println("校验码：" + C[r]);

        // 校验码合法
        if(C[r] == IDCardNum.charAt(17)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String idCardNum = "12345678901234567X";

//        for (int i = 17; i > 0; i--) {
//            System.out.print(IntMath.mod(IntMath.pow(2, i), 11) + ", ");
//        }
//
//        System.out.println();

        System.out.println(IDCardLegality.valid(idCardNum));
    }


}
