package com.lifeifei.springcloud.starter.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author feifei.li
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 1; i++) {
            send("B3i,E-19001,3,1,32,Start,CCD1,12.03,15.32,End@");
        }
    }

    public static void send(Object arg) throws IOException {
        Socket socket = new Socket("localhost", 9009);
        // 向服务端程序发送数据
        OutputStream ops = socket.getOutputStream();
        OutputStreamWriter opsw = new OutputStreamWriter(ops);
        BufferedWriter bw = new BufferedWriter(opsw);
        String str = arg.toString();
        bw.write(str);
        bw.flush();

        /*读取内容*/
        InputStream ips = socket.getInputStream();
        InputStreamReader ipsr = new InputStreamReader(ips);
        BufferedReader br = new BufferedReader(ipsr);
        String s = "";
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        bw.close();
        socket.close();
    }
}
