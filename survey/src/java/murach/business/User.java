package murach.business;

import java.io.Serializable;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String dateOfBirth;
    private String hearAbout;
    private String announceOffers;      
    private String announceEmails;       
    private String contactMethod;

    public User() { }

    public User(String firstName, String lastName, String email,
                String dateOfBirth, String hearAbout,
                String announceOffers, String announceEmails,
                String contactMethod) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.hearAbout = hearAbout;
        this.announceOffers = announceOffers;
        this.announceEmails = announceEmails;
        this.contactMethod = contactMethod;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getHearAbout() { return hearAbout; }
    public void setHearAbout(String hearAbout) { this.hearAbout = hearAbout; }
    public String getAnnounceOffers() { return announceOffers; }
    public void setAnnounceOffers(String announceOffers) { this.announceOffers = announceOffers; }
    public String getAnnounceEmails() { return announceEmails; }
    public void setAnnounceEmails(String announceEmails) { this.announceEmails = announceEmails; }
    public String getContactMethod() { return contactMethod; }
    public void setContactMethod(String contactMethod) { this.contactMethod = contactMethod; }
}

