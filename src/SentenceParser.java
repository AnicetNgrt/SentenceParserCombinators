import core.ParseException;
import core.ParseResult;
import core.Parser;
import core_combinators.AppendRightPC;
import core_combinators.LeftPC;
import core_parsers.WhiteSpaceParser;
import core_parsers.WordParser;
import core_wrappers.OneOrMoreWP;
import core_wrappers.ZeroOrMoreWP;

import java.util.List;

public class SentenceParser implements Parser<List<String>> {

    private final Parser<List<String>> parser;

    public SentenceParser() {
        Parser<String> wordParser = new WordParser();
        Parser<Character> whitespaceParser = new WhiteSpaceParser();
        Parser<List<Character>> separationParser = new OneOrMoreWP<>(whitespaceParser);
        Parser<String> separatedWordParser = new LeftPC<>(wordParser, separationParser);
        Parser<List<String>> zomSeparatedWordsParser = new ZeroOrMoreWP<>(separatedWordParser);
        parser = new AppendRightPC<>(zomSeparatedWordsParser, wordParser);
    }

    @Override
    public ParseResult<List<String>> parse(String input) throws ParseException {
        try {
            return parser.parse(input);
        } catch (ParseException ignored) {
            throw new ParseException(input, "Not a valid sentence.");
        }
    }
}
