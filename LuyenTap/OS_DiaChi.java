import java.io.*;
import java.net.*;
import TCP.Address;

public class OS_DiaChi {
    public static String chuanHoa0(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    public static String chuanHoa1(String s) {
        String ans = "";
        String[] tmp = s.trim().split("\\s+");
        for (String x : tmp)
            ans += chuanHoa0(loaiBo1(x)) + " ";
        return ans;
    }

    public static String loaiBo1(String s) {
        String ans = "";
        for (char x : s.toCharArray()) {
            if (Character.isAlphabetic(x) || Character.isDigit(x))
                ans += String.format("%c", x);
        }
        return ans;
    }

    public static String loaiBo2(String s) {
        String ans = "";
        for (char x : s.toCharArray()) {
            if (Character.isDigit(x) || x == '-')
                ans += String.format("%c", x);
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        String code = "B22DCCN567;TzSo8soG";
        out.writeObject(code);
        out.flush();
        Address ad = (Address) in.readObject();
        System.out.println(ad);
        ad.setAddressLine(chuanHoa1(ad.getAddressLine()));
        ad.setPostalCode(loaiBo2(ad.getPostalCode()));
        System.out.println(ad);
        out.writeObject(ad);
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}