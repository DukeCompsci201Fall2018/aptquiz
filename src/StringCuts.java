import java.util.*;

public class StringCuts {
    public String[] filter(String[] list, int minLength){
        ArrayList<String> ret = new ArrayList<>();
        for(String s  : list ){
                if (s.length() >= minLength && ! ret.contains(s)){
                        ret.add(s);
                }
        }
        return ret.toArray(new String[0]);
    }
}
