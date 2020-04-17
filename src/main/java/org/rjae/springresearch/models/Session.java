package org.rjae.springresearch.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "sessions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Long itsId;
    @Column(name = "name")
    @JsonProperty("name")
    private String itsName;
    @Column(name = "description")
    @JsonProperty("description")
    private String itsDescription;
    @Column(name = "length")
    @JsonProperty("length")
    private Integer itsLength;
    @ManyToMany
    @JoinTable(name = "session_speakers", joinColumns = @JoinColumn(name = "session_id"), inverseJoinColumns = @JoinColumn(name = "speaker_id"))
    private List<Speaker> itsSpeakers = new ArrayList<>();

    public Session() {
    }

    public Session(String name, String description, Integer length) {
        itsName = name;
        itsDescription = description;
        itsLength = length;
    }

    public List<Speaker> getSpeakers() {
        return itsSpeakers;
    }

    public Long getId() {
        return itsId;
    }

    public String getName() {
        return itsName;
    }

    public String getDescription() {
        return itsDescription;
    }

    public Integer getLength() {
        return itsLength;
    }

    public void setSpeakers(List<Speaker> speakers) {
        itsSpeakers = speakers;
    }

    public void setId(Long id) {
        this.itsId = id;
    }

    public void setName(String name) {
        this.itsName = name;
    }

    public void setDescription(String description) {
        this.itsDescription = description;
    }

    public void setLength(Integer length) {
        this.itsLength = length;
    }
}

