package compress;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import File.FileHelper;

public class Util {

	public static final int BUFFER = 1024;
	public static final String EXT = ".gz";
	public void compress(String filename) throws Exception {
		String path= FileHelper.class.getClassLoader().getResource(filename).getPath();
		
		 File file = new File(path);
		 System.out.println(file.getParent());
		 FileInputStream fis=new FileInputStream(file);
		 FileOutputStream fos=new FileOutputStream(path+EXT);
		 compress(fis,fos);
		 fis.close();
		 fos.flush();
		 fos.close();
	}
	
	public void compress(InputStream is,OutputStream os) throws Exception {
		GZIPOutputStream gos = new GZIPOutputStream(os);
		int count;

	    byte data[] = new byte[BUFFER];
	    while((count=is.read(data, 0, BUFFER))!=-1) {
	    	System.out.println(count);
	    	gos.write(data, 0, count);;
	    }
	    gos.finish();
	    gos.flush();
	    gos.close();
	}
	public void decompress(String filename) throws Exception {
		String path= FileHelper.class.getClassLoader().getResource(filename).getPath();
		File file = new File(path);
		 FileInputStream fis=new FileInputStream(file);
		 FileOutputStream fos=new FileOutputStream(path.replace(EXT, ""));
		 
		 decompress(fis,fos);
		 fis.close();
		 fos.flush();
		 fos.close();
	}
	public void decompress(InputStream is,OutputStream os) throws Exception {
		GZIPInputStream gis =new GZIPInputStream(is);
		int count;

	    byte data[] = new byte[BUFFER];
	    while((count=gis.read(data, 0, BUFFER))!=-1) {
	    	os.write(data,0,count);
	    }
	    os.flush();
	    os.close();
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Util util = new Util();
//		util.compress("test.txt");
		util.decompress("test1.txt.gz");
	}

}
