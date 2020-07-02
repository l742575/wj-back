package com.ida.wj.service;

import com.ida.wj.dao.CategoryDAO;
import com.ida.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lh
 * @date 2020/5/14
 * @description
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    /**
     * 通过ID查询种类
     * @param category
     * @return
     */
    public List<Category> list(Category category){
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        return categoryDAO.findAll(sort);
    }

    /**
     * 查询所有种类
     * @return
     */
    public List<Category> listAll(){
       return categoryDAO.findAll();
    }

    /**
     * 根据ID查询种类
     * @param id
     * @return
     */

    public Category get(Integer id){
        return categoryDAO.findById(id).orElse(null);
    }
}
