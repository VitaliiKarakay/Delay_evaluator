package model;

import java.util.Date;

public class Timeline extends Line{

    //C service_id[.variation_id] question_type_id[.category_id.[sub-category_id]] P/N date time

    private Date date;
    private int time;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Timeline{" +
                "type='" + super.getType() + '\'' +
                ", serviceId='" + super.getServiceId() + '\'' +
                ", variationId='" + super.getVariationId() + '\'' +
                ", questionTypeId='" + super.getQuestionTypeId() + '\'' +
                ", categoryId='" + super.getCategoryId() + '\'' +
                ", subCategoryId='" + super.getSubCategoryId() + '\'' +
                ", responseType='" + super.getResponseType() + '\'' +
                "date=" + date +
                ", time=" + time +
                '}';
    }
}
