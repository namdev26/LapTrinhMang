package CS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class CS_DaoNguocVaMaHoaRLE {

    public static String DaoNguoc(String s) {
        String res = new StringBuffer(s).reverse().toString();
        return res;
    }

    public static String RLE(String s) {
        int cnt = 1;
        int n = s.length();
        String res = "";
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i-1)){
                cnt ++;
            }
            else{
                if (cnt > 1){
                    res += s.charAt(i-1) + Integer.toString(cnt);
                    cnt = 1;
                }
                else {
                    res += s.charAt(i-1);
                    cnt = 1;
                }
            }
        }
        return res + s.charAt(n-1);
    }

    public static void main(String[] args) {
        try (Socket socket = new Socket("203.162.10.109", 2208)) {

            socket.setSoTimeout(5000);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String mess = "B22DCCN567" + ";" + "koILVLYY";

            out.write(mess);
            out.newLine();
            out.flush();

            String b = in.readLine();
            String[] a = b.trim().split("\\s+");
            int n = a.length;

            String s = "";

            for ( int i = 0; i < n; i++){
                String a1 = DaoNguoc(a[i]);
                String s2 = RLE(a1);
                s += s2 + " ";
            }

            out.write(s);
            out.newLine();;
            out.flush();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
