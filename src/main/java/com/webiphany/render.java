//import org.asciidocj.*;
import static org.asciidoctor.Asciidoctor.Factory.create;
import org.asciidoctor.Asciidoctor;
import java.util.*;
import java.io.*;

class Render {
    public static void main( String[] args ) {
	Asciidoctor asciidoctor = create();
	String markup = readFile( args[0] );
	String fullHtml = asciidoctor.render( markup, Collections.EMPTY_MAP);
	System.out.print( "Output: " + fullHtml );
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