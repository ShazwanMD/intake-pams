package my.edu.umk.pams.intake.common.dao;

import my.edu.umk.pams.intake.common.model.InLocationCode;
import my.edu.umk.pams.intake.core.GenericDao;

import java.util.List;

@Deprecated
public interface InLocationCodeDao extends GenericDao<Long, InLocationCode> {

    InLocationCode findByCode(String code);

    List<InLocationCode> find(String filter, Integer offset, Integer limit);

    Integer count(String filter);

    boolean isExists(String code);
}
