package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class EventDetails extends AbstractEntity{

    @Size(max=500, message = "Description is too long.")
    private String description;

    @Email( message = "Invalid email. Try again.")
    @NotBlank(message = "Contact email must not be blank")
    private String contactEmail;

    public EventDetails(@Size(max=500, message="Description is too long")String description,
                        @NotBlank (message="Email is Required")
                        @Email (message = "InValid Email!")
                        String contactEmail) {
        this.description = description;
        this.contactEmail = contactEmail;
    }

    public EventDetails() {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
