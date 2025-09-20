import java.io.*;
import java.net.*;
import java.util.*;

public class DS_PhepToanCoBan {
    public static int UCLN(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B22DCCN567;nkBwM6AE";
        out.writeUTF(code);
        out.flush();
        int a = in.readInt(), b = in.readInt();
        int tong = a + b, tich = a * b, ucln = UCLN(a, b), bcnn = a * b / UCLN(a, b);
        out.writeInt(ucln);
        out.writeInt(bcnn);
        out.writeInt(tong);
        out.writeInt(tich);

        in.close();
        out.close();
        socket.close();
    }
}