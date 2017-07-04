package my.edu.umk.pams.intake.web.module.system.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.system.model.InModule;
import my.edu.umk.pams.intake.web.module.policy.vo.IntakeSession;
import my.edu.umk.pams.intake.web.module.system.vo.Module;

/**
 * @author PAMS
 */
@Component("systemTransformer")
public class SystemTransformer
{
	public List<Module> toModuleVos(List<InModule> e) {
        List<Module> vos = e.stream()
                .map((e1) -> toModuleVo(e1))
                .collect(Collectors.toList());
        return vos;
    }
	
	public Module toModuleVo(InModule e) {
		Module vo = new Module();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setCanonicalCode(e.getCanonicalCode());
        vo.setDescription(e.getDescription());
        return vo;
    }
}
