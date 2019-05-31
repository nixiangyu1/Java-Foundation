package day22;

import java.io.File;
import java.io.FileFilter;

public class MyFilter01 implements FileFilter{

	@Override
	public boolean accept(File pathname) {
		String s=pathname.getName();
		if (s.endsWith(".java"))
			return true;
		return false;
	}
	
}
