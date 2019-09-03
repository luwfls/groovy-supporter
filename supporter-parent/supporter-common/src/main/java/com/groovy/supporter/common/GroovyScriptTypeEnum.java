package com.groovy.supporter.common;

public enum GroovyScriptTypeEnum {
    TEMPLATE((byte) 0),
    BEFORE((byte) 1),
    AFTER((byte) 2),
    AROUND((byte) 3);

    public final Byte type;

    GroovyScriptTypeEnum(Byte type) {
        this.type = type;
    }


    public static GroovyScriptTypeEnum of(Byte type) {
        switch (type) {
            case 0:
                return TEMPLATE;
            case 1:
                return BEFORE;
            case 2:
                return AFTER;
            case 3:
                return AROUND;
            default:
                return null;
        }
    }
}
