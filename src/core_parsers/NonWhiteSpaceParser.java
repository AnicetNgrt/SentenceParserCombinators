package core_parsers;

import core.ParseException;
import core.ParseResult;
import core.Parser;

public class NonWhiteSpaceParser implements Parser<Character> {
    @Override
    public ParseResult<Character> parse(String input) throws ParseException {
        ParseResult<Character> pr = null;
        if(input.length() > 0) {
            char c = input.charAt(0);
            if(!Character.isWhitespace(c)) {
                pr = new ParseResult<>(input.substring(1), c);
            } else {
                throw new ParseException(input, c+" is not a valid non-space char");
            }
        } else {
            throw new ParseException(input, "Empty string is not a valid char");
        }
        return pr;
    }
}
