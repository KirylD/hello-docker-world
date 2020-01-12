package by.samsolutions.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HttpRequest {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "id=" + id +
                ", requestDate=" + requestDate +
                '}';
    }
}
