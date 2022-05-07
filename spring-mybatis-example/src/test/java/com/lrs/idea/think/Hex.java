package com.lrs.idea.think;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.*;
import java.net.URL;

public class Hex {

    @Test
    public void testFormat() throws Exception {
        byte[] data = read();
        StringBuilder rs = new StringBuilder();
        int count = 0;
        for (byte b : data) {
            if (count % 16 == 0) {
                // 行的头部信息
                rs.append(String.format("%05x:", count));
            }
            rs.append(String.format("%02x ", b));
            count++;
            // 判断是否到达行尾
            if (count % 16 == 0) {
                rs.append('\n');
            }

        }

        System.out.print(rs);

    }

    private byte[] read() throws IOException {
        URL url = Hex.class.getResource("Hex.class");

        assert url != null;
        BufferedInputStream inputStream = new BufferedInputStream(url.openStream());
        try {
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            return data;
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }
}
