import java.io.*;
import java.net.*;

public class CS_LoaiBoNguyenAm {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 1606);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String code = "B22DCCN567;x8c45mq";
        bw.write(code);
        bw.newLine();
        bw.flush();
        String q = "", s = br.readLine();
        System.out.println(s);
        for (char x : s.toCharArray()) {
            if (x != 'u' && x != 'e' && x != 'o' && x != 'a' && x != 'i')
                q += x;
        }
        System.out.println(q);
        bw.write(q);
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
        socket.close();
    }
}
