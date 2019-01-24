package com.project.cricketersprofile.cricketersprofile.sample.cricketersprofile.DAO;

import com.project.cricketersprofile.cricketersprofile.com.project.cricketersprofile.model.CricketersProfileModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.sql.*;
@Repository
public class CricketProfileDAOImplementation implements CricketProfileDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int createProfile(CricketersProfileModel cricketersProfileModel) {
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update((Connection connection)->{
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("insert into profile(name,runs,wickets)values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,cricketersProfileModel.getName());
            preparedStatement.setString(2,cricketersProfileModel.getRuns());
            preparedStatement.setString(3,cricketersProfileModel.getWickets());
            return preparedStatement;
        },keyHolder);
        return keyHolder.getKey().intValue();
    }
    public List<CricketersProfileModel> getProfiles(){
        List<CricketersProfileModel> profileList = new ArrayList<>();
        Collection<Map<String,Object>> rows=null;
        rows=jdbcTemplate.queryForList("select name,runs,wickets,id from profile");
        rows.stream().map((row)-> {
            CricketersProfileModel cricketersProfileModel = new CricketersProfileModel();
            cricketersProfileModel.setName((String) row.get("NAME"));
            cricketersProfileModel.setRuns((String) row.get("RUNS"));
            cricketersProfileModel.setWickets((String) row.get("WICKETS"));
            cricketersProfileModel.setProfileID(String.valueOf(row.get("ID")));
            return cricketersProfileModel;
        }).forEach((ss)->{
            //CricketersProfileModel ss;
            profileList.add(ss);
        });
        return profileList;
    }
}



