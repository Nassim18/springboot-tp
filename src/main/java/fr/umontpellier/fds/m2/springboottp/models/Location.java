package fr.umontpellier.fds.m2.springboottp.models;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="locations")
@Access(AccessType.FIELD)
public class Location {

    private int latitude,longitude ;
    private Date location_date;

    @ManyToMany(mappedBy = "locations")
    @JsonIgnore // Pour ne pas produire des cycles
    private List<User> users;

    @Id
    private long location_id;

    public long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(long location_id) {
        this.location_id = location_id;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public Date getLocation_date() {
        return location_date;
    }

    public void setLocation_date(Date location_date) {
        this.location_date = location_date;
    }


}
