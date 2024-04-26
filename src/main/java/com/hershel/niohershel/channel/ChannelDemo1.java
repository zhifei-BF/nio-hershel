package com.hershel.niohershel.channel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelDemo1 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("file/1.txt", "rw");
        FileChannel channel = aFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int bytesRead = channel.read(buffer);
        while (bytesRead != -1) {
            System.out.println("读取：" + bytesRead);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }
            buffer.clear();
            bytesRead = channel.read(buffer);
        }
        aFile.close();
        System.out.println("操作结束");
    }
}
