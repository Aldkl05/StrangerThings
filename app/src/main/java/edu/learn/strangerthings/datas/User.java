package edu.learn.strangerthings.datas;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private String id;
    private String name;
    private String portrayedBy;
    private String status;
    private String gender;
    private String eyeColor;
    private String hairColor;
    private String born;
    private List<String> aliases;
    private List<String> otherRelations;
    private List<String> affiliation;
    private List<String> occupation;
    private List<String> residence;
    private List<String> appearsInEpisodes;
    private String photo;

    // Default constructor

    // Constructor with all fields
    public User(String id, String name, String portrayedBy, String status, String gender, String eyeColor, String hairColor,
                String born, List<String> aliases, List<String> otherRelations, List<String> affiliation,
                List<String> occupation, List<String> residence, List<String> appearsInEpisodes, String photo) {
        this.id = id;
        this.name = name;
        this.portrayedBy = portrayedBy;
        this.status = status;
        this.gender = gender;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.born = born;
        this.aliases = aliases;
        this.otherRelations = otherRelations;
        this.affiliation = affiliation;
        this.occupation = occupation;
        this.residence = residence;
        this.appearsInEpisodes = appearsInEpisodes;
        this.photo = photo;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortrayedBy() {
        return portrayedBy;
    }

    public void setPortrayedBy(String portrayedBy) {
        this.portrayedBy = portrayedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public List<String> getOtherRelations() {
        return otherRelations;
    }

    public void setOtherRelations(List<String> otherRelations) {
        this.otherRelations = otherRelations;
    }

    public List<String> getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(List<String> affiliation) {
        this.affiliation = affiliation;
    }

    public List<String> getOccupation() {
        return occupation;
    }

    public void setOccupation(List<String> occupation) {
        this.occupation = occupation;
    }

    public List<String> getResidence() {
        return residence;
    }

    public void setResidence(List<String> residence) {
        this.residence = residence;
    }

    public List<String> getAppearsInEpisodes() {
        return appearsInEpisodes;
    }

    public void setAppearsInEpisodes(List<String> appearsInEpisodes) {
        this.appearsInEpisodes = appearsInEpisodes;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
