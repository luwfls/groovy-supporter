package com.groovy.supporter.common.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParameterDO {
    public static final Byte IS_DELETED = Status.IS_DELETED.value();

    public static final Byte NOT_DELETED = Status.NOT_DELETED.value();

    private Long id;

    private String methodSignatureMd5;

    private String parameterName;

    private String beloneToClassNameMd5;

    private String methodSignature;

    private String parameterClassName;

    private Byte status;

    private Date createTs;

    private Date updateTs;

    public void andLogicalDeleted(boolean deleted) {
        setStatus(deleted ? Status.IS_DELETED.value() : Status.NOT_DELETED.value());
    }

    public enum Status {
        NOT_DELETED(new Byte("1"), "未删除"),
        IS_DELETED(new Byte("0"), "已删除");

        private final Byte value;

        private final String name;

        Status(Byte value, String name) {
            this.value = value;
            this.name = name;
        }

        public Byte getValue() {
            return this.value;
        }

        public Byte value() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }
    }

    public enum Column {
        id("id", "id", "BIGINT", false),
        methodSignatureMd5("method_signature_md5", "methodSignatureMd5", "VARCHAR", false),
        parameterName("parameter_name", "parameterName", "VARCHAR", true),
        beloneToClassNameMd5("belone_to_class_name_md5", "beloneToClassNameMd5", "VARCHAR", false),
        methodSignature("method_signature", "methodSignature", "VARCHAR", false),
        parameterClassName("parameter_class_name", "parameterClassName", "VARCHAR", false),
        status("status", "status", "TINYINT", true),
        createTs("create_ts", "createTs", "TIMESTAMP", false),
        updateTs("update_ts", "updateTs", "TIMESTAMP", false);

        private static final String BEGINNING_DELIMITER = "`";

        private static final String ENDING_DELIMITER = "`";

        private final String column;

        private final boolean isColumnNameDelimited;

        private final String javaProperty;

        private final String jdbcType;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        public String getJavaProperty() {
            return this.javaProperty;
        }

        public String getJdbcType() {
            return this.jdbcType;
        }

        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}