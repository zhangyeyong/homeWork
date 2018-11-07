package test.copyfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/**
 * 
 * @author ZhangYeyong
 *
 *         2018年9月29日
 */
public class Main {
	private static int count = 0;
	private static int PRINT_COUNT = 0;
	private static String EXT_JAVA = ".java";
	private static String EXT_SVN = ".svn";

	public static void main(String[] args) throws IOException {
//		File s = new File("E:/Workspaces_MyEclipse2014/projectUtil/src/projectUtil/Main.java");
//		File t = new File("E:/Main.java");
		Main main = new Main();
		// main.fileChannelCopy(s, t);
		System.out.println("start");
		Long start = System.currentTimeMillis();
		String src = "D:\\code\\easrainbow";
		main.copyFolder(new File(src), new File("d:\\code\\erp_code\\easrainbow"));
		Long end = System.currentTimeMillis();
		System.out.println(src + "\nend   time:" + (end - start) / 1000);
	}

	/**
	 * 
	 * 使用文件通道的方式复制文件
	 * 
	 * 
	 * 
	 * @param s
	 * 
	 *            源文件
	 * 
	 * @param t
	 * 
	 *            复制到的新文件
	 */
	public void fileChannelCopy(File s, File t) {
		FileInputStream fi = null;
		FileOutputStream fo = null;
		FileChannel in = null;
		FileChannel out = null;
		try {
			fi = new FileInputStream(s);
			fo = new FileOutputStream(t);
			// 得到对应的文件通道
			in = fi.getChannel();
			// 得到对应的文件通道
			out = fo.getChannel();
			// 连接两个通道，并且从in通道读取，然后写入out通道
			in.transferTo(0, in.size(), out);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fi.close();
				in.close();
				fo.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 复制一个目录及其子目录、文件到另外一个目录
	 * 
	 * @param src
	 * @param dest
	 * @throws IOException
	 */
	private void copyFolder(File src, File dest) throws IOException {
		count++;
		if (count % PRINT_COUNT == 0) {
			System.out.println("count----->" + count);
		}
		if (src.getName().endsWith(EXT_SVN)) {
			return;
		}
		if (src.isDirectory()) {
			if (!dest.exists()) {
				dest.mkdir();
			}
			String[] files = src.list();
			for (String file : files) {
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// 递归复制
				copyFolder(srcFile, destFile);
			}
		} else {
			if (src.getAbsolutePath().endsWith(EXT_JAVA)) {
				InputStream in = new FileInputStream(src);
				OutputStream out = new FileOutputStream(dest);
				byte[] buffer = new byte[1024];
				int length;
				while ((length = in.read(buffer)) > 0) {
					out.write(buffer, 0, length);
				}
				in.close();
				out.close();
			}
		}
	}
}