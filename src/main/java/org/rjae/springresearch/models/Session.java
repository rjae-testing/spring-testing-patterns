package org.rjae.springresearch.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "sessions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session {
    @Column(name = "description")
    @JsonProperty("description")
    private String itsDescription;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Long itsId;
    @Column(name = "length")
    @JsonProperty("length")
    private Integer itsLength;
    @Column(name = "name")
    @JsonProperty("name")
    private String itsName;
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

    public String getDescription() {
        return itsDescription;
    }

    public Long getId() {
        return itsId;
    }

    public Integer getLength() {
        return itsLength;
    }

    public String getName() {
        return itsName;
    }

    public List<Speaker> getSpeakers() {
        return itsSpeakers;
    }

    public void setDescription(String description) {
        this.itsDescription = description;
    }

    public void setId(Long id) {
        this.itsId = id;
    }

    public void setLength(Integer length) {
        this.itsLength = length;
    }

    public void setName(String name) {
        this.itsName = name;
    }

    public void setSpeakers(List<Speaker> speakers) {
        itsSpeakers = speakers;
    }
}

