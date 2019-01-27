package com.csayl.clblog.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Long value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Long value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Long value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Long value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Long value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Long> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Long> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Long value1, Long value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Long value1, Long value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNull() {
            addCriterion("comment_content is null");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNotNull() {
            addCriterion("comment_content is not null");
            return (Criteria) this;
        }

        public Criteria andCommentContentEqualTo(String value) {
            addCriterion("comment_content =", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotEqualTo(String value) {
            addCriterion("comment_content <>", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThan(String value) {
            addCriterion("comment_content >", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThanOrEqualTo(String value) {
            addCriterion("comment_content >=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThan(String value) {
            addCriterion("comment_content <", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThanOrEqualTo(String value) {
            addCriterion("comment_content <=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLike(String value) {
            addCriterion("comment_content like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotLike(String value) {
            addCriterion("comment_content not like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentIn(List<String> values) {
            addCriterion("comment_content in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotIn(List<String> values) {
            addCriterion("comment_content not in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentBetween(String value1, String value2) {
            addCriterion("comment_content between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotBetween(String value1, String value2) {
            addCriterion("comment_content not between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andPCommentIdIsNull() {
            addCriterion("p_comment_id is null");
            return (Criteria) this;
        }

        public Criteria andPCommentIdIsNotNull() {
            addCriterion("p_comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andPCommentIdEqualTo(Long value) {
            addCriterion("p_comment_id =", value, "pCommentId");
            return (Criteria) this;
        }

        public Criteria andPCommentIdNotEqualTo(Long value) {
            addCriterion("p_comment_id <>", value, "pCommentId");
            return (Criteria) this;
        }

        public Criteria andPCommentIdGreaterThan(Long value) {
            addCriterion("p_comment_id >", value, "pCommentId");
            return (Criteria) this;
        }

        public Criteria andPCommentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("p_comment_id >=", value, "pCommentId");
            return (Criteria) this;
        }

        public Criteria andPCommentIdLessThan(Long value) {
            addCriterion("p_comment_id <", value, "pCommentId");
            return (Criteria) this;
        }

        public Criteria andPCommentIdLessThanOrEqualTo(Long value) {
            addCriterion("p_comment_id <=", value, "pCommentId");
            return (Criteria) this;
        }

        public Criteria andPCommentIdIn(List<Long> values) {
            addCriterion("p_comment_id in", values, "pCommentId");
            return (Criteria) this;
        }

        public Criteria andPCommentIdNotIn(List<Long> values) {
            addCriterion("p_comment_id not in", values, "pCommentId");
            return (Criteria) this;
        }

        public Criteria andPCommentIdBetween(Long value1, Long value2) {
            addCriterion("p_comment_id between", value1, value2, "pCommentId");
            return (Criteria) this;
        }

        public Criteria andPCommentIdNotBetween(Long value1, Long value2) {
            addCriterion("p_comment_id not between", value1, value2, "pCommentId");
            return (Criteria) this;
        }

        public Criteria andRootCommentIdIsNull() {
            addCriterion("root_comment_id is null");
            return (Criteria) this;
        }

        public Criteria andRootCommentIdIsNotNull() {
            addCriterion("root_comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andRootCommentIdEqualTo(Long value) {
            addCriterion("root_comment_id =", value, "rootCommentId");
            return (Criteria) this;
        }

        public Criteria andRootCommentIdNotEqualTo(Long value) {
            addCriterion("root_comment_id <>", value, "rootCommentId");
            return (Criteria) this;
        }

        public Criteria andRootCommentIdGreaterThan(Long value) {
            addCriterion("root_comment_id >", value, "rootCommentId");
            return (Criteria) this;
        }

        public Criteria andRootCommentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("root_comment_id >=", value, "rootCommentId");
            return (Criteria) this;
        }

        public Criteria andRootCommentIdLessThan(Long value) {
            addCriterion("root_comment_id <", value, "rootCommentId");
            return (Criteria) this;
        }

        public Criteria andRootCommentIdLessThanOrEqualTo(Long value) {
            addCriterion("root_comment_id <=", value, "rootCommentId");
            return (Criteria) this;
        }

        public Criteria andRootCommentIdIn(List<Long> values) {
            addCriterion("root_comment_id in", values, "rootCommentId");
            return (Criteria) this;
        }

        public Criteria andRootCommentIdNotIn(List<Long> values) {
            addCriterion("root_comment_id not in", values, "rootCommentId");
            return (Criteria) this;
        }

        public Criteria andRootCommentIdBetween(Long value1, Long value2) {
            addCriterion("root_comment_id between", value1, value2, "rootCommentId");
            return (Criteria) this;
        }

        public Criteria andRootCommentIdNotBetween(Long value1, Long value2) {
            addCriterion("root_comment_id not between", value1, value2, "rootCommentId");
            return (Criteria) this;
        }

        public Criteria andPUserIdIsNull() {
            addCriterion("p_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPUserIdIsNotNull() {
            addCriterion("p_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPUserIdEqualTo(Long value) {
            addCriterion("p_user_id =", value, "pUserId");
            return (Criteria) this;
        }

        public Criteria andPUserIdNotEqualTo(Long value) {
            addCriterion("p_user_id <>", value, "pUserId");
            return (Criteria) this;
        }

        public Criteria andPUserIdGreaterThan(Long value) {
            addCriterion("p_user_id >", value, "pUserId");
            return (Criteria) this;
        }

        public Criteria andPUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("p_user_id >=", value, "pUserId");
            return (Criteria) this;
        }

        public Criteria andPUserIdLessThan(Long value) {
            addCriterion("p_user_id <", value, "pUserId");
            return (Criteria) this;
        }

        public Criteria andPUserIdLessThanOrEqualTo(Long value) {
            addCriterion("p_user_id <=", value, "pUserId");
            return (Criteria) this;
        }

        public Criteria andPUserIdIn(List<Long> values) {
            addCriterion("p_user_id in", values, "pUserId");
            return (Criteria) this;
        }

        public Criteria andPUserIdNotIn(List<Long> values) {
            addCriterion("p_user_id not in", values, "pUserId");
            return (Criteria) this;
        }

        public Criteria andPUserIdBetween(Long value1, Long value2) {
            addCriterion("p_user_id between", value1, value2, "pUserId");
            return (Criteria) this;
        }

        public Criteria andPUserIdNotBetween(Long value1, Long value2) {
            addCriterion("p_user_id not between", value1, value2, "pUserId");
            return (Criteria) this;
        }

        public Criteria andPArticleIdIsNull() {
            addCriterion("p_article_id is null");
            return (Criteria) this;
        }

        public Criteria andPArticleIdIsNotNull() {
            addCriterion("p_article_id is not null");
            return (Criteria) this;
        }

        public Criteria andPArticleIdEqualTo(Long value) {
            addCriterion("p_article_id =", value, "pArticleId");
            return (Criteria) this;
        }

        public Criteria andPArticleIdNotEqualTo(Long value) {
            addCriterion("p_article_id <>", value, "pArticleId");
            return (Criteria) this;
        }

        public Criteria andPArticleIdGreaterThan(Long value) {
            addCriterion("p_article_id >", value, "pArticleId");
            return (Criteria) this;
        }

        public Criteria andPArticleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("p_article_id >=", value, "pArticleId");
            return (Criteria) this;
        }

        public Criteria andPArticleIdLessThan(Long value) {
            addCriterion("p_article_id <", value, "pArticleId");
            return (Criteria) this;
        }

        public Criteria andPArticleIdLessThanOrEqualTo(Long value) {
            addCriterion("p_article_id <=", value, "pArticleId");
            return (Criteria) this;
        }

        public Criteria andPArticleIdIn(List<Long> values) {
            addCriterion("p_article_id in", values, "pArticleId");
            return (Criteria) this;
        }

        public Criteria andPArticleIdNotIn(List<Long> values) {
            addCriterion("p_article_id not in", values, "pArticleId");
            return (Criteria) this;
        }

        public Criteria andPArticleIdBetween(Long value1, Long value2) {
            addCriterion("p_article_id between", value1, value2, "pArticleId");
            return (Criteria) this;
        }

        public Criteria andPArticleIdNotBetween(Long value1, Long value2) {
            addCriterion("p_article_id not between", value1, value2, "pArticleId");
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

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
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