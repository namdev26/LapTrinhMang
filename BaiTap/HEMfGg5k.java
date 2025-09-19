package BaiTap;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class HEMfGg5k {
    private static final String server = "203.162.10.109";
    private static final int port = 2207;

    public static void main(String[] args) {
        String mess = "B22DCCN567" + ";" + "HEMfGg5k";

        try (Socket socket = new Socket(server, port)) {
            socket.setSoTimeout(5000);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF(mess);
            out.flush();

            int a = in.readInt();

            String oct = Integer.toOctalString(a).toUpperCase();
            String hex = Integer.toHexString(a).toUpperCase();

            out.writeUTF(oct +";"+ hex);
            out.flush();

        } catch (Exception e) {
        }
    }
}
