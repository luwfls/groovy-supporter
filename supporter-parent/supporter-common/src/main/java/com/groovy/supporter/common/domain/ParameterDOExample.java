package com.groovy.supporter.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParameterDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public ParameterDOExample() {
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

    public ParameterDOExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public ParameterDOExample orderBy(String ... orderByClauses) {
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

    public ParameterDOExample limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    public ParameterDOExample limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    public ParameterDOExample page(Integer page, Integer pageSize) {
        this.offset = page * pageSize;
        this.rows = pageSize;
        return this;
    }

    public static Criteria newAndCreateCriteria() {
        ParameterDOExample example = new ParameterDOExample();
        return example.createCriteria();
    }

    public ParameterDOExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public ParameterDOExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
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

        public Criteria andIdEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualToColumn(ParameterDO.Column column) {
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

        public Criteria andMethodSignatureMd5EqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("method_signature_md5 = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5NotEqualTo(String value) {
            addCriterion("method_signature_md5 <>", value, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5NotEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("method_signature_md5 <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5GreaterThan(String value) {
            addCriterion("method_signature_md5 >", value, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5GreaterThanColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("method_signature_md5 > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5GreaterThanOrEqualTo(String value) {
            addCriterion("method_signature_md5 >=", value, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5GreaterThanOrEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("method_signature_md5 >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5LessThan(String value) {
            addCriterion("method_signature_md5 <", value, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5LessThanColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("method_signature_md5 < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5LessThanOrEqualTo(String value) {
            addCriterion("method_signature_md5 <=", value, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5LessThanOrEqualToColumn(ParameterDO.Column column) {
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

        public Criteria andParameterNameIsNull() {
            addCriterion("`parameter_name` is null");
            return (Criteria) this;
        }

        public Criteria andParameterNameIsNotNull() {
            addCriterion("`parameter_name` is not null");
            return (Criteria) this;
        }

        public Criteria andParameterNameEqualTo(String value) {
            addCriterion("`parameter_name` =", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("`parameter_name` = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andParameterNameNotEqualTo(String value) {
            addCriterion("`parameter_name` <>", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameNotEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("`parameter_name` <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andParameterNameGreaterThan(String value) {
            addCriterion("`parameter_name` >", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameGreaterThanColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("`parameter_name` > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andParameterNameGreaterThanOrEqualTo(String value) {
            addCriterion("`parameter_name` >=", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameGreaterThanOrEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("`parameter_name` >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andParameterNameLessThan(String value) {
            addCriterion("`parameter_name` <", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameLessThanColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("`parameter_name` < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andParameterNameLessThanOrEqualTo(String value) {
            addCriterion("`parameter_name` <=", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameLessThanOrEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("`parameter_name` <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andParameterNameLike(String value) {
            addCriterion("`parameter_name` like", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameNotLike(String value) {
            addCriterion("`parameter_name` not like", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameIn(List<String> values) {
            addCriterion("`parameter_name` in", values, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameNotIn(List<String> values) {
            addCriterion("`parameter_name` not in", values, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameBetween(String value1, String value2) {
            addCriterion("`parameter_name` between", value1, value2, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameNotBetween(String value1, String value2) {
            addCriterion("`parameter_name` not between", value1, value2, "parameterName");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameMd5IsNull() {
            addCriterion("belone_to_class_name_md5 is null");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameMd5IsNotNull() {
            addCriterion("belone_to_class_name_md5 is not null");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameMd5EqualTo(String value) {
            addCriterion("belone_to_class_name_md5 =", value, "beloneToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameMd5EqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_name_md5 = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameMd5NotEqualTo(String value) {
            addCriterion("belone_to_class_name_md5 <>", value, "beloneToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameMd5NotEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_name_md5 <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameMd5GreaterThan(String value) {
            addCriterion("belone_to_class_name_md5 >", value, "beloneToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameMd5GreaterThanColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_name_md5 > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameMd5GreaterThanOrEqualTo(String value) {
            addCriterion("belone_to_class_name_md5 >=", value, "beloneToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameMd5GreaterThanOrEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_name_md5 >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameMd5LessThan(String value) {
            addCriterion("belone_to_class_name_md5 <", value, "beloneToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameMd5LessThanColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_name_md5 < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameMd5LessThanOrEqualTo(String value) {
            addCriterion("belone_to_class_name_md5 <=", value, "beloneToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameMd5LessThanOrEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_name_md5 <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameMd5Like(String value) {
            addCriterion("belone_to_class_name_md5 like", value, "beloneToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameMd5NotLike(String value) {
            addCriterion("belone_to_class_name_md5 not like", value, "beloneToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameMd5In(List<String> values) {
            addCriterion("belone_to_class_name_md5 in", values, "beloneToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameMd5NotIn(List<String> values) {
            addCriterion("belone_to_class_name_md5 not in", values, "beloneToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameMd5Between(String value1, String value2) {
            addCriterion("belone_to_class_name_md5 between", value1, value2, "beloneToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameMd5NotBetween(String value1, String value2) {
            addCriterion("belone_to_class_name_md5 not between", value1, value2, "beloneToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureIsNull() {
            addCriterion("method_signature is null");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureIsNotNull() {
            addCriterion("method_signature is not null");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureEqualTo(String value) {
            addCriterion("method_signature =", value, "methodSignature");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("method_signature = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureNotEqualTo(String value) {
            addCriterion("method_signature <>", value, "methodSignature");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureNotEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("method_signature <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureGreaterThan(String value) {
            addCriterion("method_signature >", value, "methodSignature");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureGreaterThanColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("method_signature > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("method_signature >=", value, "methodSignature");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureGreaterThanOrEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("method_signature >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureLessThan(String value) {
            addCriterion("method_signature <", value, "methodSignature");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureLessThanColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("method_signature < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureLessThanOrEqualTo(String value) {
            addCriterion("method_signature <=", value, "methodSignature");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureLessThanOrEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("method_signature <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureLike(String value) {
            addCriterion("method_signature like", value, "methodSignature");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureNotLike(String value) {
            addCriterion("method_signature not like", value, "methodSignature");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureIn(List<String> values) {
            addCriterion("method_signature in", values, "methodSignature");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureNotIn(List<String> values) {
            addCriterion("method_signature not in", values, "methodSignature");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureBetween(String value1, String value2) {
            addCriterion("method_signature between", value1, value2, "methodSignature");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureNotBetween(String value1, String value2) {
            addCriterion("method_signature not between", value1, value2, "methodSignature");
            return (Criteria) this;
        }

        public Criteria andParameterClassNameIsNull() {
            addCriterion("parameter_class_name is null");
            return (Criteria) this;
        }

        public Criteria andParameterClassNameIsNotNull() {
            addCriterion("parameter_class_name is not null");
            return (Criteria) this;
        }

        public Criteria andParameterClassNameEqualTo(String value) {
            addCriterion("parameter_class_name =", value, "parameterClassName");
            return (Criteria) this;
        }

        public Criteria andParameterClassNameEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("parameter_class_name = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andParameterClassNameNotEqualTo(String value) {
            addCriterion("parameter_class_name <>", value, "parameterClassName");
            return (Criteria) this;
        }

        public Criteria andParameterClassNameNotEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("parameter_class_name <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andParameterClassNameGreaterThan(String value) {
            addCriterion("parameter_class_name >", value, "parameterClassName");
            return (Criteria) this;
        }

        public Criteria andParameterClassNameGreaterThanColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("parameter_class_name > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andParameterClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("parameter_class_name >=", value, "parameterClassName");
            return (Criteria) this;
        }

        public Criteria andParameterClassNameGreaterThanOrEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("parameter_class_name >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andParameterClassNameLessThan(String value) {
            addCriterion("parameter_class_name <", value, "parameterClassName");
            return (Criteria) this;
        }

        public Criteria andParameterClassNameLessThanColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("parameter_class_name < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andParameterClassNameLessThanOrEqualTo(String value) {
            addCriterion("parameter_class_name <=", value, "parameterClassName");
            return (Criteria) this;
        }

        public Criteria andParameterClassNameLessThanOrEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("parameter_class_name <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andParameterClassNameLike(String value) {
            addCriterion("parameter_class_name like", value, "parameterClassName");
            return (Criteria) this;
        }

        public Criteria andParameterClassNameNotLike(String value) {
            addCriterion("parameter_class_name not like", value, "parameterClassName");
            return (Criteria) this;
        }

        public Criteria andParameterClassNameIn(List<String> values) {
            addCriterion("parameter_class_name in", values, "parameterClassName");
            return (Criteria) this;
        }

        public Criteria andParameterClassNameNotIn(List<String> values) {
            addCriterion("parameter_class_name not in", values, "parameterClassName");
            return (Criteria) this;
        }

        public Criteria andParameterClassNameBetween(String value1, String value2) {
            addCriterion("parameter_class_name between", value1, value2, "parameterClassName");
            return (Criteria) this;
        }

        public Criteria andParameterClassNameNotBetween(String value1, String value2) {
            addCriterion("parameter_class_name not between", value1, value2, "parameterClassName");
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

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("`status` = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("`status` <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("`status` > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("`status` >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("`status` < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("`status` <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
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

        public Criteria andCreateTsEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("create_ts = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTsNotEqualTo(Date value) {
            addCriterion("create_ts <>", value, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsNotEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("create_ts <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTsGreaterThan(Date value) {
            addCriterion("create_ts >", value, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsGreaterThanColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("create_ts > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTsGreaterThanOrEqualTo(Date value) {
            addCriterion("create_ts >=", value, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsGreaterThanOrEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("create_ts >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTsLessThan(Date value) {
            addCriterion("create_ts <", value, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsLessThanColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("create_ts < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTsLessThanOrEqualTo(Date value) {
            addCriterion("create_ts <=", value, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsLessThanOrEqualToColumn(ParameterDO.Column column) {
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

        public Criteria andUpdateTsEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("update_ts = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTsNotEqualTo(Date value) {
            addCriterion("update_ts <>", value, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsNotEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("update_ts <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTsGreaterThan(Date value) {
            addCriterion("update_ts >", value, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsGreaterThanColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("update_ts > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTsGreaterThanOrEqualTo(Date value) {
            addCriterion("update_ts >=", value, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsGreaterThanOrEqualToColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("update_ts >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTsLessThan(Date value) {
            addCriterion("update_ts <", value, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsLessThanColumn(ParameterDO.Column column) {
            addCriterion(new StringBuilder("update_ts < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTsLessThanOrEqualTo(Date value) {
            addCriterion("update_ts <=", value, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsLessThanOrEqualToColumn(ParameterDO.Column column) {
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
        private ParameterDOExample example;

        protected Criteria(ParameterDOExample example) {
            super();
            this.example = example;
        }

        public Criteria andLogicalDeleted(boolean deleted) {
            return deleted ? andStatusEqualTo(ParameterDO.Status.IS_DELETED.value()) : andStatusNotEqualTo(ParameterDO.Status.IS_DELETED.value());
        }

        public ParameterDOExample example() {
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
        void example(com.groovy.supporter.common.domain.ParameterDOExample example);
    }
}