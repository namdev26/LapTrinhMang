package DS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class DS_DaoNguocDoan {
    public static void main(String[] args) {
        try(Socket socket = new Socket("203.162.10.109", 2207)) {
            socket.setSoTimeout(5000);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String mess = "B22DCCN567" + ";" + "NDl9nMKX";

            out.writeUTF(mess);
            out.flush();

            int k = in.readInt();
            String read = in.readUTF();
            String[] a = read.trim().split("\\,");
            int n = a.length;
            for ( int i = 0; i < n; i+= k){
                int l = i;
                int r = Math.min(i + k -1, n -1);
                while (l < r) {
                    String tmp = a[l];
                    a[l] = a[r];
                    a[r] = tmp;
                    l++;
                    r--;
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for ( int i =0; i < n; i++){
                if (i == n-1){
                    sb.append(a[i]);
                }
                else {
                    sb.append(a[i]+",");
                }
            }

            String res = sb.toString();
            System.out.println(res);
            out.writeUTF(res);
            out.flush();;

        } catch (Exception e) {
            System.out.println(e);
        }
    }    
}
