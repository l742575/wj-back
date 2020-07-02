package com.ida.wj.controller;

import com.ida.wj.common.Result;
import com.ida.wj.pojo.Books;
import com.ida.wj.pojo.Category;
import com.ida.wj.service.BookService;
import com.ida.wj.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

/**
 * @author lh
 * @date 2020/5/14
 * @description
 */
@RestController
@CrossOrigin
public class LibraryController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 获取全部图书
     * @return
     */
    @RequestMapping(value = "/api/books",method = RequestMethod.GET)
    public List<Books> list(){
        return bookService.list();
    }

    /**
     * 获取所有种类
     * @return
     */
    @RequestMapping(value = "/api/categories",method = RequestMethod.GET)
    public List<Category> categorieList(){
        return categoryService.listAll();
    }
    /**
     * 获取所有图书笔记
     */
    @RequestMapping(value = "/api/jotterList",method = RequestMethod.GET)
    public Result jotterList(){
        Result result = null;
      List<Books> list = bookService.jotterList();
      if (list!=null){
          result = new Result(200,"获取数据成功",list);

      }else{
          result = new Result(1001,"暂无数据",list);
      }
      return result;
    }
    /**
     * 编辑OR添加
     * @param book
     * @return
     */
    @RequestMapping(value = "/api/addBook",method = RequestMethod.POST)
    @CrossOrigin
    public void save(@RequestBody Books book){

        if (book!=null){
           bookService.addOrUpadte(book);
        }

    }
    @RequestMapping(value = "/api/editBook",method = RequestMethod.POST)
    @CrossOrigin

    public Result upadte(@RequestBody Books book){
        Result result = new Result();
        Integer res = null;
        String content = book.getContent();
        Integer id = book.getId();
        if (content!=null && id!=null){
           res = bookService.upadte(content,id);
        }
        if (res > 0){
            result.setCode(200);
            result.setMessage("成功");

        }else{
            result.setCode(1001);
            result.setMessage("失败");
        }
        return result;
    }

    /**
     * 根据id查询笔记
     */
    @RequestMapping(value = "/api/findContentByID/{_id}",method = RequestMethod.GET)

    public Result findContentByID(@PathVariable(value = "_id") Integer _id){
        String content = null;
        Result result = null;
        if(_id!=null){
           content = bookService.findContentByID(_id);
        }
        if(content != null){

            result = new Result(200,"成功",content);
        }else{
            result=new Result(1001,"出错");
        }
        return result;
    }
    /**
     * 删除
     * @param id
     */
    @RequestMapping(value = "/api/deleteById/{id}",method = RequestMethod.GET)
    @CrossOrigin
    public void deleteById(@PathVariable("id") Integer id){
        bookService.deleteById(id);
    }

    @RequestMapping(value = "/api/categories/{cid}",method = RequestMethod.GET)
    public List<Books> listByCategory(@PathVariable("cid") Integer cid){
       return  bookService.findByCid(cid);
    }
}
