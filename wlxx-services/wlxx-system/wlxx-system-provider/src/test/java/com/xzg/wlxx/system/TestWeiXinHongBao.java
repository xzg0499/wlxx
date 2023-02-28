package com.xzg.wlxx.system;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * 微信红包算法
 *
 * @author xzgan
 * @since 2022/9/21
 */
public class TestWeiXinHongBao {

    @Test
    public void test() {
        // 初始化测试场景
        BigDecimal[][] rrr = {
                {new BigDecimal("0.1"), new BigDecimal("10")},
                {new BigDecimal("1"), new BigDecimal("10")},
                {new BigDecimal("100"), new BigDecimal("10")},
                {new BigDecimal("1000"), new BigDecimal("10")}
        };
        BigDecimal min = new BigDecimal("0.01");
        // 测试个场景
        for (BigDecimal[] decimals : rrr) {
            final BigDecimal amount = decimals[0];
            final BigDecimal num = decimals[1];
            System.out.println(amount + "元" + num + "个人抢=======================================================");
            test2(amount, min, num);
        }
    }

    /**
     * 剩余金额随机法
     *
     * @param amount
     * @param min
     * @param num
     */
    private static void test1(BigDecimal amount, BigDecimal min, BigDecimal num) {
        BigDecimal remain = amount.subtract(min.multiply(num));
        final Random random = new Random();
        final BigDecimal hundred = new BigDecimal("100");
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal redpeck;
        for (int i = 0; i < num.intValue(); i++) {
            final int nextInt = random.nextInt(100);
            if (i == num.intValue() - 1) {
                redpeck = remain;
            } else {
                redpeck = new BigDecimal(nextInt).multiply(remain).divide(hundred, 2, RoundingMode.FLOOR);
            }
            if (remain.compareTo(redpeck) > 0) {
                remain = remain.subtract(redpeck);
            } else {
                remain = BigDecimal.ZERO;
            }
            sum = sum.add(min.add(redpeck));
            System.out.println("第" + (i + 1) + "个人抢到红包金额为：" + min.add(redpeck));
        }
        System.out.println("校验每个红包累计额度是否等于红包总额结果：" + (amount.compareTo(sum) == 0));
    }

    /**
     * 二倍均值法(微信红包采用此法)
     *
     * @param amount
     * @param min
     * @param num
     */
    private static void test2(BigDecimal amount, BigDecimal min, BigDecimal num) {
        BigDecimal remain = amount.subtract(min.multiply(num));
        final Random random = new Random();
        final BigDecimal hundred = new BigDecimal("100");
        final BigDecimal two = new BigDecimal("2");
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal redpeck;
        for (int i = 0; i < num.intValue(); i++) {
            final int nextInt = random.nextInt(100);
            if (i == num.intValue() - 1) {
                redpeck = remain;
            } else {
                redpeck = new BigDecimal(nextInt).multiply(remain.multiply(two).divide(num.subtract(new BigDecimal(i)), 2, RoundingMode.CEILING)).divide(hundred, 2, RoundingMode.FLOOR);
            }
            if (remain.compareTo(redpeck) > 0) {
                remain = remain.subtract(redpeck);
            } else {
                remain = BigDecimal.ZERO;
            }
            sum = sum.add(min.add(redpeck));
            System.out.println("第" + (i + 1) + "个人抢到红包金额为：" + min.add(redpeck));
        }
        System.out.println("校验每个红包累计额度是否等于红包总额结果：" + amount.compareTo(sum));
    }

    
    /**
     * 整体随机法
     *
     * @param amount
     * @param min
     * @param num
     */
    private static void test3(BigDecimal amount, BigDecimal min, BigDecimal num) {
        final Random random = new Random();
        final int[] rand = new int[num.intValue()];
        BigDecimal sum1 = BigDecimal.ZERO;
        BigDecimal redpeck;
        int sum = 0;
        for (int i = 0; i < num.intValue(); i++) {
            rand[i] = random.nextInt(100);
            sum += rand[i];
        }
        final BigDecimal bigDecimal = new BigDecimal(sum);
        BigDecimal remain = amount.subtract(min.multiply(num));
        for (int i = 0; i < rand.length; i++) {
            if (i == num.intValue() - 1) {
                redpeck = remain;
            } else {
                redpeck = remain.multiply(new BigDecimal(rand[i])).divide(bigDecimal, 2, RoundingMode.FLOOR);
            }
            if (remain.compareTo(redpeck) > 0) {
                remain = remain.subtract(redpeck);
            } else {
                remain = BigDecimal.ZERO;
            }
            sum1 = sum1.add(min.add(redpeck));
            System.out.println("第" + (i + 1) + "个人抢到红包金额为：" + min.add(redpeck));
        }

        System.out.println("校验每个红包累计额度是否等于红包总额结果：" + (amount.compareTo(sum1) == 0));
    }


    /**
     * 割线法
     *
     * @param amount
     * @param min
     * @param num
     */
    private static void test4(BigDecimal amount, BigDecimal min, BigDecimal num) {
        final Random random = new Random();
        final int[] rand = new int[num.intValue()];
        BigDecimal sum1 = BigDecimal.ZERO;
        BigDecimal redpeck;
        int sum = 0;
        for (int i = 0; i < num.intValue(); i++) {
            rand[i] = random.nextInt(100);
            sum += rand[i];
        }
        final BigDecimal bigDecimal = new BigDecimal(sum);
        BigDecimal remain = amount.subtract(min.multiply(num));
        for (int i = 0; i < rand.length; i++) {
            if (i == num.intValue() - 1) {
                redpeck = remain;
            } else {
                redpeck = remain.multiply(new BigDecimal(rand[i])).divide(bigDecimal, 2, RoundingMode.FLOOR);
            }
            if (remain.compareTo(redpeck) > 0) {
                remain = remain.subtract(redpeck);
            } else {
                remain = BigDecimal.ZERO;
            }
            sum1 = sum1.add(min.add(redpeck));
            System.out.println("第" + (i + 1) + "个人抢到红包金额为：" + min.add(redpeck));
        }

        System.out.println("校验每个红包累计额度是否等于红包总额结果：" + (amount.compareTo(sum1) == 0));
    }
}
