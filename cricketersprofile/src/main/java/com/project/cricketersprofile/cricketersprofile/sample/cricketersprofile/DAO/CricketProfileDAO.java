package com.project.cricketersprofile.cricketersprofile.sample.cricketersprofile.DAO;

import com.project.cricketersprofile.cricketersprofile.com.project.cricketersprofile.model.CricketersProfileModel;

import java.util.List;

public interface CricketProfileDAO {
    public abstract int createProfile(CricketersProfileModel cricketersProfileModel);
    public abstract List<CricketersProfileModel> getProfiles();

}
