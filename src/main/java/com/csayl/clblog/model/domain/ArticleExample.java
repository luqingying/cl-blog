package com.csayl.clblog.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(Long value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(Long value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(Long value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(Long value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(Long value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<Long> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<Long> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(Long value1, Long value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(Long value1, Long value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdIsNull() {
            addCriterion("article_user_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdIsNotNull() {
            addCriterion("article_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdEqualTo(Long value) {
            addCriterion("article_user_id =", value, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdNotEqualTo(Long value) {
            addCriterion("article_user_id <>", value, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdGreaterThan(Long value) {
            addCriterion("article_user_id >", value, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("article_user_id >=", value, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdLessThan(Long value) {
            addCriterion("article_user_id <", value, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdLessThanOrEqualTo(Long value) {
            addCriterion("article_user_id <=", value, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdIn(List<Long> values) {
            addCriterion("article_user_id in", values, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdNotIn(List<Long> values) {
            addCriterion("article_user_id not in", values, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdBetween(Long value1, Long value2) {
            addCriterion("article_user_id between", value1, value2, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdNotBetween(Long value1, Long value2) {
            addCriterion("article_user_id not between", value1, value2, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleNameIsNull() {
            addCriterion("article_name is null");
            return (Criteria) this;
        }

        public Criteria andArticleNameIsNotNull() {
            addCriterion("article_name is not null");
            return (Criteria) this;
        }

        public Criteria andArticleNameEqualTo(String value) {
            addCriterion("article_name =", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameNotEqualTo(String value) {
            addCriterion("article_name <>", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameGreaterThan(String value) {
            addCriterion("article_name >", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameGreaterThanOrEqualTo(String value) {
            addCriterion("article_name >=", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameLessThan(String value) {
            addCriterion("article_name <", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameLessThanOrEqualTo(String value) {
            addCriterion("article_name <=", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameLike(String value) {
            addCriterion("article_name like", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameNotLike(String value) {
            addCriterion("article_name not like", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameIn(List<String> values) {
            addCriterion("article_name in", values, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameNotIn(List<String> values) {
            addCriterion("article_name not in", values, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameBetween(String value1, String value2) {
            addCriterion("article_name between", value1, value2, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameNotBetween(String value1, String value2) {
            addCriterion("article_name not between", value1, value2, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleCoverUrlIsNull() {
            addCriterion("article_cover_url is null");
            return (Criteria) this;
        }

        public Criteria andArticleCoverUrlIsNotNull() {
            addCriterion("article_cover_url is not null");
            return (Criteria) this;
        }

        public Criteria andArticleCoverUrlEqualTo(String value) {
            addCriterion("article_cover_url =", value, "articleCoverUrl");
            return (Criteria) this;
        }

        public Criteria andArticleCoverUrlNotEqualTo(String value) {
            addCriterion("article_cover_url <>", value, "articleCoverUrl");
            return (Criteria) this;
        }

        public Criteria andArticleCoverUrlGreaterThan(String value) {
            addCriterion("article_cover_url >", value, "articleCoverUrl");
            return (Criteria) this;
        }

        public Criteria andArticleCoverUrlGreaterThanOrEqualTo(String value) {
            addCriterion("article_cover_url >=", value, "articleCoverUrl");
            return (Criteria) this;
        }

        public Criteria andArticleCoverUrlLessThan(String value) {
            addCriterion("article_cover_url <", value, "articleCoverUrl");
            return (Criteria) this;
        }

        public Criteria andArticleCoverUrlLessThanOrEqualTo(String value) {
            addCriterion("article_cover_url <=", value, "articleCoverUrl");
            return (Criteria) this;
        }

        public Criteria andArticleCoverUrlLike(String value) {
            addCriterion("article_cover_url like", value, "articleCoverUrl");
            return (Criteria) this;
        }

        public Criteria andArticleCoverUrlNotLike(String value) {
            addCriterion("article_cover_url not like", value, "articleCoverUrl");
            return (Criteria) this;
        }

        public Criteria andArticleCoverUrlIn(List<String> values) {
            addCriterion("article_cover_url in", values, "articleCoverUrl");
            return (Criteria) this;
        }

        public Criteria andArticleCoverUrlNotIn(List<String> values) {
            addCriterion("article_cover_url not in", values, "articleCoverUrl");
            return (Criteria) this;
        }

        public Criteria andArticleCoverUrlBetween(String value1, String value2) {
            addCriterion("article_cover_url between", value1, value2, "articleCoverUrl");
            return (Criteria) this;
        }

        public Criteria andArticleCoverUrlNotBetween(String value1, String value2) {
            addCriterion("article_cover_url not between", value1, value2, "articleCoverUrl");
            return (Criteria) this;
        }

        public Criteria andArticleDescriptionIsNull() {
            addCriterion("article_description is null");
            return (Criteria) this;
        }

        public Criteria andArticleDescriptionIsNotNull() {
            addCriterion("article_description is not null");
            return (Criteria) this;
        }

        public Criteria andArticleDescriptionEqualTo(String value) {
            addCriterion("article_description =", value, "articleDescription");
            return (Criteria) this;
        }

        public Criteria andArticleDescriptionNotEqualTo(String value) {
            addCriterion("article_description <>", value, "articleDescription");
            return (Criteria) this;
        }

        public Criteria andArticleDescriptionGreaterThan(String value) {
            addCriterion("article_description >", value, "articleDescription");
            return (Criteria) this;
        }

        public Criteria andArticleDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("article_description >=", value, "articleDescription");
            return (Criteria) this;
        }

        public Criteria andArticleDescriptionLessThan(String value) {
            addCriterion("article_description <", value, "articleDescription");
            return (Criteria) this;
        }

        public Criteria andArticleDescriptionLessThanOrEqualTo(String value) {
            addCriterion("article_description <=", value, "articleDescription");
            return (Criteria) this;
        }

        public Criteria andArticleDescriptionLike(String value) {
            addCriterion("article_description like", value, "articleDescription");
            return (Criteria) this;
        }

        public Criteria andArticleDescriptionNotLike(String value) {
            addCriterion("article_description not like", value, "articleDescription");
            return (Criteria) this;
        }

        public Criteria andArticleDescriptionIn(List<String> values) {
            addCriterion("article_description in", values, "articleDescription");
            return (Criteria) this;
        }

        public Criteria andArticleDescriptionNotIn(List<String> values) {
            addCriterion("article_description not in", values, "articleDescription");
            return (Criteria) this;
        }

        public Criteria andArticleDescriptionBetween(String value1, String value2) {
            addCriterion("article_description between", value1, value2, "articleDescription");
            return (Criteria) this;
        }

        public Criteria andArticleDescriptionNotBetween(String value1, String value2) {
            addCriterion("article_description not between", value1, value2, "articleDescription");
            return (Criteria) this;
        }

        public Criteria andArticleReadingIsNull() {
            addCriterion("article_reading is null");
            return (Criteria) this;
        }

        public Criteria andArticleReadingIsNotNull() {
            addCriterion("article_reading is not null");
            return (Criteria) this;
        }

        public Criteria andArticleReadingEqualTo(Integer value) {
            addCriterion("article_reading =", value, "articleReading");
            return (Criteria) this;
        }

        public Criteria andArticleReadingNotEqualTo(Integer value) {
            addCriterion("article_reading <>", value, "articleReading");
            return (Criteria) this;
        }

        public Criteria andArticleReadingGreaterThan(Integer value) {
            addCriterion("article_reading >", value, "articleReading");
            return (Criteria) this;
        }

        public Criteria andArticleReadingGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_reading >=", value, "articleReading");
            return (Criteria) this;
        }

        public Criteria andArticleReadingLessThan(Integer value) {
            addCriterion("article_reading <", value, "articleReading");
            return (Criteria) this;
        }

        public Criteria andArticleReadingLessThanOrEqualTo(Integer value) {
            addCriterion("article_reading <=", value, "articleReading");
            return (Criteria) this;
        }

        public Criteria andArticleReadingIn(List<Integer> values) {
            addCriterion("article_reading in", values, "articleReading");
            return (Criteria) this;
        }

        public Criteria andArticleReadingNotIn(List<Integer> values) {
            addCriterion("article_reading not in", values, "articleReading");
            return (Criteria) this;
        }

        public Criteria andArticleReadingBetween(Integer value1, Integer value2) {
            addCriterion("article_reading between", value1, value2, "articleReading");
            return (Criteria) this;
        }

        public Criteria andArticleReadingNotBetween(Integer value1, Integer value2) {
            addCriterion("article_reading not between", value1, value2, "articleReading");
            return (Criteria) this;
        }

        public Criteria andArticleIsDeletedIsNull() {
            addCriterion("article_is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andArticleIsDeletedIsNotNull() {
            addCriterion("article_is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIsDeletedEqualTo(Boolean value) {
            addCriterion("article_is_deleted =", value, "articleIsDeleted");
            return (Criteria) this;
        }

        public Criteria andArticleIsDeletedNotEqualTo(Boolean value) {
            addCriterion("article_is_deleted <>", value, "articleIsDeleted");
            return (Criteria) this;
        }

        public Criteria andArticleIsDeletedGreaterThan(Boolean value) {
            addCriterion("article_is_deleted >", value, "articleIsDeleted");
            return (Criteria) this;
        }

        public Criteria andArticleIsDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("article_is_deleted >=", value, "articleIsDeleted");
            return (Criteria) this;
        }

        public Criteria andArticleIsDeletedLessThan(Boolean value) {
            addCriterion("article_is_deleted <", value, "articleIsDeleted");
            return (Criteria) this;
        }

        public Criteria andArticleIsDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("article_is_deleted <=", value, "articleIsDeleted");
            return (Criteria) this;
        }

        public Criteria andArticleIsDeletedIn(List<Boolean> values) {
            addCriterion("article_is_deleted in", values, "articleIsDeleted");
            return (Criteria) this;
        }

        public Criteria andArticleIsDeletedNotIn(List<Boolean> values) {
            addCriterion("article_is_deleted not in", values, "articleIsDeleted");
            return (Criteria) this;
        }

        public Criteria andArticleIsDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("article_is_deleted between", value1, value2, "articleIsDeleted");
            return (Criteria) this;
        }

        public Criteria andArticleIsDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("article_is_deleted not between", value1, value2, "articleIsDeleted");
            return (Criteria) this;
        }

        public Criteria andArticleIsTopIsNull() {
            addCriterion("article_is_top is null");
            return (Criteria) this;
        }

        public Criteria andArticleIsTopIsNotNull() {
            addCriterion("article_is_top is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIsTopEqualTo(Boolean value) {
            addCriterion("article_is_top =", value, "articleIsTop");
            return (Criteria) this;
        }

        public Criteria andArticleIsTopNotEqualTo(Boolean value) {
            addCriterion("article_is_top <>", value, "articleIsTop");
            return (Criteria) this;
        }

        public Criteria andArticleIsTopGreaterThan(Boolean value) {
            addCriterion("article_is_top >", value, "articleIsTop");
            return (Criteria) this;
        }

        public Criteria andArticleIsTopGreaterThanOrEqualTo(Boolean value) {
            addCriterion("article_is_top >=", value, "articleIsTop");
            return (Criteria) this;
        }

        public Criteria andArticleIsTopLessThan(Boolean value) {
            addCriterion("article_is_top <", value, "articleIsTop");
            return (Criteria) this;
        }

        public Criteria andArticleIsTopLessThanOrEqualTo(Boolean value) {
            addCriterion("article_is_top <=", value, "articleIsTop");
            return (Criteria) this;
        }

        public Criteria andArticleIsTopIn(List<Boolean> values) {
            addCriterion("article_is_top in", values, "articleIsTop");
            return (Criteria) this;
        }

        public Criteria andArticleIsTopNotIn(List<Boolean> values) {
            addCriterion("article_is_top not in", values, "articleIsTop");
            return (Criteria) this;
        }

        public Criteria andArticleIsTopBetween(Boolean value1, Boolean value2) {
            addCriterion("article_is_top between", value1, value2, "articleIsTop");
            return (Criteria) this;
        }

        public Criteria andArticleIsTopNotBetween(Boolean value1, Boolean value2) {
            addCriterion("article_is_top not between", value1, value2, "articleIsTop");
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