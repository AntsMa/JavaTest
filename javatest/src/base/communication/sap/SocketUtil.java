package base.communication.sap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.net.Socket;

/**
 * Created by shichen.ma on 2017/8/9.
 */
public class SocketUtil {
    public static final String IP_ADDR = "127.0.0.1";//服务器地址
    public static final int PORT = 10010;//服务器端口号
    public static void main(String[] args) {
        sendSocketRequest("nj",IP_ADDR,PORT,"123".getBytes());
    }


    public static String  sendSocketRequest(String banktype,String ip,int port,byte[] byteSendBuf){
        Socket socket = null;
        try
        {
            socket = new Socket(ip, port);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        InputStream input = null;
        OutputStream output = null;
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        String rtnString = null; // 返回的所有数据字符串
        byte[] respCtByte = null; //返回的所有数据字节数组

        try {
            socket.setSoTimeout(300*1000);
            socket.setSoLinger(true, 1);
            input = socket.getInputStream();
            output = socket.getOutputStream();
            dataOutputStream = new DataOutputStream(output);
            dataInputStream = new DataInputStream(input);

            long start = System.currentTimeMillis();
//            dataOutputStream.write(byteSendBuf);
            String      dataload = "000000029000<ap><head><tr_code>200108</tr_code><serial_no></serial_no><req_no>0005</req_no><tr_acdt>20170725</tr_acdt><tr_time>141941</tr_time><channel>5</channel><sign>0</sign><file_flag>0</file_flag><reserved></reserved></head><body><acno>03080120030000897</acno><cur_code>01</cur_code></body></ap>";
            dataOutputStream.writeUTF(dataload);
            //所有数据至目的地
            dataOutputStream.flush();
            long end = System.currentTimeMillis();
            int headerLength = 0;
            if("nj".equals(banktype)){
                headerLength = 10;
            }else  if("abc".equals(banktype)){
                headerLength = 11;
            }else {
                return "未获取到发送银行类型！";
            }

            byte[] resqHeaderCtByte = new byte[headerLength];//
            byte[] responseBodyByte= null;
//           String resStr =  dataInputStream.readUTF();
//            System.out.println(resStr);
            int responseHeadLength = dataInputStream.read(resqHeaderCtByte);//“报文长度”所占的长度
            int responseBodyLength =0;//报文体长度
            int respCtLength =0;//报文长度
            if (responseHeadLength > 0) {
                if("nj".equals(banktype)){
                    responseBodyLength = Integer.parseInt(new String(resqHeaderCtByte));
                }else  if("abc".equals(banktype)){
                    responseBodyLength = Integer.parseInt(new String(resqHeaderCtByte).substring(1,11));
                }
                responseBodyByte = new byte[responseBodyLength];

                respCtLength = responseHeadLength+responseBodyLength;
                respCtByte = new byte[respCtLength];
                //返回报文长度
                System.arraycopy(resqHeaderCtByte, 0, respCtByte, 0, responseHeadLength);

                int readIndex = 0;
                // 加入多次socket读入
                do {
                    int inputread = dataInputStream.read(responseBodyByte, readIndex, responseBodyLength - readIndex);
                    if (inputread > 0)
                        readIndex += inputread;
                    else
                        break;
                } while (readIndex < responseBodyLength);

                //返回报文主体
                System.arraycopy(responseBodyByte, 0, respCtByte, responseHeadLength, responseBodyLength);
                //对报文进行解析
//                parseResponse(respCtByte);


            }else{
            }
            if(null == respCtByte){
                rtnString = null;
            }else{
                rtnString = new String(respCtByte,"GBK");
            }
            start = System.currentTimeMillis();

        }
        // 通讯超时时会出现该异常
        catch (InterruptedIOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null)
                    input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (output != null)
                    output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //关闭流
            try {
                if(dataInputStream != null)
                {
                    dataInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //关闭流
            try {
                if(dataInputStream != null)
                {
                    dataOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println(rtnString);
        return rtnString;
    }
}
