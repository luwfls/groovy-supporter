package com.groovy.supporter.manager.service.impl;

import com.groovy.supporter.common.domain.MethodDO;
import com.groovy.supporter.common.domain.MethodDOExample;
import com.groovy.supporter.manager.dao.MethodDOMapper;
import com.groovy.supporter.manager.service.GroovySupporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class GroovySupporterServiceImpl implements GroovySupporterService {

    @Autowired
    MethodDOMapper methodDOMapper;

    @Override
    public List<MethodDO> listMethod(String key) {
        MethodDOExample.Criteria criteria = MethodDOExample
                .newAndCreateCriteria()
                .andLogicalDeleted(false);
        if (!StringUtils.isEmpty(key)) {
            criteria.andMethodShortNameLike("%" + key + "%");
        }
        List<MethodDO> methodDOList = methodDOMapper.selectByExample(criteria.example());
        return methodDOList;
    }
}
