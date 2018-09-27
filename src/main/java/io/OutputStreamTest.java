package io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class OutputStreamTest {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ByteArrayOutputStream baos =new ByteArrayOutputStream(20);
		 while( baos.size()!= 20 ) {
	         // 获取用户输入
			 baos.write(System.in.read()); 
	      }
	      byte b [] = baos.toByteArray();
	      System.out.println("Print the content");
	      for(int x= 0 ; x < b.length; x++) {
	         // 打印字符
	         System.out.print((char)b[x]  + "   "); 
	      }
	      baos.reset();
	}

}
