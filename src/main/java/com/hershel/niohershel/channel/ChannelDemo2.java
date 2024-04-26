package com.hershel.niohershel.channel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelDemo2 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("file/2.txt", "rw");
        FileChannel channel = aFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);

        String newData = "New String to write fo file" + System.currentTimeMillis();

        buffer.clear();
        buffer.put(newData.getBytes());
        buffer.flip();
        while (buffer.hasRemaining()) {
            channel.write(buffer);
        }
        channel.close();
    }
}
