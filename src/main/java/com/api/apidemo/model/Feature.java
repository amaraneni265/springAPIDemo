package com.api.apidemo.model;


import com.sun.istack.NotNull;
import org.aspectj.lang.annotation.RequiredTypes;

import javax.persistence.*;

@Entity
@Table(name = "features")
public class Feature {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="featureName")
    private String featureName;


    @Column(name="email")
    private String email;

    @Column(name="enable")
    private  boolean enable;


    public Feature()
    {

    }

    public Feature(String featureName,String email,boolean  enable) {
          this.featureName = featureName;
          this.email = email;
          this.enable = enable;
    }

    public long getId() {
        return id;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isEnable() {
        return enable;
    }
}
