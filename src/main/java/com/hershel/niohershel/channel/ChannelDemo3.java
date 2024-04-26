package com.hershel.niohershel.channel;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ChannelDemo3 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("file/1.txt", "rw");
        FileChannel channel = aFile.getChannel();
        //获取通道大小
        long size = channel.size();
        System.out.println("size:" + size);
        //获取当前位置
        long position = channel.position();
        System.out.println("position:" + position);
        //截取
        FileChannel truncate = channel.truncate(5);
        System.out.println("truncate:" + truncate.size());
        //关闭
        truncate.close();
        channel.close();
        aFile.close();
    }
}
