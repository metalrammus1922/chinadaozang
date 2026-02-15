package com.rammus.daozang.domain;

import java.util.ArrayList;
import java.util.List;

public class EventExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EventExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andEventidIsNull() {
            addCriterion("EventID is null");
            return (Criteria) this;
        }

        public Criteria andEventidIsNotNull() {
            addCriterion("EventID is not null");
            return (Criteria) this;
        }

        public Criteria andEventidEqualTo(String value) {
            addCriterion("EventID =", value, "eventid");
            return (Criteria) this;
        }

        public Criteria andEventidNotEqualTo(String value) {
            addCriterion("EventID <>", value, "eventid");
            return (Criteria) this;
        }

        public Criteria andEventidGreaterThan(String value) {
            addCriterion("EventID >", value, "eventid");
            return (Criteria) this;
        }

        public Criteria andEventidGreaterThanOrEqualTo(String value) {
            addCriterion("EventID >=", value, "eventid");
            return (Criteria) this;
        }

        public Criteria andEventidLessThan(String value) {
            addCriterion("EventID <", value, "eventid");
            return (Criteria) this;
        }

        public Criteria andEventidLessThanOrEqualTo(String value) {
            addCriterion("EventID <=", value, "eventid");
            return (Criteria) this;
        }

        public Criteria andEventidLike(String value) {
            addCriterion("EventID like", value, "eventid");
            return (Criteria) this;
        }

        public Criteria andEventidNotLike(String value) {
            addCriterion("EventID not like", value, "eventid");
            return (Criteria) this;
        }

        public Criteria andEventidIn(List<String> values) {
            addCriterion("EventID in", values, "eventid");
            return (Criteria) this;
        }

        public Criteria andEventidNotIn(List<String> values) {
            addCriterion("EventID not in", values, "eventid");
            return (Criteria) this;
        }

        public Criteria andEventidBetween(String value1, String value2) {
            addCriterion("EventID between", value1, value2, "eventid");
            return (Criteria) this;
        }

        public Criteria andEventidNotBetween(String value1, String value2) {
            addCriterion("EventID not between", value1, value2, "eventid");
            return (Criteria) this;
        }

        public Criteria andRowidIsNull() {
            addCriterion("`RowID` is null");
            return (Criteria) this;
        }

        public Criteria andRowidIsNotNull() {
            addCriterion("`RowID` is not null");
            return (Criteria) this;
        }

        public Criteria andRowidEqualTo(String value) {
            addCriterion("`RowID` =", value, "rowid");
            return (Criteria) this;
        }

        public Criteria andRowidNotEqualTo(String value) {
            addCriterion("`RowID` <>", value, "rowid");
            return (Criteria) this;
        }

        public Criteria andRowidGreaterThan(String value) {
            addCriterion("`RowID` >", value, "rowid");
            return (Criteria) this;
        }

        public Criteria andRowidGreaterThanOrEqualTo(String value) {
            addCriterion("`RowID` >=", value, "rowid");
            return (Criteria) this;
        }

        public Criteria andRowidLessThan(String value) {
            addCriterion("`RowID` <", value, "rowid");
            return (Criteria) this;
        }

        public Criteria andRowidLessThanOrEqualTo(String value) {
            addCriterion("`RowID` <=", value, "rowid");
            return (Criteria) this;
        }

        public Criteria andRowidLike(String value) {
            addCriterion("`RowID` like", value, "rowid");
            return (Criteria) this;
        }

        public Criteria andRowidNotLike(String value) {
            addCriterion("`RowID` not like", value, "rowid");
            return (Criteria) this;
        }

        public Criteria andRowidIn(List<String> values) {
            addCriterion("`RowID` in", values, "rowid");
            return (Criteria) this;
        }

        public Criteria andRowidNotIn(List<String> values) {
            addCriterion("`RowID` not in", values, "rowid");
            return (Criteria) this;
        }

        public Criteria andRowidBetween(String value1, String value2) {
            addCriterion("`RowID` between", value1, value2, "rowid");
            return (Criteria) this;
        }

        public Criteria andRowidNotBetween(String value1, String value2) {
            addCriterion("`RowID` not between", value1, value2, "rowid");
            return (Criteria) this;
        }

        public Criteria andEventnameIsNull() {
            addCriterion("EventName is null");
            return (Criteria) this;
        }

        public Criteria andEventnameIsNotNull() {
            addCriterion("EventName is not null");
            return (Criteria) this;
        }

        public Criteria andEventnameEqualTo(String value) {
            addCriterion("EventName =", value, "eventname");
            return (Criteria) this;
        }

        public Criteria andEventnameNotEqualTo(String value) {
            addCriterion("EventName <>", value, "eventname");
            return (Criteria) this;
        }

        public Criteria andEventnameGreaterThan(String value) {
            addCriterion("EventName >", value, "eventname");
            return (Criteria) this;
        }

        public Criteria andEventnameGreaterThanOrEqualTo(String value) {
            addCriterion("EventName >=", value, "eventname");
            return (Criteria) this;
        }

        public Criteria andEventnameLessThan(String value) {
            addCriterion("EventName <", value, "eventname");
            return (Criteria) this;
        }

        public Criteria andEventnameLessThanOrEqualTo(String value) {
            addCriterion("EventName <=", value, "eventname");
            return (Criteria) this;
        }

        public Criteria andEventnameLike(String value) {
            addCriterion("EventName like", value, "eventname");
            return (Criteria) this;
        }

        public Criteria andEventnameNotLike(String value) {
            addCriterion("EventName not like", value, "eventname");
            return (Criteria) this;
        }

        public Criteria andEventnameIn(List<String> values) {
            addCriterion("EventName in", values, "eventname");
            return (Criteria) this;
        }

        public Criteria andEventnameNotIn(List<String> values) {
            addCriterion("EventName not in", values, "eventname");
            return (Criteria) this;
        }

        public Criteria andEventnameBetween(String value1, String value2) {
            addCriterion("EventName between", value1, value2, "eventname");
            return (Criteria) this;
        }

        public Criteria andEventnameNotBetween(String value1, String value2) {
            addCriterion("EventName not between", value1, value2, "eventname");
            return (Criteria) this;
        }

        public Criteria andEventcontentIsNull() {
            addCriterion("EventContent is null");
            return (Criteria) this;
        }

        public Criteria andEventcontentIsNotNull() {
            addCriterion("EventContent is not null");
            return (Criteria) this;
        }

        public Criteria andEventcontentEqualTo(String value) {
            addCriterion("EventContent =", value, "eventcontent");
            return (Criteria) this;
        }

        public Criteria andEventcontentNotEqualTo(String value) {
            addCriterion("EventContent <>", value, "eventcontent");
            return (Criteria) this;
        }

        public Criteria andEventcontentGreaterThan(String value) {
            addCriterion("EventContent >", value, "eventcontent");
            return (Criteria) this;
        }

        public Criteria andEventcontentGreaterThanOrEqualTo(String value) {
            addCriterion("EventContent >=", value, "eventcontent");
            return (Criteria) this;
        }

        public Criteria andEventcontentLessThan(String value) {
            addCriterion("EventContent <", value, "eventcontent");
            return (Criteria) this;
        }

        public Criteria andEventcontentLessThanOrEqualTo(String value) {
            addCriterion("EventContent <=", value, "eventcontent");
            return (Criteria) this;
        }

        public Criteria andEventcontentLike(String value) {
            addCriterion("EventContent like", value, "eventcontent");
            return (Criteria) this;
        }

        public Criteria andEventcontentNotLike(String value) {
            addCriterion("EventContent not like", value, "eventcontent");
            return (Criteria) this;
        }

        public Criteria andEventcontentIn(List<String> values) {
            addCriterion("EventContent in", values, "eventcontent");
            return (Criteria) this;
        }

        public Criteria andEventcontentNotIn(List<String> values) {
            addCriterion("EventContent not in", values, "eventcontent");
            return (Criteria) this;
        }

        public Criteria andEventcontentBetween(String value1, String value2) {
            addCriterion("EventContent between", value1, value2, "eventcontent");
            return (Criteria) this;
        }

        public Criteria andEventcontentNotBetween(String value1, String value2) {
            addCriterion("EventContent not between", value1, value2, "eventcontent");
            return (Criteria) this;
        }

        public Criteria andEventtypeIsNull() {
            addCriterion("EventType is null");
            return (Criteria) this;
        }

        public Criteria andEventtypeIsNotNull() {
            addCriterion("EventType is not null");
            return (Criteria) this;
        }

        public Criteria andEventtypeEqualTo(String value) {
            addCriterion("EventType =", value, "eventtype");
            return (Criteria) this;
        }

        public Criteria andEventtypeNotEqualTo(String value) {
            addCriterion("EventType <>", value, "eventtype");
            return (Criteria) this;
        }

        public Criteria andEventtypeGreaterThan(String value) {
            addCriterion("EventType >", value, "eventtype");
            return (Criteria) this;
        }

        public Criteria andEventtypeGreaterThanOrEqualTo(String value) {
            addCriterion("EventType >=", value, "eventtype");
            return (Criteria) this;
        }

        public Criteria andEventtypeLessThan(String value) {
            addCriterion("EventType <", value, "eventtype");
            return (Criteria) this;
        }

        public Criteria andEventtypeLessThanOrEqualTo(String value) {
            addCriterion("EventType <=", value, "eventtype");
            return (Criteria) this;
        }

        public Criteria andEventtypeLike(String value) {
            addCriterion("EventType like", value, "eventtype");
            return (Criteria) this;
        }

        public Criteria andEventtypeNotLike(String value) {
            addCriterion("EventType not like", value, "eventtype");
            return (Criteria) this;
        }

        public Criteria andEventtypeIn(List<String> values) {
            addCriterion("EventType in", values, "eventtype");
            return (Criteria) this;
        }

        public Criteria andEventtypeNotIn(List<String> values) {
            addCriterion("EventType not in", values, "eventtype");
            return (Criteria) this;
        }

        public Criteria andEventtypeBetween(String value1, String value2) {
            addCriterion("EventType between", value1, value2, "eventtype");
            return (Criteria) this;
        }

        public Criteria andEventtypeNotBetween(String value1, String value2) {
            addCriterion("EventType not between", value1, value2, "eventtype");
            return (Criteria) this;
        }

        public Criteria andEventlocationIsNull() {
            addCriterion("EventLocation is null");
            return (Criteria) this;
        }

        public Criteria andEventlocationIsNotNull() {
            addCriterion("EventLocation is not null");
            return (Criteria) this;
        }

        public Criteria andEventlocationEqualTo(String value) {
            addCriterion("EventLocation =", value, "eventlocation");
            return (Criteria) this;
        }

        public Criteria andEventlocationNotEqualTo(String value) {
            addCriterion("EventLocation <>", value, "eventlocation");
            return (Criteria) this;
        }

        public Criteria andEventlocationGreaterThan(String value) {
            addCriterion("EventLocation >", value, "eventlocation");
            return (Criteria) this;
        }

        public Criteria andEventlocationGreaterThanOrEqualTo(String value) {
            addCriterion("EventLocation >=", value, "eventlocation");
            return (Criteria) this;
        }

        public Criteria andEventlocationLessThan(String value) {
            addCriterion("EventLocation <", value, "eventlocation");
            return (Criteria) this;
        }

        public Criteria andEventlocationLessThanOrEqualTo(String value) {
            addCriterion("EventLocation <=", value, "eventlocation");
            return (Criteria) this;
        }

        public Criteria andEventlocationLike(String value) {
            addCriterion("EventLocation like", value, "eventlocation");
            return (Criteria) this;
        }

        public Criteria andEventlocationNotLike(String value) {
            addCriterion("EventLocation not like", value, "eventlocation");
            return (Criteria) this;
        }

        public Criteria andEventlocationIn(List<String> values) {
            addCriterion("EventLocation in", values, "eventlocation");
            return (Criteria) this;
        }

        public Criteria andEventlocationNotIn(List<String> values) {
            addCriterion("EventLocation not in", values, "eventlocation");
            return (Criteria) this;
        }

        public Criteria andEventlocationBetween(String value1, String value2) {
            addCriterion("EventLocation between", value1, value2, "eventlocation");
            return (Criteria) this;
        }

        public Criteria andEventlocationNotBetween(String value1, String value2) {
            addCriterion("EventLocation not between", value1, value2, "eventlocation");
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