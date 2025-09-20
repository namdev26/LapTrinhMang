import java.io.*;
import java.net.*;
import java.util.*;

public class CS_DemSoLanXuatHien {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String code = "B22DCCN567;CVkVQheX";
        bw.write(code);
        bw.newLine();
        bw.flush();
        String s = br.readLine();
        System.out.println(s);
        int[] cnt = new int[256];
        for (char x : s.toCharArray()) {
            if (Character.isLetter(x) || Character.isDigit(x))
                cnt[x]++;
        }
        String ans = "";
        for (char x : s.toCharArray()) {
            if (cnt[x] >= 2) {
                ans += x + ":" + cnt[x] + ",";
                cnt[x] = 0;
            }
        }
        System.out.println(ans);
        bw.write(ans);
        bw.newLine();
        bw.flush();
        socket.close();
    }
}