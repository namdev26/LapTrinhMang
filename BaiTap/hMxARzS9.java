package BaiTap;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class hMxARzS9 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("203.162.10.109", 2206)){
            socket.setSoTimeout(5000);

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            
            String mess = "B22DCCN567" + ";" + "hMxARzS9";
            out.write(mess.getBytes());

            byte[] buffer = new byte[4096];
            int byteRead = in.read(buffer);

            String data = new String(buffer, 0, byteRead);
            
            String[] part = data.split("\\|");
            int sum = 0;
            int n = part.length;
            for ( int i = 0; i < n; i++){
                sum += Integer.parseInt(part[i]);
            }

            String res = Integer.toString(sum);
            out.write(res.getBytes());

            //System.out.println(sum);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
