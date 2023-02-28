package com.xzg.wlxx.core.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.org.util
 * @date 2022/11/15 16:12
 */
@Deprecated
public class RandomCodeUtils {
    /**
     * 字母类型：小写
     */
    public static final int LETTER_TYPE_LOWER = -1;
    /**
     * 字母类型：大小写混合
     */
    public static final int LETTER_TYPE_MIXED = 0;
    /**
     * 字母类型：大写
     */
    public static final int LETTER_TYPE_UPPER = 1;

    /**
     * 生成随机整型数字
     *
     * @param num       个数
     * @param minNumber 最小值
     * @param maxNumber 最大值
     * @return 整型数字List
     */
    public static List<Integer> generateRandomIntNumber(int num, int minNumber, int maxNumber) {
        List<Integer> data = new ArrayList<>();
        for (int n = 0; n < num; n++) {
            data.add((int) (Math.random() * (maxNumber - minNumber + 1) + minNumber));
        }
        return data;
    }

    /**
     * 生成随机数字码
     *
     * @param num 个数
     * @param len 长度
     * @return 随机数字码List
     */
    public static List<String> generateRandomNumberCodes(int num, int len) {
        List<String> data = new ArrayList<>();

        for (int n = 0; n < num; n++) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < len; i++) {
                result.append((int) (Math.random() * 10));
            }
            data.add(result.toString());
        }

        return data;
    }

    /**
     * 生成随机字母码
     *
     * @param num 个数
     * @param len 长度
     * @return 随机字母码List
     */
    public static List<String> generateRandomLetterCodes(int num, int len, int letterType) {
        List<String> data = new ArrayList<>();

        for (int n = 0; n < num; n++) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < len; i++) {
                // 生成随机数（0~2）
                int rand = (int) (Math.random() * 2);

                // 检查随机数
                if (rand == 0) { // 生成小写字母
                    result.append((char) (int) (Math.random() * 26 + 97));
                } else if (rand == 1) { // 生成大写字母
                    result.append((char) (int) (Math.random() * 26 + 65));
                } else {
                    continue;
                }
            }

            // 检查字母类型
            if (letterType == LETTER_TYPE_UPPER) {
                data.add(result.toString().toUpperCase());
            } else if (letterType == LETTER_TYPE_LOWER) {
                data.add(result.toString().toLowerCase());
            } else {
                data.add(result.toString());
            }
        }

        return data;
    }

    /**
     * 生成随机码
     *
     * @param num        个数
     * @param len        长度
     * @param letterType 字母类型
     * @return 随机码List
     */
    public static List<String> generateRandomCodes(int num, int len, int letterType) {
        List<String> data = new ArrayList<>();

        for (int n = 0; n < num; n++) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < len; i++) {
                // 生成随机数（0~2）
                int rand = (int) (Math.random() * 3);

                // 检查随机数
                if (rand == 0) { // 生成数字
                    result.append((int) (Math.random() * 10));
                } else if (rand == 1) { // 生成小写字母
                    result.append((char) (int) (Math.random() * 26 + 97));
                } else if (rand == 2) { // 生成大写字母
                    result.append((char) (int) (Math.random() * 26 + 65));
                } else {
                    continue;
                }
            }

            // 检查字母类型
            if (letterType == LETTER_TYPE_UPPER) {
                data.add(result.toString().toUpperCase());
            } else if (letterType == LETTER_TYPE_LOWER) {
                data.add(result.toString().toLowerCase());
            } else {
                data.add(result.toString());
            }
        }

        return data;
    }

    /**
     * 生成十六进制码
     *
     * @param num        个数
     * @param len        长度
     * @param letterType 字母类型
     * @return 十六进制码List
     */
    public static List<String> generateRandomHexCodes(int num, int len, int letterType) {
        List<String> data = new ArrayList<>();

        for (int n = 0; n < num; n++) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < len; i++) {
                // 生成随机数（0~2）
                int rand = (int) (Math.random() * 3);

                // 检查随机数
                if (rand == 0) { // 生成数字
                    result.append((int) (Math.random() * 10));
                } else if (rand == 1) { // 生成小写字母
                    result.append((char) (int) (Math.random() * 6 + 97));
                } else if (rand == 2) { // 生成大写字母
                    result.append((char) (int) (Math.random() * 6 + 65));
                } else {
                    continue;
                }
            }

            // 检查字母类型
            if (letterType == LETTER_TYPE_UPPER) {
                data.add(result.toString().toUpperCase());
            } else if (letterType == LETTER_TYPE_LOWER) {
                data.add(result.toString().toLowerCase());
            } else {
                data.add(result.toString());
            }
        }

        return data;
    }

    /**
     * 生成随机UUID
     *
     * @param num        个数
     * @param letterType 字母类型
     * @return UUID List
     */
    public static List<String> generateRandomUUID(int num, int letterType) {
        List<String> data = new ArrayList<>();

        for (int n = 0; n < num; n++) {
            // 检查字母类型
            if (letterType == LETTER_TYPE_UPPER) {
                data.add(UUID.randomUUID().toString().toUpperCase());
            } else if (letterType == LETTER_TYPE_MIXED) {
                String uuid = UUID.randomUUID().toString();

                StringBuilder result = new StringBuilder();
                for (int i = 0; i < uuid.length(); i++) {
                    int random = (int) (Math.random() * 2);
                    result.append(random == 0 ? uuid.substring(i, i + 1) : uuid.substring(i, i + 1).toUpperCase());
                }

                data.add(result.toString());
            } else {
                data.add(UUID.randomUUID().toString());
            }
        }

        return data;
    }

    /**
     * 生成无横杠随机UUID
     *
     * @param num        个数
     * @param letterType 字母类型
     * @return UUID List
     */
    public static List<String> generateRandomUUIDWithoutMinusSign(int num, int letterType) {
        List<String> data = new ArrayList<>();

        for (int n = 0; n < num; n++) {
            // 检查字母类型
            if (letterType == LETTER_TYPE_UPPER) {
                data.add(UUID.randomUUID().toString().toUpperCase().replace("-", ""));
            } else if (letterType == LETTER_TYPE_MIXED) {
                String uuid = UUID.randomUUID().toString().replace("-", "");

                StringBuilder result = new StringBuilder();
                for (int i = 0; i < uuid.length(); i++) {
                    int random = (int) (Math.random() * 2);
                    result.append(random == 0 ? uuid.substring(i, i + 1) : uuid.substring(i, i + 1).toUpperCase());
                }

                data.add(result.toString());
            } else {
                data.add(UUID.randomUUID().toString().replace("-", ""));
            }
        }

        return data;
    }


}


