import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class DS_DoiCoSo8_16 {
    public static void main(String[] args) {
        try(Socket socket = new Socket("203.162.10.109", 2207)) {
            socket.setSoTimeout(5000);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String mess = "B22DCCN567" + ";" + "HEMfGg5k";

            out.writeUTF(mess);
            out.flush();

            int a = in.readInt();

            String he10 = Integer.toHexString(a).toUpperCase();
            String he8 = Integer.toOctalString(a).toUpperCase();

            out.writeUTF(he8 +";" + he10);
            out.flush();

        } catch (Exception e) {
            System.out.println(e);
        }
    } 
}
