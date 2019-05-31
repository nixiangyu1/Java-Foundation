package day22;

import java.io.File;
import java.io.FileFilter;

public class MyFilter implements FileFilter{

	@Override
	public boolean accept(File pathname) {
		String name =pathname.getName();
		return name.endsWith(".ini");
		
	}
	
}
