package zhou;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhouh
 */
public class FileName {
    public String iGMasAddress = "ftp://222.240.181.170/";
    public String IGSAddress = "ftp://123.57.234.5/";
    public String HttpAddress = "http://www.igmas.org/Product/TreePage/downItem/?fid=/products/";

    public String wwwwTime = new String();
    public Calendar data;
    public int hourNumber;
    public int weekNumber;
    public int weekOfYear;
    public HashMap<String, String> time = new HashMap<>();

    public String suffix;
    public String prefix;
    
    public FileName(String pre, String suf) {
        data = Calendar.getInstance();
        for(int i = 2;i < 8;i++) {
        	for(int j1 = 0;j1 < 2;j1++) {
                time.put(String.valueOf(i) + String.valueOf(j1),
                        String.valueOf(i - 2) + "_" + String.valueOf(j1 * 6 + 12));
            }
        	for(int j2 = 2;j2 < 4;j2++) {
                time.put(String.valueOf(i) + String.valueOf(j2),
                        String.valueOf(i - 1) + "_" + "0" + String.valueOf(j2 * 6 - 12));
            }
        }
        time.put("10","6_12");
        time.put("11","6_18");
        time.put("12","0_00");
        time.put("13","0_06");
        suffix = suf;
        prefix = pre;
    }

    public void setTime(Calendar time) {
    	data = time;
        hourNumber = data.get(Calendar.HOUR_OF_DAY);
        weekOfYear = data.get(Calendar.WEEK_OF_YEAR);
        weekNumber = data.get(Calendar.DAY_OF_WEEK);
    	if(weekNumber == 1 && (hourNumber >= 0 && hourNumber < 12)) {
            wwwwTime = "0" + String.valueOf(weekOfYear + 728);
        }
    	else {
            wwwwTime = "0" + String.valueOf(weekOfYear + 729);
        }
    }

    public String getFileName() {
    	String key = String.valueOf(weekNumber);
    	key = key + String.valueOf((int)(hourNumber / 6));
    	String hr = time.get(key);
    	
    	if(suffix.charAt(2) == '_') {
            suffix = "7." + suffix.substring(3);
        }
    	if("isu".equals(prefix)) {
    		return prefix + wwwwTime + hr + suffix + ".Z";
    	}
    		
    	else if(suffix.charAt(0) == '7') {
    		return prefix + wwwwTime + suffix + ".Z";
    	}
    		
    	else {
    		return prefix + wwwwTime + hr.substring(0, 1) + suffix + ".Z";
    	}
    		
    }
    
    public List<String> getRealTimeAddress() {
    	List<String> files = new ArrayList<>();
    	files.add(HttpAddress + "products/" + wwwwTime + "/" + getFileName().substring(0, 8) + ".sp3.Z");
    	files.add(HttpAddress + "products/" + wwwwTime + "/" + getFileName().substring(0, 8) + ".erp.Z");
    	files.add(HttpAddress + "products/" + wwwwTime + "/" + getFileName().substring(0, 8) + ".clk.Z");
    	return files;
    }
    

    public String getFTPDownloadAddress() {
        return iGMasAddress + "products/" + wwwwTime + "/" + getFileName();
    }
    public String getHttpDownloadAddress() {
    	return HttpAddress + "products/" + wwwwTime + "/" + getFileName();
    }
    public String getDir() {
    	return "products/" + wwwwTime + "/";
    }
}
