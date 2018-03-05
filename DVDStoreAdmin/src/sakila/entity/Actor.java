/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakila.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lg
 */
public class Actor implements Serializable {

    private Short actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate;

    public Actor() {
    }

    public Actor(String firstName, String lastName, Date lastUpdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    public Short getActorId() {
        return actorId;
    }

    public void setActorId(Short actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
