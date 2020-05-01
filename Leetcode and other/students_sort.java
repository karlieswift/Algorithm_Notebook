package leetcode;
import java.util.*;
/**
 * 学生排序类排序
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年4月30日
 * @version "13.0.1"
 */
public class students_sort implements Comparable<students_sort>{  
    private String Name;  
    private int Score;  
    private int choose;
    public students_sort() {    
   }
    public students_sort(int choose) {  
    	 this.choose = choose;  
    }    
    public String get_Name() {  
        return Name;  
    }  
    public void set_Name(String name) {  
        this.Name = name;  
    }  
    public int get_Score() {  
        return Score;  
    }  
    public void set_Score(int score) {  
        this.Score = score;  
    }   
    public int compareTo(students_sort o) {   
    	if (this.Score>o.get_Score()) {  
    		if(o.choose==1) return 1;
            if(o.choose==0) return -1;  
        }
    	if (this.Score<o.get_Score()) {  
    		if(o.choose==1) return -1;
            if(o.choose==0) return 1;  
        }
        return 0;  
    }
    public static void main(String[] args) {  
    	Scanner scan=new Scanner(System.in);
    	while(scan.hasNext()) {
    		List<students_sort> list = new ArrayList<students_sort>(); 
		    int counts=scan.nextInt();
		    int choose=scan.nextInt();
		    for(int i=0;i<counts;i++) {
		    	students_sort os=new students_sort(choose);
			    os.Name=scan.next();
			    os.Score=scan.nextInt();			
			    list.add(os);
			    }   
		    Collections.sort(list);  
		    for (int i=0;i<counts;i++) {  
		    	System.out.println(list.get(i).Name+" "+list.get(i).Score);    
		    	}	    
//	        for (students_sort o : list) {  
//          System.out.println(o.get_Name() + "-->" + o.get_Score());  
//      }  
    	}
    }
    }
	 