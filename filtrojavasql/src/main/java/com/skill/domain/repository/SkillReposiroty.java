package com.skill.domain.repository;

import java.sql.SQLException;
import java.util.List;

import com.skill.domain.enity.Skill;



public interface  SkillReposiroty {
    void save(Skill skill) throws  SQLException;
    Skill findById(int id) throws  SQLException;
    List<Skill>findAll() throws  SQLException;
    void update(Skill skill) throws  SQLException;
    void delete(int id) throws  SQLException;
   
    
}
