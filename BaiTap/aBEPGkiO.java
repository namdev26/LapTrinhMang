package BaiTap;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class aBEPGkiO {
    public static void main(String[] args) {
        try (Socket socket = new Socket("203.162.10.109", 2206)) {
            socket.setSoTimeout(5000);

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            String mess = "B22DCCN567" + ";" + "aBEPGkiO";
            out.write(mess.getBytes());
            out.flush();

            byte[] a = new byte[1024];
            int b = in.read(a);
            String data = new String(a, 0, b);

            String[] arr = data.trim().split(",");
            int[] c = new int[arr.length];
            int n = arr.length;
            int tong = 0;
            for (int i = 0; i < n; i++) {
                c[i] = Integer.parseInt(arr[i]);
                tong += c[i];
            }

            int average = (tong / n) * 2;
            int min = Integer.MAX_VALUE;
            int res1 = 0;
            int res2 = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int k = c[i] + c[j];
                    int diff = Math.abs(k - average);
                    if (diff < min) {
                        min = diff;
                        res1 = Math.min(c[i], c[j]);
                        res2 = Math.max(c[i], c[j]);
                    }
                }
            }

            String ans = res1 + "," + res2;
            out.write(ans.getBytes());
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
