package services;

import model.Query;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QueryService extends LineService{

    public List<Query> getLines(List<String> lines)  {
        String type = "D";
        List<Query> queries = new ArrayList<>(linesCounter(lines, type));
        for (String line : lines) {
            if (line.startsWith("D") && line.split(" ").length == 5) {
                Query currentLine = parseQuery(line);
                queries.add(currentLine);
            }
        }
        return queries;
    }

    private Query parseQuery(String line) {
        String[] lineBlocks = line.split(" ");
        Query query = new Query();
        setTypeToLine(lineBlocks[0], query);
        setServiceToLine(lineBlocks[1], query);
        setQuestionToLine(lineBlocks[2], query);
        setResponseTypeToLine(lineBlocks[3], query);
        try {
            setDateToQuery(lineBlocks[4], query);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return query;
    }

    private void setDateToQuery(String lineBlock, Query query) throws ParseException {
        String[] date = lineBlock.split("-");
        if (date.length == 2) {
            query.setDateFrom(formatter.parse(date[0]));
            query.setDateTo(formatter.parse(date[1]));
        }
        else if (date.length > 0){
            query.setDateFrom(formatter.parse(date[0]));
            query.setDateTo(new Date());
        }
    }
}
