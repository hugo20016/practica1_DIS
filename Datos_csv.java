import java.util.Date;

public class Datos {

    public String series_reference;
    public Date period;
    public float data_value;
    public char status;
    public String units;
    public String subject;
    public String group;
    public String series_title_1;
    public String series_title_2;

    public void setData_value(float data_value) {
        this.data_value = data_value;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setSeries_reference(String series_reference) {
        this.series_reference = series_reference;
    }

    public void setSeries_title_1(String series_title_1) {
        this.series_title_1 = series_title_1;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getSeries_title_1() {
        return series_title_1;
    }

    public void setSeries_title_2(String series_title_2) {
        this.series_title_2 = series_title_2;
    }

    public float getData_value() {
        return data_value;
    }

    public Date getPeriod() {
        return period;
    }

    public String getSeries_title_2() {
        return series_title_2;
    }

    public String getGroup() {
        return group;
    }

    public String getSeries_reference() {
        return series_reference;
    }

    public char getStatus() {
        return status;
    }

    public String getSubject() {
        return subject;
    }

    public String getUnits() {
        return units;
    }
}
