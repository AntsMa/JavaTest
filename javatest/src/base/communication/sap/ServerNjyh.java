package base.communication.sap;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerNjyh {
    public static void main(String[] args) throws IOException {
        /**
         * 基于TCP协议的Socket通信，实现用户登录，服务端
         */
        // 1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
        ServerSocket serverSocket = new ServerSocket(10010);
        // 2、调用accept()方法开始监听，等待客户端的连接
        Socket socket = serverSocket.accept();
        // 3、获取输入流，并读取客户端信息
        InputStream is = socket.getInputStream();
        String  str =new DataInputStream(is).readUTF();
        System.out.println(str);
     /*   InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String info = null;
        while ((info = br.readLine()) != null) {
            System.out.println("Hello,我是服务器，客户端说：" + info);
        }
        socket.shutdownInput();// 关闭输入流*/
        // 4、获取输出流，响应客户端的请求
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        String  dataload = "000000029000<ap><head><tr_code>200108</tr_code><serial_no></serial_no><req_no>0005</req_no><tr_acdt>20170725</tr_acdt><tr_time>141941</tr_time><channel>5</channel><sign>0</sign><file_flag>0</file_flag><reserved></reserved></head><body><acno>03080120030000897</acno><cur_code>01</cur_code></body></ap>";
        pw.write(dataload);
        pw.flush();

        // 5、关闭资源
        pw.close();
        os.close();
      /*  br.close();
        isr.close();*/
        is.close();
        socket.close();
        serverSocket.close();
    }
}