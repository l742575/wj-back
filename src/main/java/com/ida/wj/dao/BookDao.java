package com.ida.wj.dao;

import com.ida.wj.pojo.Books;
import com.ida.wj.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author lh
 * @date 2020/5/14
 * @description
 */
public interface BookDao extends JpaRepository<Books,Integer> {
    List<Books> findAllByCategory(Category category);
    @Modifying
    @Query("update Books set content =?1 where id=?2")
    public Integer upadte(String content,Integer id);

    @Query(value = "select content from Books where id = ?1")
    public String findContentByID(Integer id);

    @Query("select b from Books b where content is not null\n")
    public List<Books> jotterList();
}
