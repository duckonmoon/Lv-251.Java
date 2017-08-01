package com.softserve.edu.lv251.service;

import java.util.List;

/**
 *
 */
public interface PagingSizeService<T> {

    int numberOfPaging(Integer size);

    List<T> getEntity(Integer chainIndex, Integer size);

}
