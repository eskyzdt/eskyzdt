package cn.eskyzdt.modules.file;

import cn.hutool.core.lang.UUID;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * file工具
 */
public class FileUtils {

	/**
	 * 将is转为File
	 * @param ins
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static File multipartFileToFile(InputStream ins , String fileName) throws IOException {
		String prefix = getFileNameNoEx(fileName)+ UUID.fastUUID();
		String suffix = "."+getExtensionName(fileName);
		File toFile = File.createTempFile(prefix,suffix);
		OutputStream os = new FileOutputStream(toFile);
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
			os.write(buffer, 0, bytesRead);
		}
		os.close();
		ins.close();
		return toFile;
	}

	/**
	 * 获取文件扩展名
	 *
	 */
	public static String getExtensionName(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot >-1) && (dot < (filename.length() - 1))) {
				return filename.substring(dot + 1);
			}
		}
		return filename;
	}

	/**
	 * 获取不带扩展名的文件名
	 *
	 */
	public static String getFileNameNoEx(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot >-1) && (dot < (filename.length()))) {
				return filename.substring(0, dot);
			}
		}
		return filename;
	}
}