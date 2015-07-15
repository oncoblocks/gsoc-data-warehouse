package org.oncoblocks.magpie.rest.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class Url {

    public static Sort.Order parseSort(String str) throws IllegalArgumentException {
        String[] pair = str.split(":");
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

    public static PageRequest parsePageRequest (Integer page, Integer size, List<String> sortList) {
        List<Sort.Order> orders= new ArrayList<>();
        if (sortList != null) {
            for (String sortStr : sortList)
                orders.add(Url.parseSort(sortStr));
            Sort sort = new Sort(orders);
            return new PageRequest(page, size, sort);

        }
        else
            return new PageRequest(page, size);
    }

}
