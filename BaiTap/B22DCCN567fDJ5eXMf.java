package BaiTap;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class B22DCCN567fDJ5eXMf {
    private static final String SERVER = "203.162.10.109";
    private static final int PORT = 2207;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER, PORT)) {
            socket.setSoTimeout(5000);

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            //a
            String msv = "B22DCCN567";
            String code = "fDJ5eXMf";
            String mess = msv + ";" + code;

            out.writeUTF(mess);
            out.flush();

            //b
            int a = in.readInt();
            int b = in.readInt();
            System.out.println(a);
            System.out.println(b);

            //c tinh toan
            int tong = a + b;
            int tich = a * b;

            out.writeInt(tong);
            out.writeInt(tich);
            out.flush();

            System.out.println(tong);
            System.out.println(tich);
            // d gui
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
