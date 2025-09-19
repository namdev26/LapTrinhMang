package BaiTap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class B22DCCN567D9BYeVV5 {
    private static final String SERVER = "203.162.10.109";
    private static final int 
    PORT = 2208;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER, PORT)) {
            socket.setSoTimeout(5000);

            String msv = "B22DCCN567";
            String code = "D9BYeVV5";
            String mess = msv +";" + code;

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.write(mess);
            out.newLine();
            out.flush();

            // b
            String domainsString = in.readLine();
            //System.out.println(domainsString);

            // c
            String[] domains = domainsString.split(",\\s*");
            // for ( int i = 0; i < domainsString.length(); i++){
            //     System.out.println(domains[i]);
            // }
            StringBuilder eduDomains = new StringBuilder();
            for (String d : domains){
                if (d.endsWith(".edu")){
                    if (eduDomains.length() > 0){
                        eduDomains.append(", ");
                    }
                    eduDomains.append(d);
                }
            }

            String res = eduDomains.toString();
            System.out.println(res);
            //d

            out.write(res);
            out.newLine();
            out.flush();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
