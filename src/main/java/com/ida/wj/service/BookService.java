package com.ida.wj.service;

import com.ida.wj.common.ToolUtils;
import com.ida.wj.dao.BookDao;
import com.ida.wj.dao.CategoryDAO;
import com.ida.wj.dao.UserDao;
import com.ida.wj.pojo.Books;
import com.ida.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lh
 * @date 2020/5/14
 * @description
 */
@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private CategoryService categoryService;

    /**
     * 返回所有图书列表
     * @return
     */
    public List<Books> list(){
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        System.out.println("sort:---"+sort);
        return bookDao.findAll(sort);
    }
    public List<Books> jotterList(){
        return bookDao.jotterList();
    }
    /**
     * 保存数据
     * @param book
     */
    public void addOrUpadte(Books book){
        Integer cid =   book.getCategory().getId();
        //判断分类
        if (cid.toString().equals("0") || cid.toString().isEmpty() ||cid.toString().equals("")){
            book.getCategory().setId(1);
        }else{
            book.getCategory().setId(cid);
        }

        //如果ID有值-更新
        if(book.getId()!=null){

            if (!book.getDate().isEmpty() && book.getDate().contains("T")){
                String d2 = ToolUtils.dateString(book.getDate());
                book.setDate(d2);
            }
        }else{

            //如果无ID-保存
            //判断日期
            if (book.getDate().equals("") ||!book.getDate().isEmpty()){
                //日期格式化后设置日期
                String d2 = ToolUtils.dateString(book.getDate());
                book.setDate(d2);
            }
            //设置创建时间
            //book.setCreateDate(new Date());
        }

        bookDao.save(book);
    }
    /**
     * 编辑
     */
    @Transactional
    public Integer upadte(String content,Integer id){
        return bookDao.upadte(content,id);
    }
    /**
     * 根据ID查询笔记
     */
    public String findContentByID(Integer id){
        return bookDao.findContentByID(id);
    }
    /**
     * 删除
     * @param id
     */
    public void deleteById(Integer id){
        bookDao.deleteById(id);
    }

    /**
     * 根据种类ID查询对应图书
     * @param cid
     * @return
     */
    public List<Books> findByCid(Integer cid){
        if (cid.toString().equals("1")){
            return bookDao.findAll();
        }
        Category category = categoryService.get(cid);
        return bookDao.findAllByCategory(category);
    }
}
