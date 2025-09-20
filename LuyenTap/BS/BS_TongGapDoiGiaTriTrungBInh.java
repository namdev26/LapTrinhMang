import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class BS_TongGapDoiGiaTriTrungBInh {
    public static void main(String[] args) {
        try (Socket socket = new Socket("203.162.10.109", 2206)) {

            socket.setSoTimeout(5000);

            String mess = "B22DCCN567" + ";" + "FSAUscWY ";

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            out.write(mess.getBytes());
            out.flush();

            byte[] k = new byte[4096];
            int byteread = in.read(k);
            String s = new String(k, 0, byteread);
            String[] a = s.trim().split("\\,");
            int[] b = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                b[i] = Integer.parseInt(a[i]);
            }
            int n = a.length;

            int sum = 0;
            for (int i = 0; i < a.length; i++) {
                sum += b[i];
            }

            int avg = (sum / a.length) * 2;

            int min = Integer.MAX_VALUE;
            int res1 = 0;
            int res2 = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int check = Math.abs(b[i] + b[j] - avg);
                    if (check < min) {
                        min = check;
                        res1 = Math.min(b[i], b[j]);
                        res2 = Math.max(b[i], b[j]);

                    }
                }
            }

            String res = Integer.toString(res1) + "," + Integer.toString(res2);

            out.write(res.getBytes());
            out.flush();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
