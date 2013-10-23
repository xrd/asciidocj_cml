import org.asciidocj.*;
import java.util.*;
import java.io.*;

class Render {
    public static void main( String[] args ) {
	AsciiDocProcessor asciidoc = new AsciiDocProcessor();
	String markup = readFile( args[ 0 ] );
	System.out.println( "Markup: \n\n" + markup );
	String fullHtml = asciidoc.asciidocToHtml( markup );
	System.out.print( "Output: " + fullHtml );
    }

    private static String getFileViaScanner( String filename ) {
	Scanner in = null;
	try {
	    in = new Scanner(new FileReader( filename ) );
	}
	catch ( IOException ioe ) {
	    System.err.println( "Unable to read file: " + filename );
	}
	String markup = in.toString();
	return markup;
    }

    private static String readFile( String filename ) {
	String everything = null;
	try {
	    BufferedReader br = new BufferedReader(new FileReader(filename));
	    try {
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    
		    while (line != null) {
			sb.append(line);
			sb.append('\n');
			line = br.readLine();
		    }
		    everything = sb.toString();
		} finally {
		    br.close();
		}
	    } catch( IOException ioe ) {
		System.err.println( "Got error reading file: " + filename );
	    } 
	}
	catch( FileNotFoundException fnfe ) {
	    System.err.println( "Could not find file: " + filename );
	}
	return everything;
    }
}