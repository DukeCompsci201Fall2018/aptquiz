import java.util.*; 
public class Closet { 
        public String anywhere(String[] list) { 
                TreeSet<String> set = new TreeSet<>(); 
                for(String s : list){ 
                        for (String x : s.split(" ")) { 
                                set.add(x); 
                        } 
                } 
                return String.join(" ",set); 
        } 
} 

