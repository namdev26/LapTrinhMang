
import java.io.*;
import java.net.*;
import TCP.Product;

public class OS_SanPham {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        // a.
        String code = "B22DCCN567;bByEPuKl";
        out.writeObject(code);
        out.flush();
        // b.
        Product product = (Product) in.readObject();
        // c.
        int x = (int) product.getPrice();
        int tong = 0;
        while (x > 0) {
            tong += x % 10;
            x /= 10;
        }
        product.setDiscount(tong);
        // d.
        out.writeObject(product);
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}