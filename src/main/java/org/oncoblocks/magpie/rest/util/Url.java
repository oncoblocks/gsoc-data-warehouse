package org.oncoblocks.magpie.rest.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.ArrayList;
import java.util.List;

public class Url {

    public static Sort.Order parseSort(String str) throws IllegalArgumentException {
        String[] pair = str.split(":");
        if (pair.length != 2)
            throw new IllegalArgumentException("Incorrect sort criterion format; example: \"sort=entrezGeneId:asc\"");
        String name = pair[0];
        if (pair.length == 1)
            return new Sort.Order(Sort.Direction.ASC, name);
        else if (pair.length == 2) {
            if (pair[1].equals("asc"))
                return new Sort.Order(Sort.Direction.ASC, name);
            else if (pair[1].equals("desc"))
                return new Sort.Order(Sort.Direction.DESC, name);
            else
                throw new IllegalArgumentException("Incorrect sort criterion format; example: \"sort=entrezGeneId:asc\"");
        }
        else
            throw new IllegalArgumentException("Incorrect sort criterion format; example: \"sort=entrezGeneId:asc\"");
    }

    public static Sort sortFromList (List<String> sortList) {
        List<Sort.Order> orders= new ArrayList<>();
        if (sortList != null) {
            for (String sortStr : sortList)
                orders.add(Url.parseSort(sortStr));
            return new Sort(orders);
        }
        else
            return null;
    }

    public static PageRequest parsePageRequest (Integer page, Integer size, List<String> sortList) {
        if (sortList != null)
            return new PageRequest(page, size, sortFromList(sortList));
        else
            return new PageRequest(page, size);
    }

    public static Criteria parseFloatQuery(String criteriaStr, String key) throws IllegalArgumentException {
        String[] pair = criteriaStr.split(":");
        Criteria criteria = Criteria.where(key);
        if (pair.length != 2)
            throw new IllegalArgumentException("Incorrect float value criteria format; example: \"value=gt:0.023\"");
        String operator = pair[0];
        Float cnvValue = Float.parseFloat(pair[1]);
        if (operator.equals("gte"))
            criteria = criteria.gte(cnvValue);
        else if (operator.equals("lte"))
            criteria = criteria.lte(cnvValue);
        else if (operator.equals("gt"))
            criteria = criteria.gt(cnvValue);
        else if (operator.equals("lt"))
            criteria = criteria.lt(cnvValue);
        else
            throw new IllegalArgumentException("Incorrect float value criteria format; example: \"value=gt:0.023\"");
        return criteria;
    }


}
