package com.coderacing;

import com.coderacing.rl.MyController;

import java.io.IOException;

public class ProperlyMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec("rl-coderacing-properly\\start.bat");

        Thread.sleep(2000);

        new Runner(new String[]{"127.0.0.1", "31001", "0000000000000000"}, new MyController()).run();

        p.destroy();
    }
}
