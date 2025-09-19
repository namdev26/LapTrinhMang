package BaiTap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class koILVLYY {
    private static String server =  "203.162.10.109";
    private static int port = 2208;

    public static String RLE(String s){
        int cnt = 1;
        StringBuilder res = new StringBuilder();
        for ( int i = 1 ; i <= s.length(); i++){
            if (i < s.length() && s.charAt(i) == s.charAt(i- 1)){
                cnt ++;
            }
            else {
                res.append(s.charAt(i-1));
                if (cnt > 1) res.append(cnt);
                cnt = 1;
            }
        }
        return res.toString();
    }

    public static String rev(String s){
        char[] a = s.toCharArray();
        int l = 0; int r = a.length-1;
        while (l < r) {
            char tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
            l++; r--;
        }
        return new String(a);
    }

    public static void main(String[] args) {
        try(Socket socket = new Socket(server, port)) {
            socket.setSoTimeout(5000);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            out.write("B22DCCN567" + ";" + "koILVLYY");
            out.newLine();  
            out.flush();

            String s = in.readLine();

            String[] s1 = s.trim().split("\\s+");
            StringBuilder res = new StringBuilder();

            for ( int i = 0; i< s1.length; i++){
                String h = rev(s1[i]);
                String k = RLE(h);
                res.append(" " + k);
            }

            String c = res.toString();

            out.write(c);
            out.newLine();
            out.flush();
            //System.out.println(res);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
