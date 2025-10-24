import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

DS_TontTich
public class DS_TongTich
 {
    public static void main(String[] args) {
        try(Socket socket = new Socket("203.162.10.109", 2207)) {

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream  out = new DataOutputStream(socket.getOutputStream());
            
            String mess = "B22DCCN567" + ";" + "9sHndaH3";

            out.writeUTF(mess);
            out.flush();

            String read = in.readUTF();
            String[] a = read.trim().split("\\,");
            int[] b = new int[a.length];

            for ( int i = 0; i< a.length ; i++){
                b[i] = Integer.parseInt(a[i]);
            }

            int doiChieu  = 0;
            int bienThien = 0;
            int n = b.length;
            for ( int i = 1; i < n - 1; i++){
                if (b[i] > b[i - 1] && b[i] > b[i+1] || b[i] < b[i-1] && b[i] < b[i+1]){
                    doiChieu++;
                }
            }

            for ( int i = 1; i < n; i++){
                bienThien += Math.abs(b[i] - b[i-1]);
            }

            out.writeInt(doiChieu);
            out.writeInt(bienThien);
            out.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
