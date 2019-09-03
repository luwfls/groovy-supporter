package com.groovy.supporter.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScriptDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public ScriptDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public ScriptDOExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public ScriptDOExample orderBy(String ... orderByClauses) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < orderByClauses.length; i++) {
            sb.append(orderByClauses[i]);
            if (i < orderByClauses.length - 1) {
                sb.append(" , ");
            }
        }
        this.setOrderByClause(sb.toString());
        return this;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
        rows = null;
        offset = null;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getRows() {
        return this.rows;
    }

    public ScriptDOExample limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    public ScriptDOExample limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    public ScriptDOExample page(Integer page, Integer pageSize) {
        this.offset = page * pageSize;
        this.rows = pageSize;
        return this;
    }

    public static Criteria newAndCreateCriteria() {
        ScriptDOExample example = new ScriptDOExample();
        return example.createCriteria();
    }

    public ScriptDOExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public ScriptDOExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAppKeyIsNull() {
            addCriterion("app_key is null");
            return (Criteria) this;
        }

        public Criteria andAppKeyIsNotNull() {
            addCriterion("app_key is not null");
            return (Criteria) this;
        }

        public Criteria andAppKeyEqualTo(String value) {
            addCriterion("app_key =", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("app_key = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppKeyNotEqualTo(String value) {
            addCriterion("app_key <>", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("app_key <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppKeyGreaterThan(String value) {
            addCriterion("app_key >", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyGreaterThanColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("app_key > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppKeyGreaterThanOrEqualTo(String value) {
            addCriterion("app_key >=", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyGreaterThanOrEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("app_key >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppKeyLessThan(String value) {
            addCriterion("app_key <", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLessThanColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("app_key < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppKeyLessThanOrEqualTo(String value) {
            addCriterion("app_key <=", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLessThanOrEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("app_key <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppKeyLike(String value) {
            addCriterion("app_key like", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotLike(String value) {
            addCriterion("app_key not like", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyIn(List<String> values) {
            addCriterion("app_key in", values, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotIn(List<String> values) {
            addCriterion("app_key not in", values, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyBetween(String value1, String value2) {
            addCriterion("app_key between", value1, value2, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotBetween(String value1, String value2) {
            addCriterion("app_key not between", value1, value2, "appKey");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5IsNull() {
            addCriterion("belone_to_class_signature_md5 is null");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5IsNotNull() {
            addCriterion("belone_to_class_signature_md5 is not null");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5EqualTo(String value) {
            addCriterion("belone_to_class_signature_md5 =", value, "beloneToClassSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5EqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_signature_md5 = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5NotEqualTo(String value) {
            addCriterion("belone_to_class_signature_md5 <>", value, "beloneToClassSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5NotEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_signature_md5 <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5GreaterThan(String value) {
            addCriterion("belone_to_class_signature_md5 >", value, "beloneToClassSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5GreaterThanColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_signature_md5 > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5GreaterThanOrEqualTo(String value) {
            addCriterion("belone_to_class_signature_md5 >=", value, "beloneToClassSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5GreaterThanOrEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_signature_md5 >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5LessThan(String value) {
            addCriterion("belone_to_class_signature_md5 <", value, "beloneToClassSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5LessThanColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_signature_md5 < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5LessThanOrEqualTo(String value) {
            addCriterion("belone_to_class_signature_md5 <=", value, "beloneToClassSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5LessThanOrEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_signature_md5 <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5Like(String value) {
            addCriterion("belone_to_class_signature_md5 like", value, "beloneToClassSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5NotLike(String value) {
            addCriterion("belone_to_class_signature_md5 not like", value, "beloneToClassSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5In(List<String> values) {
            addCriterion("belone_to_class_signature_md5 in", values, "beloneToClassSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5NotIn(List<String> values) {
            addCriterion("belone_to_class_signature_md5 not in", values, "beloneToClassSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5Between(String value1, String value2) {
            addCriterion("belone_to_class_signature_md5 between", value1, value2, "beloneToClassSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5NotBetween(String value1, String value2) {
            addCriterion("belone_to_class_signature_md5 not between", value1, value2, "beloneToClassSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5IsNull() {
            addCriterion("method_signature_md5 is null");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5IsNotNull() {
            addCriterion("method_signature_md5 is not null");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5EqualTo(String value) {
            addCriterion("method_signature_md5 =", value, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5EqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("method_signature_md5 = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5NotEqualTo(String value) {
            addCriterion("method_signature_md5 <>", value, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5NotEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("method_signature_md5 <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5GreaterThan(String value) {
            addCriterion("method_signature_md5 >", value, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5GreaterThanColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("method_signature_md5 > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5GreaterThanOrEqualTo(String value) {
            addCriterion("method_signature_md5 >=", value, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5GreaterThanOrEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("method_signature_md5 >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5LessThan(String value) {
            addCriterion("method_signature_md5 <", value, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5LessThanColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("method_signature_md5 < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5LessThanOrEqualTo(String value) {
            addCriterion("method_signature_md5 <=", value, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5LessThanOrEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("method_signature_md5 <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5Like(String value) {
            addCriterion("method_signature_md5 like", value, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5NotLike(String value) {
            addCriterion("method_signature_md5 not like", value, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5In(List<String> values) {
            addCriterion("method_signature_md5 in", values, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5NotIn(List<String> values) {
            addCriterion("method_signature_md5 not in", values, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5Between(String value1, String value2) {
            addCriterion("method_signature_md5 between", value1, value2, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5NotBetween(String value1, String value2) {
            addCriterion("method_signature_md5 not between", value1, value2, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("`type` = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("`type` <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("`type` > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("`type` >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("`type` < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("`type` <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andExecuteTargetMethodIsNull() {
            addCriterion("execute_target_method is null");
            return (Criteria) this;
        }

        public Criteria andExecuteTargetMethodIsNotNull() {
            addCriterion("execute_target_method is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteTargetMethodEqualTo(Byte value) {
            addCriterion("execute_target_method =", value, "executeTargetMethod");
            return (Criteria) this;
        }

        public Criteria andExecuteTargetMethodEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("execute_target_method = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andExecuteTargetMethodNotEqualTo(Byte value) {
            addCriterion("execute_target_method <>", value, "executeTargetMethod");
            return (Criteria) this;
        }

        public Criteria andExecuteTargetMethodNotEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("execute_target_method <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andExecuteTargetMethodGreaterThan(Byte value) {
            addCriterion("execute_target_method >", value, "executeTargetMethod");
            return (Criteria) this;
        }

        public Criteria andExecuteTargetMethodGreaterThanColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("execute_target_method > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andExecuteTargetMethodGreaterThanOrEqualTo(Byte value) {
            addCriterion("execute_target_method >=", value, "executeTargetMethod");
            return (Criteria) this;
        }

        public Criteria andExecuteTargetMethodGreaterThanOrEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("execute_target_method >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andExecuteTargetMethodLessThan(Byte value) {
            addCriterion("execute_target_method <", value, "executeTargetMethod");
            return (Criteria) this;
        }

        public Criteria andExecuteTargetMethodLessThanColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("execute_target_method < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andExecuteTargetMethodLessThanOrEqualTo(Byte value) {
            addCriterion("execute_target_method <=", value, "executeTargetMethod");
            return (Criteria) this;
        }

        public Criteria andExecuteTargetMethodLessThanOrEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("execute_target_method <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andExecuteTargetMethodIn(List<Byte> values) {
            addCriterion("execute_target_method in", values, "executeTargetMethod");
            return (Criteria) this;
        }

        public Criteria andExecuteTargetMethodNotIn(List<Byte> values) {
            addCriterion("execute_target_method not in", values, "executeTargetMethod");
            return (Criteria) this;
        }

        public Criteria andExecuteTargetMethodBetween(Byte value1, Byte value2) {
            addCriterion("execute_target_method between", value1, value2, "executeTargetMethod");
            return (Criteria) this;
        }

        public Criteria andExecuteTargetMethodNotBetween(Byte value1, Byte value2) {
            addCriterion("execute_target_method not between", value1, value2, "executeTargetMethod");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("`status` = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("`status` <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("`status` > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("`status` >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("`status` < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("`status` <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("`status` like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("`status` not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTsIsNull() {
            addCriterion("create_ts is null");
            return (Criteria) this;
        }

        public Criteria andCreateTsIsNotNull() {
            addCriterion("create_ts is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTsEqualTo(Date value) {
            addCriterion("create_ts =", value, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("create_ts = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTsNotEqualTo(Date value) {
            addCriterion("create_ts <>", value, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsNotEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("create_ts <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTsGreaterThan(Date value) {
            addCriterion("create_ts >", value, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsGreaterThanColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("create_ts > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTsGreaterThanOrEqualTo(Date value) {
            addCriterion("create_ts >=", value, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsGreaterThanOrEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("create_ts >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTsLessThan(Date value) {
            addCriterion("create_ts <", value, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsLessThanColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("create_ts < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTsLessThanOrEqualTo(Date value) {
            addCriterion("create_ts <=", value, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsLessThanOrEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("create_ts <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTsIn(List<Date> values) {
            addCriterion("create_ts in", values, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsNotIn(List<Date> values) {
            addCriterion("create_ts not in", values, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsBetween(Date value1, Date value2) {
            addCriterion("create_ts between", value1, value2, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsNotBetween(Date value1, Date value2) {
            addCriterion("create_ts not between", value1, value2, "createTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsIsNull() {
            addCriterion("update_ts is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTsIsNotNull() {
            addCriterion("update_ts is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTsEqualTo(Date value) {
            addCriterion("update_ts =", value, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("update_ts = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTsNotEqualTo(Date value) {
            addCriterion("update_ts <>", value, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsNotEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("update_ts <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTsGreaterThan(Date value) {
            addCriterion("update_ts >", value, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsGreaterThanColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("update_ts > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTsGreaterThanOrEqualTo(Date value) {
            addCriterion("update_ts >=", value, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsGreaterThanOrEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("update_ts >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTsLessThan(Date value) {
            addCriterion("update_ts <", value, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsLessThanColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("update_ts < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTsLessThanOrEqualTo(Date value) {
            addCriterion("update_ts <=", value, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsLessThanOrEqualToColumn(ScriptDO.Column column) {
            addCriterion(new StringBuilder("update_ts <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTsIn(List<Date> values) {
            addCriterion("update_ts in", values, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsNotIn(List<Date> values) {
            addCriterion("update_ts not in", values, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsBetween(Date value1, Date value2) {
            addCriterion("update_ts between", value1, value2, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsNotBetween(Date value1, Date value2) {
            addCriterion("update_ts not between", value1, value2, "updateTs");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private ScriptDOExample example;

        protected Criteria(ScriptDOExample example) {
            super();
            this.example = example;
        }

        public Criteria andLogicalDeleted(boolean deleted) {
            return deleted ? andStatusEqualTo(ScriptDO.Status.IS_DELETED.value()) : andStatusNotEqualTo(ScriptDO.Status.IS_DELETED.value());
        }

        public ScriptDOExample example() {
            return this.example;
        }

        @Deprecated
        public Criteria andIf(boolean ifAdd, ICriteriaAdd add) {
            if (ifAdd) {
                add.add(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then) {
            if (condition) {
                then.criteria(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then, ICriteriaWhen otherwise) {
            if (condition) {
                then.criteria(this);
            } else {
                otherwise.criteria(this);
            }
            return this;
        }

        @Deprecated
        public interface ICriteriaAdd {
            Criteria add(Criteria add);
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }

    public interface ICriteriaWhen {
        void criteria(Criteria criteria);
    }

    public interface IExampleWhen {
        void example(com.groovy.supporter.common.domain.ScriptDOExample example);
    }
}