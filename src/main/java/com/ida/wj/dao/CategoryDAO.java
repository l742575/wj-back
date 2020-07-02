package com.ida.wj.dao;

import com.ida.wj.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lh
 * @date 2020/5/14
 * @description
 */
public interface CategoryDAO extends JpaRepository<Category,Integer> {

}
