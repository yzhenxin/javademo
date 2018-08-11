package cn.example.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteDemo {

	public static void main(String[] args) {
		int count = write(new File("E:/kettle7.1.rar"), new File("E:/copy-kettle7.1.rar"));
		System.out.println("write count " + count);
	}

	public static int write(File source, File dest) {
		int count = 0;
		try {
			FileInputStream fis = new FileInputStream(source);
			BufferedInputStream bis = new BufferedInputStream(fis);
			FileOutputStream fos = new FileOutputStream(dest);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			byte[] b = new byte[1024 * 4];
			int n = 0;
			int writeCount = 0;
			while(-1 != (n = bis.read(b))) {
				System.out.println(n);
				bos.write(b, 0, n);
				count += n;
				writeCount += 1;
			}
			System.out.println("write count = " + writeCount);
			bos.flush();
			
			bis.close();
			fis.close();
			bos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
}
