package org.rjae.springresearch.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name = "speakers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Speaker {
    @Column(name = "bio", length = 2000)
    @JsonProperty("bio")
    private String itsBio;
    @Column(name = "company", length = 50)
    @JsonProperty("company")
    private String itsCompany;
    @Column(name = "first_name", length = 30)
    @JsonProperty("firstName")
    private String itsFirstName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Long itsId;
    @Column(name = "last_name", length = 30)
    @JsonProperty("lastName")
    private String itsLastName;
    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "photo")
    @JsonProperty("photo")
    private byte[] itsPhoto;
    @ManyToMany(mappedBy = "itsSpeakers")
    @JsonIgnore
    private List<Session> itsSessions;
    @Column(name = "title", length = 40)
    @JsonProperty("title")
    private String itsTitle;

    public Speaker() {
    }

    public Speaker(String firstName, String lastName, String title, String company, String bio) {
        itsFirstName = firstName;
        itsLastName = lastName;
        itsTitle = title;
        itsCompany = company;
        itsBio = bio;
    }

    public String getBio() {
        return itsBio;
    }

    public String getCompany() {
        return itsCompany;
    }

    public String getFirstName() {
        return itsFirstName;
    }

    public Long getId() {
        return itsId;
    }

    public String getLastName() {
        return itsLastName;
    }

    public byte[] getPhoto() {
        return itsPhoto;
    }

    public List<Session> getSessions() {
        return itsSessions;
    }

    public String getTitle() {
        return itsTitle;
    }

    public void setBio(String bio) {
        this.itsBio = bio;
    }

    public void setCompany(String company) {
        this.itsCompany = company;
    }

    public void setFirstName(String firstName) {
        this.itsFirstName = firstName;
    }

    public void setId(Long id) {
        this.itsId = id;
    }

    public void setLastName(String lastName) {
        this.itsLastName = lastName;
    }

    public void setPhoto(byte[] photo) {
        itsPhoto = photo;
    }

    public void setSessions(List<Session> sessions) {
        itsSessions = sessions;
    }

    public void setTitle(String title) {
        this.itsTitle = title;
    }
}
