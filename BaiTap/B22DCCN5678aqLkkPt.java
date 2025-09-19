package BaiTap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class B22DCCN5678aqLkkPt {
    private static final String server = "203.162.10.109";
    private static final int port = 2208;

    public static void main(String[] args) {
        String mess = "B22DCCN567" + ";" + "8aqLkkPt";

        try (Socket socket = new Socket(server, port)) {
            socket.setSoTimeout(5000);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.write(mess);
            out.newLine();
            out.flush();

            // b
            String data = in.readLine();

            String[] a = data.trim().split("\\s+");
            List<String> b = new ArrayList<>(Arrays.asList(a));

            b.sort(Comparator.comparingInt(String::length));

            String res = String.join(", ", b);

            out.write(res);
            out.newLine();
            out.flush();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
