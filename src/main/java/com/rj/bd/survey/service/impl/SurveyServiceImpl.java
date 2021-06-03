package com.rj.bd.survey.service.impl;


import com.github.pagehelper.PageHelper;
import com.rj.bd.survey.entity.SurveyShow;
import com.rj.bd.survey.mapper.SurveyMapper;
import com.rj.bd.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author mxj
 * @since 2021-06-01
 */
@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    SurveyMapper surveyMapper;

    @Override
    public List<SurveyShow> queryAllPage(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        return surveyMapper.queryAll();
    }

    @Override
    public List<SurveyShow> queryByName(String name, String vid, Integer page, Integer limit) {
        String real_name = "%" + name + "%";

        if ("".equals(vid) || vid == null) {
            vid = "%";
        }

        PageHelper.startPage(page, limit);
        return surveyMapper.queryByName(real_name, vid);

    }
}
