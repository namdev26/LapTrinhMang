import java.io.*;
import java.net.*;
import TCP.Customer;

public class OS_KhachHang {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2209);
        socket.setSoTimeout(5000);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        String code = "B22DCCN567;TzSo8soG";

        out.writeObject(code);
        out.flush();

        Customer customer = (Customer) in.readObject();
        System.out.println(customer);
        String[] tenTmp = customer.getName().split("\\s+");
        String tenMoi = "";
        tenMoi += tenTmp[tenTmp.length - 1].toUpperCase() + ", ";

        for (int i = 0; i < tenTmp.length - 1; i++)
            tenMoi += Character.toUpperCase(tenTmp[i].charAt(0)) + tenTmp[i].substring(1).toLowerCase() + " ";
        customer.setName(tenMoi.trim());

        String[] nsTmp = customer.getDayOfBirth().split("-");
        String nsMoi = nsTmp[1] + "/" + nsTmp[0] + "/" + nsTmp[2];
        customer.setDayOfBirth(nsMoi);
        String userMoi = "";

        for (int i = 0; i < tenTmp.length - 1; i++)
            userMoi += Character.toLowerCase(tenTmp[i].charAt(0));
        userMoi += tenTmp[tenTmp.length - 1].toLowerCase();
        customer.setUserName(userMoi);

        System.out.println(customer);
        out.writeObject(customer);
        out.flush();
    }

}