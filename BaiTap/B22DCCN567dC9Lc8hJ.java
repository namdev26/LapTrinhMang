package BaiTap;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class B22DCCN567dC9Lc8hJ {
    private static final String Server = "203.162.10.109";
    private static final int PORT = 2206;

    private static boolean isPrime(int n) {
        if (n < 2)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String msv = "B22DCCN567";
        String code = "dC9Lc8hJ";

        try (Socket socket = new Socket(Server, PORT)) {
            socket.setSoTimeout(5000);
            // a
            String mess = msv + ";" + code;
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            out.write(mess.getBytes());
            out.write("\n".getBytes());
            out.flush();

            // b
            StringBuilder sb = new StringBuilder();
            int ch;
            while ((ch = in.read()) != -1) {
                if (ch == '\n')
                    break;
                sb.append((char) ch);
            }
            String numbeString = sb.toString().trim();

            int sum = 0;
            String[] dataInt = numbeString.split(",");

            for (String p : dataInt) {
                int num = Integer.parseInt(p);
                if (isPrime(num)) {
                    sum += num;
                }
            }

            out.write(Integer.toString(sum).getBytes());
            out.flush();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}