package homework_2016_3_10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;


public class CodeCount {

	public static final Set<String> OUT_FILE;
	
	static {
		OUT_FILE = new HashSet<String>();

		OUT_FILE.add("CodeCount.java");
	}
	

	public long code;

	public long doc;

	public long sp;
	
	private CodeCount(){}

	private void conuntAllFile(File dir) throws Exception {
		File[] childs = dir.listFiles();
		for (int i = 0; i < childs.length; i++) {
			if(OUT_FILE.contains(childs[i].getName())) {
				continue;
			}
			if (childs[i].isDirectory()) {
				this.conuntAllFile(childs[i]);
			} else if (childs[i].getName().matches(".*\\.java$")) {
				this.countCodeInFile(childs[i]);
			}
		}
	}


	private void countCodeInFile(File file) throws Exception {
		BufferedReader br = null;
		boolean isComment = false;
		br = new BufferedReader(new FileReader(file));
		String line = "";
		while ((line = br.readLine()) != null) {
			line = line.trim();
			if (line.matches("^[\\s&&[^\\n]]*$")) {
				this.sp++;
			} else if (line.startsWith("/*") || isComment) {
				this.doc++;
				isComment = !line.endsWith("*/");
			} else if (line.startsWith("//")) {
				this.doc++;
			} else {
				this.code++;
			}
		}
		br.close();
	}

	public static void main(String[] args) throws Exception {
		CodeCount count = new CodeCount();
		count.conuntAllFile(new File("src"));
		System.out.println("代码行: \t" + count.code);
		System.out.println("注释行: \t" + count.doc);
		System.out.println("空行：\t" + count.sp);
	}
}