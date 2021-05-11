package core_combinators;

import core.ParseException;
import core.ParseResult;
import core.Parser;
import core.ParserCombinator;

import java.util.List;
import java.util.Map;

public class JoinPC<O> extends ParserCombinator<List<O>, List<O>, List<O>> {
    public JoinPC(Parser<List<O>> parserA, Parser<List<O>> parserB) {
        super(parserA, parserB);
    }

    @Override
    public ParseResult<List<O>> parse(String input) throws ParseException {
        PairPC<List<O>, List<O>> pairPc = new PairPC<>(parserA, parserB);
        ParseResult<Map.Entry<List<O>, List<O>>> prNotJoined = pairPc.parse(input);
        List<O> poA = prNotJoined.output.getKey();
        List<O> poB = prNotJoined.output.getValue();
        poA.addAll(poB);
        return new ParseResult<>(prNotJoined.rem, poA);
    }
}
