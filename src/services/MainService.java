package services;

import model.Query;
import model.Timeline;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainService {
    TimelineService timelineService = new TimelineService();
    QueryService queryService = new QueryService();

    public List<String> readFile() {
        List<String> lines;
        int linesInFileCount = 0;

        String readPath = "request.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(readPath))) {
            linesInFileCount = Integer.parseInt(reader.readLine());
            lines = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            lines = new ArrayList<>();
            e.printStackTrace();
        }
        if (linesInFileCount != lines.size()) {
            System.out.println("Please check the input data. It may be incorrect!");
        }
        return lines;
    }

    public String checkLines(Query query, List<Timeline> timelines) {
        int waitingTimeSum = 0;
        int timelinesCount = 0;
        for (Timeline timeline : timelines) {
            if (!timeline.getServiceId().equals(query.getServiceId()) && !query.getServiceId().equals("*")) {
                continue;
            }
            if (!timeline.getVariationId().equals(query.getVariationId()) && !query.getVariationId().equals("")) {
                continue;
            }
            if (!timeline.getQuestionTypeId().equals(query.getQuestionTypeId()) && !query.getQuestionTypeId().equals("*")) {
                continue;
            }
            if (!timeline.getCategoryId().equals(query.getCategoryId()) && !query.getCategoryId().equals("")) {
                continue;
            }
            if (!timeline.getSubCategoryId().equals(query.getSubCategoryId()) && !query.getSubCategoryId().equals("")) {
                continue;
            }
            if (!timeline.getResponseType().equals(query.getResponseType())) {
                continue;
            }
            if (!timeline.getDate().after(query.getDateFrom()) || !timeline.getDate().before(query.getDateTo())) {
                continue;
            }
            waitingTimeSum = waitingTimeSum + timeline.getTime();
            timelinesCount += 1;
        }
        if (waitingTimeSum == 0) {
            return "-";
        } else {
            return "" + waitingTimeSum / timelinesCount;
        }
    }

    public void writeToFile() {
        List<String> lines = readFile();
        List<Timeline> timelines = timelineService.getLines(lines);
        List<Query> queries = queryService.getLines(lines);
        String check;
        String writePath = "response.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writePath, true))) {
            for (Query query : queries) {
                check = checkLines(query, timelines);
                writer.write(check + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
