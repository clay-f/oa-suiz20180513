package com.f.core.common;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Page<T> implements Iterable<T> {
    private int min = 1;
    private int max = 30;
    private boolean isCountTotal = true;
    private boolean queryResult = true;
    private int pageSize = 1;
    private int countSize = 0;
    private List<T> result = null;

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public boolean isCountTotal() {
        return isCountTotal;
    }

    public void setCountTotal(boolean countTotal) {
        this.isCountTotal = countTotal;
    }

    public boolean isQueryResult() {
        return queryResult;
    }

    public void setQueryResult(boolean queryResult) {
        this.queryResult = queryResult;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public int getCountSize() {
        return countSize;
    }

    public void setCountSize(int countSize) {
        this.countSize = countSize;
    }

    @Override
    public Iterator<T> iterator() {
        return result.iterator();
    }
}
