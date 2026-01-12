package main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class KevinBacon {
    
    Graph<???> g; // change this, this is intended to be the Graph object used throughout.

    public KevinBacon(){
        // Constructor
        try {
			g = loadFiles();
		}
		catch(IOException e) {
			e.printStackTrace();
		} 
    }

    public Graph loadFiles() throws IOException {
        
        // the the files into a BufferedReader
        BufferedReader actorsIn = new BufferedReader(new FileReader("files/actors.txt"));
		BufferedReader maIn = new BufferedReader(new FileReader("files/movie-actors.txt"));
		BufferedReader moviesIn = new BufferedReader(new FileReader("files/movies.txt"));

        // loop through all the lines in the file:
        String line = actorsIn.readLine();
        while ( line != null && line.trim().length() != 0) {
            //do some stuff here...

            line = actorsIn.readLine(); // get the next line
        } //loop through the next line of the file.

        return null; // you'll want to change this...

    }

    // This method should ensure that the name of the movie or actor is Camel Case
    public static String capitalize(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'') { // You can add other chars here
                found = false;
            }
        }
        return String.valueOf(chars);
    }


    //Main creates a KevinBacon object (calling constructor)
    //and starts everything off
    public static void main(String[] args) {
       new KevinBacon();
    }
}