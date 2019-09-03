package com.groovy.supporter.manager.service;


import com.groovy.supporter.common.domain.MethodDO;

import java.util.List;

public interface GroovySupporterService {
    List<MethodDO> listMethod(String key);
}
