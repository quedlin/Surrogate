/*
 * Surrogate handler code
 */
package surrogate;


/**
 *
 * @author RoyQuedlin
 */
public class Surrogate {
    
    
    /**
     * replaceSurrogate - replaces non BMP characters with a String
     * @param text
     * @param tag
     * @return 
     */
    public static String replaceSurrogate(String text, String tag) {
        return text.replaceAll("[^\u0000-\uffff]", tag);
    }

    /**
     * replaceSurrogateWithTags - can be used to replace all non BMP characters with their hex code value
     * @param text
     * @return 
     */
    public static String replaceSurrogateWithTags(String text) {
        
        char[] ca = text.toCharArray();
        StringBuilder result = new StringBuilder();
        int i=0;
        while (i<ca.length-1) {
            
            if (Character.isSurrogatePair(ca[i],ca[i+1])) {
                String surrogateHexString = Integer.toHexString(Character.toCodePoint(ca[i],ca[i+1]));
                System.out.println("Surrogate: " + surrogateHexString);
                i++;
                result.append("[").append(surrogateHexString).append("]");
            } else {
                result.append(ca[i]);
            }
            if (i==ca.length-2) {
                result.append(ca[i+1]);
            }
          i++;  
        }
        return result.toString();
    }
}
