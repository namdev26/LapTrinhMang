import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class CS_DuoiEdu {
    public static void main(String[] args) {
        try (Socket socket = new Socket("203.162.10.109", 2208)) {

            socket.setSoTimeout(5000);

            String mess = "B22DCCN567" + ";" + "D9BYeVV5";

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            out.write(mess);
            out.newLine();
            out.flush();

            String s = in.readLine();

            String[] a = s.trim().split("\\,");
            List<String> list = new ArrayList<>();
            for (int i =0; i < a.length; i++){
                if (a[i].endsWith(".edu")){
                    list.add(a[i]);
                }
            }

            String r = String.join(",", list);
            out.write(r);
            out.newLine();;
            out.flush();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
