package services;

import model.Timeline;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TimelineService extends LineService{

    public List<Timeline> getLines(List<String> lines) {
        String type = "C";
        List<Timeline> timelines = new ArrayList<>(linesCounter(lines, type));
        for (String line : lines) {
            if (line.startsWith(type) && line.split(" ").length == 6) {
                Timeline currentLine = parseTimeLine(line);
                timelines.add(currentLine);
            }
        }
        return timelines;
    }

    private Timeline parseTimeLine(String line) {
        String[] lineBlocks = line.split(" ");
        Timeline timeline = new Timeline();
        setTypeToLine(lineBlocks[0], timeline);
        setServiceToLine(lineBlocks[1], timeline);
        setQuestionToLine(lineBlocks[2], timeline);
        setResponseTypeToLine(lineBlocks[3], timeline);
        setDateToTimeline(lineBlocks[4], timeline);
        setTimeToTimeline(lineBlocks[5], timeline);
        return timeline;
    }

    private void setDateToTimeline(String lineBlock, Timeline timeline) {
        try {
            timeline.setDate(formatter.parse(lineBlock));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void setTimeToTimeline(String lineBlock, Timeline timeline) {
        timeline.setTime(Integer.parseInt(lineBlock));
    }

}
