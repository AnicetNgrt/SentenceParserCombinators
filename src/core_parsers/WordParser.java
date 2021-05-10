package core_parsers;

import core.ParseException;
import core.ParseResult;
import core.Parser;
import core_wrappers.OneOrMoreWP;

import java.util.List;

public class WordParser implements Parser<String> {
    @Override
    public ParseResult<String> parse(String input) throws ParseException {
        Parser<Character> nscParser = new NonWhiteSpaceParser();
        Parser<List<Character>> wordParser = new OneOrMoreWP<Character, NonWhiteSpaceParser>(nscParser);
        ParseResult<List<Character>> pr = wordParser.parse(input);
        StringBuilder output = new StringBuilder();
        for (char c: pr.output) output.append(c);
        return new ParseResult<>(pr.rem, output.toString());
    }
}
