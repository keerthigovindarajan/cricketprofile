package com.project.cricketersprofile.cricketersprofile.project.cricketersprofile.Controller;

import com.project.cricketersprofile.cricketersprofile.com.project.cricketersprofile.model.CricketersProfileModel;
import com.project.cricketersprofile.cricketersprofile.sample.cricketersprofile.DAO.CricketProfileDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CricketProfileController {
    @Autowired
    CricketProfileDAO cricketProfileDAO;
    @RequestMapping(path="/profiles",method = RequestMethod.POST)
    public ResponseEntity<Object> createProfile(@RequestBody  CricketersProfileModel cricketersProfileModel)
    {
        cricketProfileDAO.createProfile(cricketersProfileModel);
        return new ResponseEntity<>("Profile is created successfully", HttpStatus.OK);
    }
    @RequestMapping(path = "/profiles",method = RequestMethod.GET)
    public ResponseEntity<Object> getProfiles()
    {
        return new ResponseEntity<>(cricketProfileDAO.getProfiles(),HttpStatus.OK);
    }

}
