package com.rj.bd.review.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author wxy
 * @desc review 实体类
 * @time 2021-06-01-10:02
 *
 */
@Data
public class Review {
    private String sid;
    private String uname;
    private String hname;
    private String vname;
    private Date time;
}
