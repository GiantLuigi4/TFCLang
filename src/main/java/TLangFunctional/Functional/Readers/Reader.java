package TLangFunctional.Functional.Readers;

import Editor.Main;
import TLangFunctional.Functional.Debug.Log.LogLevel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;

public class Reader {
	File path;
	
	public Reader(File path) {
		this.path = path;
	}
	
	public ArrayList<String[]> getAllFiles() {
		ArrayList<String[]> toReturn = new ArrayList<>();
		try {
			JarInputStream stream = new JarInputStream(new FileInputStream(path));
			for (JarEntry entry = stream.getNextJarEntry(); entry != null; entry = stream.getNextJarEntry()) {
				if (entry.isDirectory()) {
//					Main.TLangDebug.print(LogLevel.Info,entry.toString());
				} else {
					if (entry.getName().endsWith(".tclass")) {
						ArrayList<String> strings = new ArrayList<>();
						try {
							InputStream stream1 = new JarFile(path).getInputStream(entry);
							Scanner sc = new Scanner(stream1);
							while (sc.hasNextLine()) {
								strings.add(sc.nextLine());
							}
							sc.close();
							stream1.close();
							String[] clazz = new String[strings.size()];
							for (int i = 0; i < strings.size(); i++) {
								clazz[i] = strings.get(i);
							}
							toReturn.add(clazz);
						} catch (Exception err) {
						}
					}
				}
			}
			Main.TLangDebug.print(LogLevel.Generic, "");
			stream.close();
		} catch (Exception err) {
		}
		return toReturn;
	}
}
