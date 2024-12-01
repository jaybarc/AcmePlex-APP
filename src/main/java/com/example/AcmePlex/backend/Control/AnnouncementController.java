package com.example.AcmePlex.backend.Control;

import com.example.AcmePlex.backend.Entity.Announcement;
import com.example.AcmePlex.backend.Entity.Movie;
import com.example.AcmePlex.backend.Entity.RegisteredUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnnouncementController {

    private ArrayList<Announcement> announcements;
    private ArrayList<RegisteredUser> registeredUsers;
    private ArrayList<String> UserEmails; // List of guest user email addresses
    
    private Date earlyAnnouncementDate;
    private Date publicAnnouncementDate;

    public AnnouncementController(ArrayList<RegisteredUser> registeredUsers, ArrayList<String> UserEmails) {
        this.announcements = new ArrayList<>();
        this.registeredUsers = registeredUsers;
        this.UserEmails = UserEmails;
    }

    /**
     * Creates and publishes a new announcement.
     *
     * @param title   The title of the announcement.
     * @param content The content of the announcement.
     * @return The created Announcement.
     */
    public Announcement createAndPublishAnnouncement(String title, String content, Date earlyAnnouncementDate, Date publicAnnouncementDate, Movie movie_to_annouce) {
        if (title == null || title.isEmpty() || content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Title and content cannot be empty.");
        }

        Announcement announcement = new Announcement(generateAnnouncementId(), earlyAnnouncementDate, publicAnnouncementDate, movie_to_annouce);
        announcements.add(announcement);

        //TODO: IMPLEMENT System TO CHECK IF REGISTERED TO RECEIVE ANNOUNCEMENT EARLY OR NOT
        // why? have i ever?
        notifyRegisteredUsers(announcement);
        notifyGuestUsers(announcement);

        return announcement;
    }

    /**
     * Retrieves all published announcements.
     *
     * @return A list of all announcements.
     */
    public ArrayList<Announcement> getAllAnnouncements() {
        return announcements;
    }

    /**
     * Notifies registered users about the new announcement.
     *
     * @param announcement The announcement to notify about.
     */
    private void notifyRegisteredUsers(Announcement announcement) {
        for (RegisteredUser user : registeredUsers) {
            user.receiveAnnouncement(announcement);
        }
        System.out.println("All registered users have been notified");
    }

    /**
     * Notifies guest users about the new announcement via their email addresses.
     *
     * @param announcement The announcement to notify about.
     */
    private void notifyGuestUsers(Announcement announcement) {
        for (String email : UserEmails) {
            sendEmailToGuest(email, announcement);
        }
        System.out.println("All guest users have been notified");
    }

    /**
     * Sends an email with the announcement to a guest user.
     *
     * @param email        The guest user's email address.
     * @param announcement The announcement to send.
     */
    private void sendEmailToGuest(String email, Announcement announcement) {
        // Simulating sending an email
        System.out.println("Email sent to " + email+ "");
    }

    /**
     * Generates a unique announcement ID.
     *
     * @return A unique string identifier for the announcement.
     */
    private String generateAnnouncementId() {
        return "ANN" + System.currentTimeMillis();
    }
}
