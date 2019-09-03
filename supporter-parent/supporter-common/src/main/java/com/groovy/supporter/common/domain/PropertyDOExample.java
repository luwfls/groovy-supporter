package com.groovy.supporter.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PropertyDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public PropertyDOExample() {
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

    public PropertyDOExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public PropertyDOExample orderBy(String ... orderByClauses) {
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

    public PropertyDOExample limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    public PropertyDOExample limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    public PropertyDOExample page(Integer page, Integer pageSize) {
        this.offset = page * pageSize;
        this.rows = pageSize;
        return this;
    }

    public static Criteria newAndCreateCriteria() {
        PropertyDOExample example = new PropertyDOExample();
        return example.createCriteria();
    }

    public PropertyDOExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public PropertyDOExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
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

        public Criteria andIdEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualToColumn(PropertyDO.Column column) {
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

        public Criteria andBeloneToClassSignatureMd5EqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_signature_md5 = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5NotEqualTo(String value) {
            addCriterion("belone_to_class_signature_md5 <>", value, "beloneToClassSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5NotEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_signature_md5 <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5GreaterThan(String value) {
            addCriterion("belone_to_class_signature_md5 >", value, "beloneToClassSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5GreaterThanColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_signature_md5 > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5GreaterThanOrEqualTo(String value) {
            addCriterion("belone_to_class_signature_md5 >=", value, "beloneToClassSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5GreaterThanOrEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_signature_md5 >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5LessThan(String value) {
            addCriterion("belone_to_class_signature_md5 <", value, "beloneToClassSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5LessThanColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_signature_md5 < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5LessThanOrEqualTo(String value) {
            addCriterion("belone_to_class_signature_md5 <=", value, "beloneToClassSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassSignatureMd5LessThanOrEqualToColumn(PropertyDO.Column column) {
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

        public Criteria andBeloneToClassNameIsNull() {
            addCriterion("belone_to_class_name is null");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameIsNotNull() {
            addCriterion("belone_to_class_name is not null");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameEqualTo(String value) {
            addCriterion("belone_to_class_name =", value, "beloneToClassName");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_name = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameNotEqualTo(String value) {
            addCriterion("belone_to_class_name <>", value, "beloneToClassName");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameNotEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_name <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameGreaterThan(String value) {
            addCriterion("belone_to_class_name >", value, "beloneToClassName");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameGreaterThanColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_name > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("belone_to_class_name >=", value, "beloneToClassName");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameGreaterThanOrEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_name >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameLessThan(String value) {
            addCriterion("belone_to_class_name <", value, "beloneToClassName");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameLessThanColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_name < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameLessThanOrEqualTo(String value) {
            addCriterion("belone_to_class_name <=", value, "beloneToClassName");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameLessThanOrEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("belone_to_class_name <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameLike(String value) {
            addCriterion("belone_to_class_name like", value, "beloneToClassName");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameNotLike(String value) {
            addCriterion("belone_to_class_name not like", value, "beloneToClassName");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameIn(List<String> values) {
            addCriterion("belone_to_class_name in", values, "beloneToClassName");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameNotIn(List<String> values) {
            addCriterion("belone_to_class_name not in", values, "beloneToClassName");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameBetween(String value1, String value2) {
            addCriterion("belone_to_class_name between", value1, value2, "beloneToClassName");
            return (Criteria) this;
        }

        public Criteria andBeloneToClassNameNotBetween(String value1, String value2) {
            addCriterion("belone_to_class_name not between", value1, value2, "beloneToClassName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassNameIsNull() {
            addCriterion("property_class_name is null");
            return (Criteria) this;
        }

        public Criteria andPropertyClassNameIsNotNull() {
            addCriterion("property_class_name is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyClassNameEqualTo(String value) {
            addCriterion("property_class_name =", value, "propertyClassName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassNameEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("property_class_name = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPropertyClassNameNotEqualTo(String value) {
            addCriterion("property_class_name <>", value, "propertyClassName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassNameNotEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("property_class_name <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPropertyClassNameGreaterThan(String value) {
            addCriterion("property_class_name >", value, "propertyClassName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassNameGreaterThanColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("property_class_name > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPropertyClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("property_class_name >=", value, "propertyClassName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassNameGreaterThanOrEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("property_class_name >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPropertyClassNameLessThan(String value) {
            addCriterion("property_class_name <", value, "propertyClassName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassNameLessThanColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("property_class_name < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPropertyClassNameLessThanOrEqualTo(String value) {
            addCriterion("property_class_name <=", value, "propertyClassName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassNameLessThanOrEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("property_class_name <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPropertyClassNameLike(String value) {
            addCriterion("property_class_name like", value, "propertyClassName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassNameNotLike(String value) {
            addCriterion("property_class_name not like", value, "propertyClassName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassNameIn(List<String> values) {
            addCriterion("property_class_name in", values, "propertyClassName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassNameNotIn(List<String> values) {
            addCriterion("property_class_name not in", values, "propertyClassName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassNameBetween(String value1, String value2) {
            addCriterion("property_class_name between", value1, value2, "propertyClassName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassNameNotBetween(String value1, String value2) {
            addCriterion("property_class_name not between", value1, value2, "propertyClassName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameIsNull() {
            addCriterion("property_name is null");
            return (Criteria) this;
        }

        public Criteria andPropertyNameIsNotNull() {
            addCriterion("property_name is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyNameEqualTo(String value) {
            addCriterion("property_name =", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("property_name = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotEqualTo(String value) {
            addCriterion("property_name <>", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("property_name <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPropertyNameGreaterThan(String value) {
            addCriterion("property_name >", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameGreaterThanColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("property_name > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPropertyNameGreaterThanOrEqualTo(String value) {
            addCriterion("property_name >=", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameGreaterThanOrEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("property_name >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPropertyNameLessThan(String value) {
            addCriterion("property_name <", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameLessThanColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("property_name < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPropertyNameLessThanOrEqualTo(String value) {
            addCriterion("property_name <=", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameLessThanOrEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("property_name <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPropertyNameLike(String value) {
            addCriterion("property_name like", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotLike(String value) {
            addCriterion("property_name not like", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameIn(List<String> values) {
            addCriterion("property_name in", values, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotIn(List<String> values) {
            addCriterion("property_name not in", values, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameBetween(String value1, String value2) {
            addCriterion("property_name between", value1, value2, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotBetween(String value1, String value2) {
            addCriterion("property_name not between", value1, value2, "propertyName");
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

        public Criteria andStatusEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("`status` = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("`status` <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("`status` > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("`status` >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("`status` < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualToColumn(PropertyDO.Column column) {
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

        public Criteria andCreateTsEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("create_ts = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTsNotEqualTo(Date value) {
            addCriterion("create_ts <>", value, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsNotEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("create_ts <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTsGreaterThan(Date value) {
            addCriterion("create_ts >", value, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsGreaterThanColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("create_ts > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTsGreaterThanOrEqualTo(Date value) {
            addCriterion("create_ts >=", value, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsGreaterThanOrEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("create_ts >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTsLessThan(Date value) {
            addCriterion("create_ts <", value, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsLessThanColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("create_ts < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTsLessThanOrEqualTo(Date value) {
            addCriterion("create_ts <=", value, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsLessThanOrEqualToColumn(PropertyDO.Column column) {
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

        public Criteria andUpdateTsEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("update_ts = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTsNotEqualTo(Date value) {
            addCriterion("update_ts <>", value, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsNotEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("update_ts <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTsGreaterThan(Date value) {
            addCriterion("update_ts >", value, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsGreaterThanColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("update_ts > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTsGreaterThanOrEqualTo(Date value) {
            addCriterion("update_ts >=", value, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsGreaterThanOrEqualToColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("update_ts >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTsLessThan(Date value) {
            addCriterion("update_ts <", value, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsLessThanColumn(PropertyDO.Column column) {
            addCriterion(new StringBuilder("update_ts < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTsLessThanOrEqualTo(Date value) {
            addCriterion("update_ts <=", value, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsLessThanOrEqualToColumn(PropertyDO.Column column) {
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
        private PropertyDOExample example;

        protected Criteria(PropertyDOExample example) {
            super();
            this.example = example;
        }

        public Criteria andLogicalDeleted(boolean deleted) {
            return deleted ? andStatusEqualTo(PropertyDO.Status.IS_DELETED.value()) : andStatusNotEqualTo(PropertyDO.Status.IS_DELETED.value());
        }

        public PropertyDOExample example() {
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
        void example(com.groovy.supporter.common.domain.PropertyDOExample example);
    }
}