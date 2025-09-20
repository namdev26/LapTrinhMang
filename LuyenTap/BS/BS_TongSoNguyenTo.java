package BS;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class BS_TongSoNguyenTo {
    public static boolean isPrime(int n){
        if (n < 2) return false;
        if (n ==2) return true;
        if (n % 2 ==0) return false;
        for ( int i =3; i *i <= n; i+=2){
            if (n % i ==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        try (Socket socket = new Socket("203.162.10.109", 2206)) {

            socket.setSoTimeout(5000);

            String mess = "B22DCCN567" + ";" + "dC9Lc8hJ  ";

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            out.write(mess.getBytes());

            byte[] b = new byte[4096];
            int a = in.read(b);
            String s = new String(b, 0, a);
            String[] h = s.trim().split("\\,");
            
            int sum =0;

            int[] c = new int[h.length];

            for ( int i =0; i< h.length ;i++){
                c[i] = Integer.parseInt(h[i]);
            }

            for ( int i =0; i < c.length; i++){
                if (isPrime(c[i])){
                    sum += c[i];
                }
            }

            out.write(Integer.toString(sum).getBytes());
            out.flush();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
