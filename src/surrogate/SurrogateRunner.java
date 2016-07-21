/*
 * Framework class to run the Surrogate handler code
 */
package surrogate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author RoyQuedlin
 */
public class SurrogateRunner {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
          
        BufferedReader bufferedReader;
        bufferedReader = new BufferedReader(new FileReader("text2.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = bufferedReader.readLine();

            while (line != null) {
                
                System.out.println(Surrogate.replaceSurrogateWithTags(line));
                sb.append(Surrogate.replaceSurrogate(line, "[tag]"));
                sb.append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
            String everything = sb.toString();
            System.out.println(everything);
        } finally {
            bufferedReader.close();
        }
       
    }
    
}
