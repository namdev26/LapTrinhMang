package BaiTap;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class NDl9nMKX {
    private static final String server = "203.162.10.109";
    private static final int port = 2207;

    public static void main(String[] args) {
        String mess = "B22DCCN567" + ";" + "NDl9nMKX";

        try (Socket socket = new Socket(server, port)) {
            socket.setSoTimeout(5000);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF(mess);
            out.flush();

            // b
            int k = in.readInt();
            String soNguyenString = in.readUTF();

            // System.out.println(k);

            String[] soNguyenListString = soNguyenString.split(",");
            int[] soNguyenListInt = new int[soNguyenListString.length];

            for (int i = 0 ; i < soNguyenListInt.length; i++){
                soNguyenListInt[i] = Integer.parseInt(soNguyenListString[i]);
            }

            for ( int i = 0; i < soNguyenListInt.length; i+= k){
                int left = i; 
                int right = Math.min(i + k -1,soNguyenListInt.length -1 );
                while (left < right) {
                    int tmp = soNguyenListInt[left];
                    soNguyenListInt[left] = soNguyenListInt[right];
                    soNguyenListInt[right] = tmp;
                    left ++;
                    right --;
                }
            }

            String res = "";
            for ( int i = 0; i < soNguyenListInt.length; i++){
                if (i == soNguyenListInt.length - 1){
                    res = res + Integer.toString(soNguyenListInt[i]);
                }
                else 
                    res = res + Integer.toString(soNguyenListInt[i]) + ",";
            }
            

            out.writeUTF(res);
            out.flush();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
