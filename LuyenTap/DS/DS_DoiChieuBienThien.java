package DS;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class DS_DoiChieuBienThien {
    public static void main(String[] args) {
        try(Socket socket = new Socket("203.162.10.109", 2207)) {

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream  out = new DataOutputStream(socket.getOutputStream());
            
            String mess = "B22DCCN567" + ";" + "9sHndaH3";

            out.writeUTF(mess);
            out.flush();

            String s = in.readUTF();
            String a[] = s.trim().split("\\,");
            int n = a.length;
            int[] b = new int[n];
            
            for ( int i =0; i < n;i++){
                b[i] = Integer.parseInt(a[i]);
            }


            int doiChieu =0;
            int bienThien =0;




            for ( int i  = 1; i < n -1; i++){
                if (b[i] > b[i-1] && b[i] > b[i+1] || b[i] < b[i-1] && b[i] < b[i+1]){
                    doiChieu ++;
                }
            }

            for ( int i = 0; i < n-1; i++){
                bienThien += Math.abs(b[i] - b[i+1]);
            }

            out.writeInt(doiChieu);
            out.writeInt(bienThien);
            out.flush();

            System.out.println(doiChieu);
            System.out.println(bienThien);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
