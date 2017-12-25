package com.hexStrToByte;

/**
 * Created by shichen.ma on 2017/7/19.
 */
public class test {
    public static void main(String[] args) {
        String aa  ="1234121";
        byte[] hexBytes = hexStrToBytes(aa);
        byte[] strBytes = aa.getBytes();
        System.out.println(new String(hexBytes));
    }

    public static final byte[] hexStrToBytes(String s) {
        byte[] bytes;

        bytes = new byte[s.length() / 2];

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2),
                    16);
        }

        return bytes;
    }
}
