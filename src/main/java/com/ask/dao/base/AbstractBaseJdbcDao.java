package com.ask.dao.base;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.ask.model.AbstractBaseModel;


/**
 * TODO class purpose description
 * 
 * @author 
 * @version 1.0 Revise History:
 * 
 */
public class AbstractBaseJdbcDao<T extends AbstractBaseModel, PK extends Serializable> extends JdbcDaoSupport implements Serializable, IGeneralJdbcDao<T, PK> {


    private static final long serialVersionUID = 6159802348633218861L;
    private Log log = LogFactory.getLog(getClass());

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Log getLog() {
        return log;
    }

}
