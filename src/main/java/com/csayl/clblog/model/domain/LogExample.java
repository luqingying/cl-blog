package com.csayl.clblog.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogExample() {
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

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
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

        public Criteria andLogIdIsNull() {
            addCriterion("log_id is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("log_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(Long value) {
            addCriterion("log_id =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(Long value) {
            addCriterion("log_id <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(Long value) {
            addCriterion("log_id >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("log_id >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(Long value) {
            addCriterion("log_id <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(Long value) {
            addCriterion("log_id <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<Long> values) {
            addCriterion("log_id in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<Long> values) {
            addCriterion("log_id not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(Long value1, Long value2) {
            addCriterion("log_id between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(Long value1, Long value2) {
            addCriterion("log_id not between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andVisitorIpIsNull() {
            addCriterion("visitor_ip is null");
            return (Criteria) this;
        }

        public Criteria andVisitorIpIsNotNull() {
            addCriterion("visitor_ip is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorIpEqualTo(String value) {
            addCriterion("visitor_ip =", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpNotEqualTo(String value) {
            addCriterion("visitor_ip <>", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpGreaterThan(String value) {
            addCriterion("visitor_ip >", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpGreaterThanOrEqualTo(String value) {
            addCriterion("visitor_ip >=", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpLessThan(String value) {
            addCriterion("visitor_ip <", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpLessThanOrEqualTo(String value) {
            addCriterion("visitor_ip <=", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpLike(String value) {
            addCriterion("visitor_ip like", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpNotLike(String value) {
            addCriterion("visitor_ip not like", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpIn(List<String> values) {
            addCriterion("visitor_ip in", values, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpNotIn(List<String> values) {
            addCriterion("visitor_ip not in", values, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpBetween(String value1, String value2) {
            addCriterion("visitor_ip between", value1, value2, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpNotBetween(String value1, String value2) {
            addCriterion("visitor_ip not between", value1, value2, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitUrlIsNull() {
            addCriterion("visit_url is null");
            return (Criteria) this;
        }

        public Criteria andVisitUrlIsNotNull() {
            addCriterion("visit_url is not null");
            return (Criteria) this;
        }

        public Criteria andVisitUrlEqualTo(String value) {
            addCriterion("visit_url =", value, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlNotEqualTo(String value) {
            addCriterion("visit_url <>", value, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlGreaterThan(String value) {
            addCriterion("visit_url >", value, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlGreaterThanOrEqualTo(String value) {
            addCriterion("visit_url >=", value, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlLessThan(String value) {
            addCriterion("visit_url <", value, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlLessThanOrEqualTo(String value) {
            addCriterion("visit_url <=", value, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlLike(String value) {
            addCriterion("visit_url like", value, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlNotLike(String value) {
            addCriterion("visit_url not like", value, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlIn(List<String> values) {
            addCriterion("visit_url in", values, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlNotIn(List<String> values) {
            addCriterion("visit_url not in", values, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlBetween(String value1, String value2) {
            addCriterion("visit_url between", value1, value2, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlNotBetween(String value1, String value2) {
            addCriterion("visit_url not between", value1, value2, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
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
}