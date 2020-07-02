//package com.ida.wj.pojo;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import org.hibernate.annotations.GeneratorType;
//
//import javax.persistence.*;
//
///**
// * @author lh
// * @date 2020/5/28
// * @description 笔记
// */
//@Entity
//@Table(name = "jotter")
//@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
//public class Jotter {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Integer id;
//    @ManyToOne
//    private Integer book_id;
//    private String content;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public Integer getBook_id() {
//        return book_id;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public void setBook_id(Integer book_id) {
//        this.book_id = book_id;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//}
