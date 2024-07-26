package com.skill.infrastructure.in;

import java.sql.SQLException;

import com.habilidades.aplication.DeleteHabilidadCase;
import com.skill.aplication.CreateSkillCase;
import com.skill.aplication.FindSkillCase;
import com.skill.aplication.UpdateSkillcase;

public class SkillController {
    private final CreateSkillCase createSkillCase;
    private final FindSkillCase findSkillCase;
    private final UpdateSkillcase updateSkillcase;
    private final DeleteHabilidadCase deleteHabilidadCase;

    public SkillController(CreateSkillCase createSkillCase, FindSkillCase findSkillCase, UpdateSkillcase updateSkillcase, DeleteHabilidadCase deleteHabilidadCase){
        this.createSkillCase = createSkillCase;
        this.findSkillCase = findSkillCase;
        this.updateSkillcase = updateSkillcase;
        this.deleteHabilidadCase = deleteHabilidadCase;
    }

    public void crear() throws SQLException{

    }

    public void buscar() throws SQLException{

    }

    public void actualizar() throws SQLException{

    }

    public void eliminar() throws SQLException{

    }
    
}
