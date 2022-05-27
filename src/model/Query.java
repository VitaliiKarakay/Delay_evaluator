package model;

import java.util.Date;

public class Query extends Line{

    //D service_id[.variation_id] question_type_id[.category_id.[sub-category_id]] P/N date_from[-date_to]

    private Date dateFrom;
    private Date dateTo;

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public String toString() {
        return "Query{" +
                "type='" + super.getType() + '\'' +
                ", serviceId='" + super.getServiceId() + '\'' +
                ", variationId='" + super.getVariationId() + '\'' +
                ", questionTypeId='" + super.getQuestionTypeId() + '\'' +
                ", categoryId='" + super.getCategoryId() + '\'' +
                ", subCategoryId='" + super.getSubCategoryId() + '\'' +
                ", responseType='" + super.getResponseType() + '\'' +
                "dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
