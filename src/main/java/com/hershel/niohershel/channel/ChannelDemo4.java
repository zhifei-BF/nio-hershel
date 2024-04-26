package com.hershel.niohershel.channel;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ChannelDemo4 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile fromFile = new RandomAccessFile("file/1.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("file/3.txt", "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();
        toChannel.transferFrom(fromChannel,position,count);
        fromChannel.close();
        toChannel.close();
        fromFile.close();
        toFile.close();
        System.out.println("over!");
    }
}
