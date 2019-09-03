package com.groovy.supporter.core;

import java.util.Map;

public interface GroovyScript {

    Object before(Map<String, Object> parameter);

    Object after(Map<String, Object> parameter);

}
