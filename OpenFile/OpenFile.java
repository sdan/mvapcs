/**
 * Utilities for opening a text file. Files will be found and read from,
 * and can be created amd wrttien to.
 *
 * @author Surya Dantuluri
 * @version 1.0
 * @since August 22, 2017
 *
 */

 import java.util.Scanner;
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.io.PrintWriter;

 public class OpenFile{

	 public static void main(String[]args){
		Scanner infile = OpenFile.openToRead("g.txt");
		PrintWriter outfile = OpenFile.openToWrite("gcopy.txt");
		String temp = null;
		while(infile.hasNext()){
			temp = infile.nextLine();
			System.out.println(temp);
			outfile.println(temp);
		}
		infile.close();
		outfile.close();
	 }

	 /**
	  * Oepn a file for reading.
	  * @param fileString     The name of the file to be opened
	  * @return 	          A Scanner instance of a file to be open.
	  */
	 public static Scanner openToRead(String fileString){
		Scanner fromfile = null;
		File filename = new File(fileString);

		try{
			fromfile = new Scanner(filename);
		}catch(FileNotFoundException e){
			System.out.println("\n\nSorry the file could not be found.\n\n");
			System.exit(-1);
		}
		return fromfile;
	 }

	 /**
	  * Oepn a file for writing.
	  * @param fileString     The name of the file to be opened to be created.
	  * @return 	          A PrintWriter instance of a file to be opened(created).
	  */
	 public static PrintWriter openToWrite(String fileString){
	 	PrintWriter outfile = null;
		try{
			outfile = new PrintWriter(fileString);
		}catch(Exception e){
			System.out.println("\n\nSorry the file could not be created.\n\n");
			System.exit(-1);
		}
		return outfile;

	 }


 }
