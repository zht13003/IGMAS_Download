package zhou;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.compress.compressors.z.ZCompressorInputStream;

/**
 * @author zhouh
 */
public class Download {

	public static class Unzip {
		public static final String TAG = "ZIP";
		public static File unZFile(File file, String outPath){
			int bufferSize = 2048;
			FileOutputStream out = null;
			ZCompressorInputStream zIn = null;
			try {
				FileInputStream fin = new FileInputStream(file);
				BufferedInputStream in = new BufferedInputStream(fin);
				String name = file.getName().substring(0, file.getName().lastIndexOf("."));
				File outFile = new File(outPath + File.separator + name);
				out = new FileOutputStream(outFile);
				zIn = new ZCompressorInputStream(in);
				final byte[] buffer = new byte[bufferSize];
				int n = 0;
				while(-1 != (n = zIn.read(buffer))) {
					out.write(buffer, 0, n);
				}
				return outFile;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
			finally {
				try {
					out.close();
					zIn.close();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		public static void unGFile(String archive, String decompressDir) throws Exception{
			GZIPInputStream gZip = new GZIPInputStream(new FileInputStream(archive));
			FileOutputStream out = new FileOutputStream(decompressDir);
			int len;
			byte[] buffer = new byte[1024];
			while((len = gZip.read(buffer)) != -1) {
				out.write(buffer, 0, len);
				out.flush();
			}
			gZip.close();
			out.close();
		}
	}
	
	
	public static void download(String downloadUrl, File file) {
		try {
			FileOutputStream f = new FileOutputStream(file);
			URL url = new URL(downloadUrl);
			URLConnection connection = url.openConnection();
			InputStream input = connection.getInputStream();
			int len = 0;
			byte[] bytes = new byte[1024];
			while((len = input.read(bytes)) != -1) {
				f.write(bytes, 0, len);
			}
			f.close();
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void FTPdownload(String address, String dir, String fileName, String path) {
		//1.85.15.78
		FTPClient ftp = new FTPClient();
		try {
			ftp.connect(address);
			ftp.login("anonymous", "123456");
			int reply = ftp.getReplyCode();
			System.out.println(reply);
			ftp.enterLocalPassiveMode();
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftp.changeWorkingDirectory(dir);
			OutputStream f = new FileOutputStream(path + fileName);
			ftp.retrieveFile(fileName, f);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void downloadList(List<String> file, List<Integer> date1, List<Integer> date2, String dir) {
		List<String> downloadAddress = new ArrayList<String>();
		List<String> downloadFile = new ArrayList<String>();
		Calendar now = Calendar.getInstance();
		
		for(int i = 0;i < file.size();i++) {
			now.set(date2.get(0), date2.get(1) - 1, date2.get(2), date2.get(3), date2.get(4), date2.get(5));
			String list = file.get(i);
			String temp = String.valueOf(list.charAt(3));
			if(temp.equals("7")) {
				temp = "7.";
			}
			else {
				temp = ".";
			}
			FileName name = new FileName(list.substring(0, 3).toLowerCase(),
					temp + list.substring(4).toLowerCase());
			while(now.get(Calendar.DATE) > date1.get(2)
					|| (now.get(Calendar.HOUR_OF_DAY) > date1.get(3) 
						&& now.get(Calendar.DATE) == date1.get(2))) {
				name.setTime(now);
				downloadAddress.add(name.getHttpDownloadAddress());
				downloadFile.add(name.getFileName());
				now.add(Calendar.HOUR_OF_DAY, -6);
			}
		}
		List uniqueList1 = downloadAddress.stream().distinct().collect(Collectors.toList());
		List uniqueList2 = downloadFile.stream().distinct().collect(Collectors.toList());
		System.out.println(uniqueList2);

		for(int i = 0;i < uniqueList1.size();i++) {
			downloadAndDepress(uniqueList1.get(i).toString(), uniqueList2.get(i).toString(), dir);
		}
//		for(String s: uniqueList.toString()) {
//			System.out.println(s);
//		}
	}
	
	public static void downloadRealTime(String dir)   {
		String[] suffix= {".erp", ".sp3", ".clk"};
		for(int i = 0;i < 3;i++) {
			FileName name = new FileName("isu", suffix[i]);
			name.setTime(Calendar.getInstance());
			downloadAndDepress(name.getHttpDownloadAddress().toString(), name.getFileName().toString(), dir);
		}
	}
	
	public static void downloadAndDepress(String downloadAddress, String fileName, String dir) {
		download(downloadAddress, new File(dir + "\\" + fileName));
		try {
			Unzip.unGFile(dir + "\\" + fileName,
					dir + "\\" + fileName.substring(0, fileName.lastIndexOf(".")) + ".txt");
			//File file = new File("D:\\isu07350_00.sp3.Z");
			//UNZIP.unZFile(file, "D:\\");
		} catch (Exception e) {
			e.printStackTrace();
		}
		File f = new File(dir + "\\" + fileName);
		f.delete();
	}
	
}
