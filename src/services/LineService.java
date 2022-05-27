package services;

import model.Line;

import java.text.SimpleDateFormat;
import java.util.List;

public abstract class LineService {

    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

    public int linesCounter(List<String> lines, String type) {
        int linesCount = 0;
        for (String line : lines) {
            if (line.startsWith(type)) {
                linesCount += 1;
            }
        }
        return linesCount;
    }

    protected void setTypeToLine(String lineBlock, Line line) {
        line.setType(lineBlock);
    }

    protected void setServiceToLine(String lineBlock, Line line) {
        if (lineBlock.split("\\.").length == 2) {
            line.setServiceId(lineBlock.split("\\.")[0]);
            line.setVariationId(lineBlock.split("\\.")[1]);
        } else {
            line.setServiceId(lineBlock);
            line.setVariationId("");
        }
    }

    protected void setQuestionToLine(String lineBlock, Line line) {
        if (lineBlock.split("\\.").length == 1) {
            line.setQuestionTypeId(lineBlock);
            line.setCategoryId("");
            line.setSubCategoryId("");
        }
        if (lineBlock.split("\\.").length == 2) {
            line.setQuestionTypeId(lineBlock.split("\\.")[0]);
            line.setCategoryId(lineBlock.split("\\.")[1]);
            line.setSubCategoryId("");
        }
        if (lineBlock.split("\\.").length == 3) {
            line.setQuestionTypeId(lineBlock.split("\\.")[0]);
            line.setCategoryId(lineBlock.split("\\.")[1]);
            line.setSubCategoryId(lineBlock.split("\\.")[2]);
        }
    }

    protected void setResponseTypeToLine(String lineBlock, Line line) {
        line.setResponseType(lineBlock);
    }
}
