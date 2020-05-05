package com.github.justgame.springmvctest.service;

import com.github.justgame.springmvctest.entity.Good;
import com.github.justgame.springmvctest.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author XieCl
 * @date 2020/5/5 2:01
 */
@Service
public class GoodService {
    @Autowired
    private GoodRepository goodRepository;

    public Page<Good> list(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createAt").descending());
        return goodRepository.findAll(pageable);
    }
}
