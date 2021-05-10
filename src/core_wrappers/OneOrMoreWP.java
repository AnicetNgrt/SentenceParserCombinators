package core_wrappers;

import core.ParseException;
import core.ParseResult;
import core.Parser;

import java.util.ArrayList;
import java.util.List;

public class OneOrMoreWP<O, P extends Parser<O>> extends ZeroOrMoreWP<O, P> {
    public OneOrMoreWP(Parser<O> parser) {
        super(parser);
    }

    @Override
    public ParseResult<List<O>> parse(String input) throws ParseException {
        ArrayList<O> outputs = new ArrayList<>();
        ParseResult<O> pr = parser.parse(input);
        outputs.add(pr.output);
        ParseResult<List<O>> prs = super.parse(pr.rem);
        outputs.addAll(prs.output);
        return new ParseResult<List<O>>(prs.rem, outputs);
    }
}
