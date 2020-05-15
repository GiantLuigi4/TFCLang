package TLangFunctional.Functional.Readers;

import Editor.Main;
import TLangFunctional.Functional.Core.Class.Class;
import TLangFunctional.Functional.Debug.Log.LogLevel;
import TLangFunctional.Functional.Utils.Interface.TLangExtendable;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;

public class Reader implements TLangExtendable {
	File path;
	boolean isJar = false;
	
	public Reader(File path) {
		this.path = path;
		isJar = (path.toString().endsWith(".jar"));
	}
	
	public Class clazz = null;
	
	@Override
	public Class getInstance() {
		return clazz;
	}
	
	@Override
	public Class setInstance(Class clazz) {
		this.clazz = clazz;
		return clazz;
	}
	
	public ArrayList<String[]> getAllFiles() {
		try {
			return (ArrayList<String[]>) TLangExtendable.execute("getAllFiles", new Object[]{}, new String[]{}, this);
		} catch (Exception ignored) {
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
}
