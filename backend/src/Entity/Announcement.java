package Entity;

import java.util.Date;

public class Announcement {
    private String annoucementID;
    private Date earlyAnnoucementDate;
    private Date publicAnnoucementDate;
    private Movie movie_to_annouce;
    
    public Announcement(String annoucementID, Date earlyAnnoucementDate, Date publicAnnoucementDate, Movie movie_to_annouce) {
        this.annoucementID = annoucementID;
        this.earlyAnnoucementDate = earlyAnnoucementDate;
        this.publicAnnoucementDate = publicAnnoucementDate;
        this.movie_to_annouce = movie_to_annouce;
    }
    
    public String getAnnoucementID() {
        return annoucementID;
    }
    
    public void setAnnoucementID(String annoucementID) {
        this.annoucementID = annoucementID;
    }
    
    public Date getEarlyAnnoucementDate() {
        return earlyAnnoucementDate;
    }
    
    public void setEarlyAnnoucementDate(Date earlyAnnoucementDate) {
        this.earlyAnnoucementDate = earlyAnnoucementDate;
    }
    
    public Date getPublicAnnoucementDate() {
        return publicAnnoucementDate;
    }
    
    public void setPublicAnnoucementDate(Date publicAnnoucementDate) {
        this.publicAnnoucementDate = publicAnnoucementDate;
    }
    
    public Movie getMovie_to_annouce() {
        return movie_to_annouce;
    }
    
    public void setMovie_to_annouce(Movie movie_to_annouce) {
        this.movie_to_annouce = movie_to_annouce;
    }
}
