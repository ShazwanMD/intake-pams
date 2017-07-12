package my.edu.umk.pams.intake.web.module.account.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.web.module.identity.vo.User;



/**
 */
@Component("accountTransformer")
public class AccountTransformer {

	// ====================================================================================================
    // USER
    // ====================================================================================================

//    public User toUserVo(InUser user) {
//    	if(null == user) return null;
//        User vo = new User();
//        vo.setId(user.getId());
//        vo.setName(user.getName());
//        vo.setEmail(user.getEmail());
//        vo.setPassword(user.getPassword());
//        vo.setUsername(user.getUsername());
//        return vo;
//    }
//
//    public List<User> toUserVos(List<InUser> user) {
//        List<User> vos = user.stream().map((user1) -> toUserVo(user1)).collect(Collectors.toList());
//        return vos;
//    }
}
