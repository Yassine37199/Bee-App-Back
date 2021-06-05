package com.beeauto.entities;

import com.sun.istack.Nullable;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Region {

    @Id
    @SequenceGenerator(
            name = "region_sequence",
            sequenceName = "region_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "region_sequence"
    )
    private long idRegion;
    private String regionName;

    public Region() {
    }

    public Region(long idRegion, String regionName) {
        this.idRegion = idRegion;
        this.regionName = regionName;
    }

    public long getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(long idRegion) {
        this.idRegion = idRegion;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    // Relation Region / User
    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "idUser" , nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Nullable
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
