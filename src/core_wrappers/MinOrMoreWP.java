package core_wrappers;

import core.ParseException;
import core.ParseResult;
import core.Parser;
import core.ParserWrapper;

import java.util.ArrayList;
import java.util.List;

public class MinOrMoreWP<O> extends ParserWrapper<O, List<O>> {
    public final int min;

    public MinOrMoreWP(Parser<O> parser, int min) {
        super(parser);
        this.min = min;
    }

    @Override
    public ParseResult<List<O>> parse(String input) throws ParseException {
        ArrayList<O> outputs = new ArrayList<>();
        ParseResult<O> pr = new ParseResult<>(input, null);
        int count = 0;
        try {
            while(count < Integer.MAX_VALUE) {
                pr = parser.parse(pr.rem);
                outputs.add(pr.output);
                count++;
            }
        } catch(ParseException e) {
            if(count < min) {
                throw e;
            }
        }
        return new ParseResult<>(pr.rem, outputs);
    }
}
