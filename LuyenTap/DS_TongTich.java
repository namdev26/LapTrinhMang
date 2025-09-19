import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class DS_TongTich {
    public static void main(String[] args) {
        try (Socket socket = new Socket("203.162.10.109", 2207)) {

            socket.setSoTimeout(5000);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String mes = "B22DCCN567" + ";" + "fDJ5eXMf";

            out.writeUTF(mes);
            out.flush();

            int a = in.readInt();
            int b = in.readInt();

            int sum = a + b;
            int tich = a * b;

            out.writeInt(sum);
            out.flush();
            out.writeInt(tich);
            out.flush();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
