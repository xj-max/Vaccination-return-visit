package com.rj.bd.survey.controller;

import com.github.pagehelper.PageInfo;
import com.rj.bd.survey.entity.SurveyShow;
import com.rj.bd.survey.service.SurveyService;
import com.rj.bd.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mxj
 * @since 2021-06-01
 */
@RestController
@RequestMapping("/admin/survey")
@CrossOrigin("*")
public class SurveyController {

    @Autowired
    SurveyService surveyService;

    @RequestMapping("/queryAllPage")
    public Map<String, Object> queryAllPage(Integer page, Integer limit) {

        Map<String, Object> map = new HashMap<String, Object>();
        List<SurveyShow> list = surveyService.queryAllPage(page, limit);

        PageInfo<SurveyShow> reservationPageInfo = new PageInfo<SurveyShow>(list);
        map.put("code", 0);
        map.put("msg", "请求成功");
        map.put("count", reservationPageInfo.getTotal());
        map.put("data", reservationPageInfo.getList());
        return map;

    }

    @RequestMapping("/queryByName")
    public Map<String, Object> queryByName(String name, String vid, Integer page, Integer limit) {

        Map<String, Object> map = new HashMap<String, Object>();
        List<SurveyShow> list = surveyService.queryByName(name, vid, page, limit);

        PageInfo<SurveyShow> reservationPageInfo = new PageInfo<SurveyShow>(list);
        map.put("code", 0);
        map.put("msg", "请求成功");
        map.put("count", reservationPageInfo.getTotal());
        map.put("data", reservationPageInfo.getList());

        return map;

    }

}

