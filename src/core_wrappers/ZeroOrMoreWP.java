package core_wrappers;

import core.ParseException;
import core.ParseResult;
import core.Parser;
import core.ParserWrapper;

import java.util.ArrayList;
import java.util.List;

public class ZeroOrMoreWP<O> extends ParserWrapper<O, List<O>> {
    public ZeroOrMoreWP(Parser<O> parser) {
        super(parser);
    }

    @Override
    public ParseResult<List<O>> parse(String input) throws ParseException {
        ArrayList<O> outputs = new ArrayList<>();
        ParseResult<O> pr = new ParseResult<>(input, null);
        try {
            for(int i = 0; i < Integer.MAX_VALUE; i++) {
                pr = parser.parse(pr.rem);
                outputs.add(pr.output);
            }
        } catch(ParseException ignored) {}
        return new ParseResult<>(pr.rem, outputs);
    }
}
