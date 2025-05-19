package csc300;

/*
 * Lillian Hunt
 * Section 502
 * 
 * 
 * This class represents an XML token, which can be a tag (e.g., <tag>) or text content in an XML file.
 * It provides methods to check whether a token is an XML tag, whether it's an opening or closing tag,
 * and retrieve the name of the tag.
 */
public class XMLToken {
    private String token; // Stores the XML token as a string
    
    // Constructor: Initializes the XMLToken object with a given token
    public XMLToken(String token) {
        this.token = token;
    }
    
    /**
     * Checks if the token is an XML tag.
     * A token is considered a tag if it starts with '<' and ends with '>'.
     *
     * @return true if the token is a tag, false otherwise.
     */
    public boolean isTag() {
        if (token.length() >= 3 && token.charAt(0) == '<' && token.charAt(token.length() - 1) == '>') {
            return true; // The token is an XML tag
        }
        return false; // The token is not an XML tag
    }
    
    /**
     * Checks if the token is an opening XML tag.
     * An opening tag starts with '<' and does NOT have '/' immediately after '<'.
     * Example: <tag> is an opening tag, while </tag> is not.
     *
     * @return true if the token is an opening tag, false otherwise.
     */
    public boolean isOpeningTag() {
        if (isTag()) { // First, check if it's a tag
            return token.charAt(1) != '/'; // It's an opening tag if the second character is NOT '/'
        }
        return false; // If it's not a tag, it can't be an opening tag
    }
    
    /**
     * Checks if the token is a closing XML tag.
     * A closing tag starts with '</' and ends with '>'.
     * Example: </tag> is a closing tag, while <tag> is not.
     *
     * @return true if the token is a closing tag, false otherwise.
     */
    public boolean isClosingTag() {
        if (isTag()) { // First, check if it's a tag
            return token.charAt(1) == '/'; // It's a closing tag if the second character is '/'
        }
        return false; // If it's not a tag, it can't be a closing tag
    }
    
    /**
     * Retrieves the name of the XML tag without angle brackets ('<' and '>').
     *
     * Example:
     * For <tag>, it returns "tag".
     * For </tag>, it returns "/tag" (with the slash, since it belongs to the tag name).
     *
     * @return the name of the tag as a string, or null if the token is not a tag.
     */
    public String getTagName() {
        if (isTag()) { // First, check if it's a tag
            return token.substring(1, token.length() - 1); // Extract everything between '<' and '>'
        }
        return null; // If it's not a tag, return null
    }
}

