import java.io.*;
import java.net.*;
import java.util.*;

public class CS_TachChuoi {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String code = "B22DCCN567;uQWRjN4f";
        bw.write(code);
        bw.newLine();
        bw.flush();
        String s = br.readLine();
        System.out.println(s);
        String s1 = "", s2 = "";
        for (char x : s.toCharArray()) {
            if (Character.isDigit(x) || Character.isAlphabetic(x))
                s1 += String.valueOf(x);
            else
                s2 += String.valueOf(x);
        }
        System.out.println(s1);
        System.out.println(s2);

        bw.write(s1);
        bw.newLine();
        bw.flush();

        bw.write(s2);
        bw.newLine();
        bw.flush();

        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
        socket.close();
    }
}