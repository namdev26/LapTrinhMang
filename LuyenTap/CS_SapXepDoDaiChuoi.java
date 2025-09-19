import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CS_SapXepDoDaiChuoi {
    public static void main(String[] args) {
        try (Socket socket = new Socket("203.162.10.109", 2208)) {

            socket.setSoTimeout(5000);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String s = "B22DCCN567" + ";" + "8aqLkkPt";

            out.write(s);
            out.newLine();
            out.flush();

            String b = in.readLine();
            String[] a = b.trim().split("\\s+");

            List<String> list = new ArrayList<>(Arrays.asList(a));

            list.sort(Comparator.comparingInt(String::length));

            String res = String.join(", ", list);

            out.write(res);
            out.newLine();
            out.flush();
        } catch (Exception e) {
        }
    }
}
