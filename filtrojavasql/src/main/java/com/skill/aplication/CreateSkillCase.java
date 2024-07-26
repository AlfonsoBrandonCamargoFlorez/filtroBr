package com.skill.aplication;

import com.skill.domain.service.SkillService;

public class CreateSkillCase {
    private final SkillService skillService;

    public CreateSkillCase(SkillService skillService){
        this.skillService = skillService;
    }
    
    //public void execute(Skill skill) throws SQLException{
    //    skillService.CreateSkillCase(skill);
    //}
}
