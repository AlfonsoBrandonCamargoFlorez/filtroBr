package com.skill.aplication;

import com.skill.domain.service.SkillService;

public class FindSkillCase {
            private final SkillService skillService;

    public FindSkillCase(SkillService skillService){
        this.skillService = skillService;
    }
    
    //public void execute(int id) throws SQLException{
    //   return skillService.getSkillById(id);
    //}
    
}
