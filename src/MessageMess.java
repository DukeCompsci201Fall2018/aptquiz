import java.util.*;

public class MessageMess {
    ArrayList<String> myMess = new ArrayList<>();
    public String restore(String[] d, String m){
        int x = work(d,m);
        if (x == 0) return "IMPOSSIBLE!";
        if (x > 1) return "AMBIGUOUS!";
        return String.join(" ",myMess);
    }
    public int work(String[] d, String m){
        int tot = 0;
        if (m.length() == 0) return 1;
        //System.out.println("looking for "+m);
        for(String s : d) {
            if (m.startsWith(s)) {
                myMess.add(s);
                int rec = work(d, m.substring(s.length()));
                if (rec == 0) {
                    myMess.remove(myMess.size()-1);   
                }
                tot += rec;
            }
        }
        return tot;
    }
    
    public static void main(String[] args) {
    	MessageMess mm = new MessageMess();
    	String[] ss = {"ABC", "BCD", "CD", "ABCB"};
    	String s = "ABCBCD";
    	System.out.println(mm.restore(ss, s));
    	
    }
}