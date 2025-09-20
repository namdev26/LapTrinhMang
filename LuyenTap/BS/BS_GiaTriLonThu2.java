import java.io.*;
import java.net.*;
import java.util.*;

public class BS_GiaTriLonThu2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        //
        String ma = "B22DCCN567;4XNRzWzl";
        out.write(ma.getBytes());
        out.flush();
        //
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead);
        System.out.println(s);
        //
        String[] t = s.trim().split(",");
        ArrayList<Integer> a = new ArrayList<>(), b = new ArrayList<>();
        for (String x : t) {
            int x1 = Integer.parseInt(x);
            a.add(x1);
            b.add(x1);
        }
        Collections.sort(a);
        int secMax = a.get(a.size() - 2), pos = 0;
        for (int i = 0; i < b.size(); i++) {
            if (b.get(i) == secMax)
                pos = i;
        }
        String res = String.format("%d,%d", secMax, pos);
        System.out.println(res);
        out.write(res.getBytes());
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
