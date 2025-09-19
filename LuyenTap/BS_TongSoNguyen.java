import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class BS_TongSoNguyen {
    public static void main(String[] args) {
        try (Socket socket = new Socket("203.162.10.109", 2206)) {

            socket.setSoTimeout(5000);

            String mess = "B22DCCN567" + ";" + "hMxARzS9 ";

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            out.write(mess.getBytes());

            byte[] b = new byte[4096];
            int byteread = in.read(b);
            String s = new String(b, 0, byteread);

            String[] s1 = s.trim().split("\\|");
            int sum =0;
            
            for ( int i =0; i< s1.length; i++){
                sum += Integer.parseInt(s1[i]);
            }

            out.write(Integer.toString(sum).getBytes());
            out.flush();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
