package com.skill.aplication;

import java.sql.SQLException;


import com.skill.domain.service.SkillService;

public class DeleteSkillCase {
        private final SkillService skillService;

    public DeleteSkillCase(SkillService skillService){
        this.skillService = skillService;
    }
    
    public void execute(int id) throws SQLException{
        skillService.deleteSkill(id);
    }
}
