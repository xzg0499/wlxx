package com.xzg.wlxx.library;

import cn.hutool.core.util.StrUtil;

import java.io.IOException;
import java.net.Socket;
import java.util.stream.IntStream;

/**
 * @author XiaoZG
 */
public class CheckPort {
    public static void main(String[] args) {
        checkPort("www.baidu.com", 80, 81, 82, 83, 84);
    }

    public static boolean checkPort(String ip, int... ports) {
        IntStream.of(ports).forEach(p -> {
            try (var server = new Socket(ip, p)) {
                System.out.println(StrUtil.format("{} address {} is Open", ip, p));
            } catch (IOException e) {
                System.out.println(StrUtil.format("{} address {} is Closed", ip, p));
            }
        });
        return false;
    }
}
