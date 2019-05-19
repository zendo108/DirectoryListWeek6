import java.io.File;
import java.util.Scanner;
       /**
        * This program lists the files in a directory specified by
        * the user.  The user is asked to type in a directory name.
        * If the name entered by the user is not a directory, a
        * message is printed and the program ends.
        */
public class DirectoryList {
	
      public static void main(String[] args) {
    	  
        String directoryName;  // Directory name entered by the user.
		File directory;
		String[] files;
		Scanner scanner;
		// File object referring to the directory.
		// Array of file names in the directory.
		// For reading a line of input from the user.
		scanner = new Scanner(System.in);  // scanner reads from standard input.
		System.out.print("Enter a directory name: ");
		directoryName = scanner.nextLine().trim();
		directory = new File(directoryName);
		
		if (directory.isDirectory() == false) {
		    if (directory.exists() == false)
		       System.out.println("There is no such directory!");
		    else
		       System.out.println("That file is not a directory.");
		} else {
			System.out.println("Files in directory \"" + directory + "\":");
			int depth = 0;
			printFiles(directory,depth);
//		    files = directory.list();
//		    System.out.println("Files in directory \"" + directory + "\":");
//		    for (int i = 0; i < files.length; i++)
//		       System.out.println("   " + files[i]);
		}
	} // end main()
      
      static void printFiles(File dir, int d) {
    	  String[] files = dir.list();
		    for (int i = 0; i < files.length; i++) {
		    	//Put together path string
		    	String subDirString = dir+"/"+files[i];
		    	//create file with path
		    	File f = new File(subDirString);
		    	//test if f is folder
		    	String tabs = "";
		    	for(int j=0;j<d;j++) {
		    		tabs += "  ";
		    	}
//		    	System.out.println(tabs + files[i] + " Folder:" + f.isDirectory());
		    	
		    	System.out.println(tabs+files[i]);
		    	if(f.isDirectory())
		    		printFiles(f,(d+1));
		    	
		    }
      }
} // end class DirectoryList



