package com.skill.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.skill.domain.enity.Skill;
import com.skill.domain.repository.SkillReposiroty;

public class SkillService {
    private final SkillReposiroty skillReposiroty;

    public SkillService (SkillReposiroty skillReposiroty){
        this.skillReposiroty = skillReposiroty;
        
    }

    public void createSkill(Skill skill) throws SQLException{
        skillReposiroty.save(skill);
    }

    public Skill getSkillById(int id) throws  SQLException{
        return skillReposiroty.findById(id);
    }

    public List<Skill> getAllSkills() throws SQLException{
        return skillReposiroty.findAll();
    }

    public void updateSkill(Skill skill) throws  SQLException{
        skillReposiroty.update(skill);
    }

    public void deleteSkill(int id) throws  SQLException{
        skillReposiroty.delete(id);
    }
}
