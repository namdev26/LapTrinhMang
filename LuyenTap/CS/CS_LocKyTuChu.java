import java.io.*;
import java.net.*;
import java.util.*;

public class CS_LocKyTuChu {
    public static void main(String[] args) throws Exception{
        //Conn
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String code = "B22DCCN567;TuTa8p7";
        bw.write(code); bw.newLine(); bw.flush();

        String s = br.readLine();
        System.out.println(s);

        int []cnt = new int[10005];
        for(char x: s.toCharArray()){ 
            if(Character.isAlphabetic(x)) cnt[x]++;
        }
        String ans = "";
        for(char x: s.toCharArray()){ 
            if(cnt[x] > 0){
                ans+=x;
                cnt[x] = 0;
            }
        }
        System.out.println(ans);

        bw.write(ans); bw.newLine(); bw.flush();
    }
}
