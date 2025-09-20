import java.io.*;
import java.net.*;
import java.util.*;

public class CS_SapXepChuoi {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2208);

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String code = "B21DCCN567;CZMrJdmx";
        bw.write(code);
        bw.newLine();
        bw.flush();
        String s = br.readLine();
        System.out.println(s);
        String[] a = s.trim().split("\\s+");
        ArrayList<String> res = new ArrayList<>();
        String q = "";
        for (String x : a)
            res.add(x);
        Collections.sort(res);
        for (int i = 0; i < res.size() - 1; i++)
            q += res.get(i) + " ";
        q += res.get(res.size() - 1);
        bw.write(q);
        System.out.println(q);
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
        socket.close();
    }
}
