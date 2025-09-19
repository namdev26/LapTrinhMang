package BaiTap;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class B22DCCN5679sHndaH3 {
    private static String server = "203.162.10.109";
    private static int port = 2207;

    public static void main(String[] args) {
        try (Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF("B22DCCN567" + ";" + "9sHndaH3");

            String data = in.readUTF();
            //System.out.println(data);

            //c
            String[] stringdata = data.split(",");
            int[] intdata = new int[stringdata.length];

            for ( int i = 0 ; i < stringdata.length ; i++){
                intdata[i] = Integer.parseInt(stringdata[i]);
                System.out.println(intdata[i]);
            }

            int doichieu = 0;
            int bienthien = 0;

            for ( int i = 1 ; i < intdata.length - 1; i++){
                if((intdata[i] > intdata[i- 1] && intdata[i] > intdata[i+ 1]) || (intdata[i] < intdata[i- 1] && intdata[i] < intdata[i+ 1])){
                    doichieu ++;
                }
            }

            for ( int i = 0 ; i < intdata.length - 1; i++){
                bienthien += Math.abs(intdata[i] - intdata[i + 1]);
            }

            out.writeInt(doichieu);
            out.writeInt(bienthien);
            out.flush();
            System.out.println(doichieu);
            System.out.println(bienthien);


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
