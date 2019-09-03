package com.groovy.supporter.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MethodDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public MethodDOExample() {
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

    public MethodDOExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public MethodDOExample orderBy(String ... orderByClauses) {
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

    public MethodDOExample limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    public MethodDOExample limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    public MethodDOExample page(Integer page, Integer pageSize) {
        this.offset = page * pageSize;
        this.rows = pageSize;
        return this;
    }

    public static Criteria newAndCreateCriteria() {
        MethodDOExample example = new MethodDOExample();
        return example.createCriteria();
    }

    public MethodDOExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public MethodDOExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
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

        public Criteria andIdEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualToColumn(MethodDO.Column column) {
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

        public Criteria andAppKeyEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("app_key = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppKeyNotEqualTo(String value) {
            addCriterion("app_key <>", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("app_key <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppKeyGreaterThan(String value) {
            addCriterion("app_key >", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyGreaterThanColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("app_key > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppKeyGreaterThanOrEqualTo(String value) {
            addCriterion("app_key >=", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyGreaterThanOrEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("app_key >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppKeyLessThan(String value) {
            addCriterion("app_key <", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLessThanColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("app_key < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppKeyLessThanOrEqualTo(String value) {
            addCriterion("app_key <=", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLessThanOrEqualToColumn(MethodDO.Column column) {
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

        public Criteria andMethodSignatureMd5EqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("method_signature_md5 = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5NotEqualTo(String value) {
            addCriterion("method_signature_md5 <>", value, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5NotEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("method_signature_md5 <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5GreaterThan(String value) {
            addCriterion("method_signature_md5 >", value, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5GreaterThanColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("method_signature_md5 > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5GreaterThanOrEqualTo(String value) {
            addCriterion("method_signature_md5 >=", value, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5GreaterThanOrEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("method_signature_md5 >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5LessThan(String value) {
            addCriterion("method_signature_md5 <", value, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5LessThanColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("method_signature_md5 < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5LessThanOrEqualTo(String value) {
            addCriterion("method_signature_md5 <=", value, "methodSignatureMd5");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureMd5LessThanOrEqualToColumn(MethodDO.Column column) {
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

        public Criteria andBelongToClassNameMd5IsNull() {
            addCriterion("belong_to_class_name_md5 is null");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameMd5IsNotNull() {
            addCriterion("belong_to_class_name_md5 is not null");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameMd5EqualTo(String value) {
            addCriterion("belong_to_class_name_md5 =", value, "belongToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameMd5EqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("belong_to_class_name_md5 = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameMd5NotEqualTo(String value) {
            addCriterion("belong_to_class_name_md5 <>", value, "belongToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameMd5NotEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("belong_to_class_name_md5 <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameMd5GreaterThan(String value) {
            addCriterion("belong_to_class_name_md5 >", value, "belongToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameMd5GreaterThanColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("belong_to_class_name_md5 > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameMd5GreaterThanOrEqualTo(String value) {
            addCriterion("belong_to_class_name_md5 >=", value, "belongToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameMd5GreaterThanOrEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("belong_to_class_name_md5 >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameMd5LessThan(String value) {
            addCriterion("belong_to_class_name_md5 <", value, "belongToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameMd5LessThanColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("belong_to_class_name_md5 < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameMd5LessThanOrEqualTo(String value) {
            addCriterion("belong_to_class_name_md5 <=", value, "belongToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameMd5LessThanOrEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("belong_to_class_name_md5 <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameMd5Like(String value) {
            addCriterion("belong_to_class_name_md5 like", value, "belongToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameMd5NotLike(String value) {
            addCriterion("belong_to_class_name_md5 not like", value, "belongToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameMd5In(List<String> values) {
            addCriterion("belong_to_class_name_md5 in", values, "belongToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameMd5NotIn(List<String> values) {
            addCriterion("belong_to_class_name_md5 not in", values, "belongToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameMd5Between(String value1, String value2) {
            addCriterion("belong_to_class_name_md5 between", value1, value2, "belongToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameMd5NotBetween(String value1, String value2) {
            addCriterion("belong_to_class_name_md5 not between", value1, value2, "belongToClassNameMd5");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameIsNull() {
            addCriterion("belong_to_class_name is null");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameIsNotNull() {
            addCriterion("belong_to_class_name is not null");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameEqualTo(String value) {
            addCriterion("belong_to_class_name =", value, "belongToClassName");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("belong_to_class_name = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameNotEqualTo(String value) {
            addCriterion("belong_to_class_name <>", value, "belongToClassName");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameNotEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("belong_to_class_name <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameGreaterThan(String value) {
            addCriterion("belong_to_class_name >", value, "belongToClassName");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameGreaterThanColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("belong_to_class_name > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("belong_to_class_name >=", value, "belongToClassName");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameGreaterThanOrEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("belong_to_class_name >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameLessThan(String value) {
            addCriterion("belong_to_class_name <", value, "belongToClassName");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameLessThanColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("belong_to_class_name < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameLessThanOrEqualTo(String value) {
            addCriterion("belong_to_class_name <=", value, "belongToClassName");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameLessThanOrEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("belong_to_class_name <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameLike(String value) {
            addCriterion("belong_to_class_name like", value, "belongToClassName");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameNotLike(String value) {
            addCriterion("belong_to_class_name not like", value, "belongToClassName");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameIn(List<String> values) {
            addCriterion("belong_to_class_name in", values, "belongToClassName");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameNotIn(List<String> values) {
            addCriterion("belong_to_class_name not in", values, "belongToClassName");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameBetween(String value1, String value2) {
            addCriterion("belong_to_class_name between", value1, value2, "belongToClassName");
            return (Criteria) this;
        }

        public Criteria andBelongToClassNameNotBetween(String value1, String value2) {
            addCriterion("belong_to_class_name not between", value1, value2, "belongToClassName");
            return (Criteria) this;
        }

        public Criteria andMethodShortNameIsNull() {
            addCriterion("method_short_name is null");
            return (Criteria) this;
        }

        public Criteria andMethodShortNameIsNotNull() {
            addCriterion("method_short_name is not null");
            return (Criteria) this;
        }

        public Criteria andMethodShortNameEqualTo(String value) {
            addCriterion("method_short_name =", value, "methodShortName");
            return (Criteria) this;
        }

        public Criteria andMethodShortNameEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("method_short_name = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodShortNameNotEqualTo(String value) {
            addCriterion("method_short_name <>", value, "methodShortName");
            return (Criteria) this;
        }

        public Criteria andMethodShortNameNotEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("method_short_name <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodShortNameGreaterThan(String value) {
            addCriterion("method_short_name >", value, "methodShortName");
            return (Criteria) this;
        }

        public Criteria andMethodShortNameGreaterThanColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("method_short_name > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("method_short_name >=", value, "methodShortName");
            return (Criteria) this;
        }

        public Criteria andMethodShortNameGreaterThanOrEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("method_short_name >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodShortNameLessThan(String value) {
            addCriterion("method_short_name <", value, "methodShortName");
            return (Criteria) this;
        }

        public Criteria andMethodShortNameLessThanColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("method_short_name < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodShortNameLessThanOrEqualTo(String value) {
            addCriterion("method_short_name <=", value, "methodShortName");
            return (Criteria) this;
        }

        public Criteria andMethodShortNameLessThanOrEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("method_short_name <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodShortNameLike(String value) {
            addCriterion("method_short_name like", value, "methodShortName");
            return (Criteria) this;
        }

        public Criteria andMethodShortNameNotLike(String value) {
            addCriterion("method_short_name not like", value, "methodShortName");
            return (Criteria) this;
        }

        public Criteria andMethodShortNameIn(List<String> values) {
            addCriterion("method_short_name in", values, "methodShortName");
            return (Criteria) this;
        }

        public Criteria andMethodShortNameNotIn(List<String> values) {
            addCriterion("method_short_name not in", values, "methodShortName");
            return (Criteria) this;
        }

        public Criteria andMethodShortNameBetween(String value1, String value2) {
            addCriterion("method_short_name between", value1, value2, "methodShortName");
            return (Criteria) this;
        }

        public Criteria andMethodShortNameNotBetween(String value1, String value2) {
            addCriterion("method_short_name not between", value1, value2, "methodShortName");
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

        public Criteria andMethodSignatureEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("method_signature = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureNotEqualTo(String value) {
            addCriterion("method_signature <>", value, "methodSignature");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureNotEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("method_signature <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureGreaterThan(String value) {
            addCriterion("method_signature >", value, "methodSignature");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureGreaterThanColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("method_signature > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("method_signature >=", value, "methodSignature");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureGreaterThanOrEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("method_signature >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureLessThan(String value) {
            addCriterion("method_signature <", value, "methodSignature");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureLessThanColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("method_signature < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMethodSignatureLessThanOrEqualTo(String value) {
            addCriterion("method_signature <=", value, "methodSignature");
            return (Criteria) this;
        }

        public Criteria andMethodSignatureLessThanOrEqualToColumn(MethodDO.Column column) {
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

        public Criteria andStatusEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("`status` = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("`status` <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("`status` > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("`status` >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("`status` < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualToColumn(MethodDO.Column column) {
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

        public Criteria andCreateTsEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("create_ts = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTsNotEqualTo(Date value) {
            addCriterion("create_ts <>", value, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsNotEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("create_ts <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTsGreaterThan(Date value) {
            addCriterion("create_ts >", value, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsGreaterThanColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("create_ts > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTsGreaterThanOrEqualTo(Date value) {
            addCriterion("create_ts >=", value, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsGreaterThanOrEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("create_ts >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTsLessThan(Date value) {
            addCriterion("create_ts <", value, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsLessThanColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("create_ts < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTsLessThanOrEqualTo(Date value) {
            addCriterion("create_ts <=", value, "createTs");
            return (Criteria) this;
        }

        public Criteria andCreateTsLessThanOrEqualToColumn(MethodDO.Column column) {
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

        public Criteria andUpdateTsEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("update_ts = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTsNotEqualTo(Date value) {
            addCriterion("update_ts <>", value, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsNotEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("update_ts <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTsGreaterThan(Date value) {
            addCriterion("update_ts >", value, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsGreaterThanColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("update_ts > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTsGreaterThanOrEqualTo(Date value) {
            addCriterion("update_ts >=", value, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsGreaterThanOrEqualToColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("update_ts >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTsLessThan(Date value) {
            addCriterion("update_ts <", value, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsLessThanColumn(MethodDO.Column column) {
            addCriterion(new StringBuilder("update_ts < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTsLessThanOrEqualTo(Date value) {
            addCriterion("update_ts <=", value, "updateTs");
            return (Criteria) this;
        }

        public Criteria andUpdateTsLessThanOrEqualToColumn(MethodDO.Column column) {
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
        private MethodDOExample example;

        protected Criteria(MethodDOExample example) {
            super();
            this.example = example;
        }

        public Criteria andLogicalDeleted(boolean deleted) {
            return deleted ? andStatusEqualTo(MethodDO.Status.IS_DELETED.value()) : andStatusNotEqualTo(MethodDO.Status.IS_DELETED.value());
        }

        public MethodDOExample example() {
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
        void example(com.groovy.supporter.common.domain.MethodDOExample example);
    }
}