package com.groovy.supporter.manager.controller;

import com.alibaba.fastjson.JSON;
import com.groovy.supporter.common.GroovyScriptTypeEnum;
import com.groovy.supporter.common.domain.*;
import com.groovy.supporter.common.vo.CommonResult;
import com.groovy.supporter.manager.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class APIController {

    @Autowired
    AppDOMapper appDOMapper;
    @Autowired
    MethodDOMapper methodDOMapper;
    @Autowired
    ParameterDOMapper parameterDOMapper;
    @Autowired
    PropertyDOMapper propertyDOMapper;
    @Autowired
    ScriptDOMapper scriptDOMapper;

    @RequestMapping("registerMethod")
    public CommonResult registerMethod(String classSignatureMd5, String dataListStr) {
        List<MethodDO> dataList = JSON.parseArray(dataListStr).toJavaList(MethodDO.class);
        //按照类签名删除
        methodDOMapper.deleteByExample(MethodDOExample.newAndCreateCriteria().andBelongToClassNameMd5EqualTo(classSignatureMd5).example());
        if (!CollectionUtils.isEmpty(dataList)) {
            methodDOMapper.batchInsertSelective(dataList,
                    MethodDO.Column.appKey,
                    MethodDO.Column.methodSignature,
                    MethodDO.Column.methodShortName,
                    MethodDO.Column.belongToClassName,
                    MethodDO.Column.belongToClassNameMd5,
                    MethodDO.Column.methodSignatureMd5
            );
        }
        return CommonResult.forSuccess();
    }

    @RequestMapping("registerParameter")
    public CommonResult registerParameter(String methodSignatureMd5, String dataListStr) {
        List<ParameterDO> dataList = JSON.parseArray(dataListStr).toJavaList(ParameterDO.class);
        //按照类签名删除
        parameterDOMapper.deleteByExample(ParameterDOExample.newAndCreateCriteria().andMethodSignatureMd5EqualTo(methodSignatureMd5).example());
        if (!CollectionUtils.isEmpty(dataList)) {
            parameterDOMapper.batchInsertSelective(dataList,
                    ParameterDO.Column.beloneToClassNameMd5,
                    ParameterDO.Column.methodSignature,
                    ParameterDO.Column.methodSignatureMd5,
                    ParameterDO.Column.parameterName,
                    ParameterDO.Column.parameterClassName
            );
        }
        return CommonResult.forSuccess();
    }

    @RequestMapping("registerProperty")
    public CommonResult registerProperty(String classSignatureMd5, String dataListStr) {
        List<PropertyDO> dataList = JSON.parseArray(dataListStr).toJavaList(PropertyDO.class);
        //按照类签名删除
        propertyDOMapper.deleteByExample(PropertyDOExample.newAndCreateCriteria().andBeloneToClassSignatureMd5EqualTo(classSignatureMd5).example());
        if (!CollectionUtils.isEmpty(dataList)) {
            propertyDOMapper.batchInsertSelective(dataList,
                    PropertyDO.Column.beloneToClassSignatureMd5,
                    PropertyDO.Column.beloneToClassName,
                    PropertyDO.Column.propertyClassName,
                    PropertyDO.Column.propertyName);
        }
        return CommonResult.forSuccess();
    }

    @RequestMapping("createGroovyScriptTemplate")
    public CommonResult createGroovyScriptTemplate(String classSignatureMd5, String dataListStr) {
        List<ScriptDO> dataList = JSON.parseArray(dataListStr).toJavaList(ScriptDO.class);
        //按照方法签名删除
        scriptDOMapper.deleteByExample(ScriptDOExample.newAndCreateCriteria().andBeloneToClassSignatureMd5EqualTo(classSignatureMd5).andTypeEqualTo(GroovyScriptTypeEnum.TEMPLATE.type).example());
        if (!CollectionUtils.isEmpty(dataList)) {
            scriptDOMapper.batchInsertSelective(dataList,
                    ScriptDO.Column.appKey,
                    ScriptDO.Column.methodSignatureMd5,
                    ScriptDO.Column.beloneToClassSignatureMd5,
                    ScriptDO.Column.type,
                    ScriptDO.Column.script
            );
        }
        return CommonResult.forSuccess();
    }

    @RequestMapping("listScript")
    public String listScript(String appKey) {
        List<ScriptDO> scriptDOS = scriptDOMapper.selectByExampleWithBLOBs(ScriptDOExample.newAndCreateCriteria()
                .andTypeNotEqualTo(GroovyScriptTypeEnum.TEMPLATE.type)
                .andAppKeyEqualTo(appKey)
                .example());
        return JSON.toJSONString(scriptDOS);
    }

    @RequestMapping("checkAppKey")
    public Boolean checkAppKey(String appKey) {
        boolean count = appDOMapper.countByExample(AppDOExample.newAndCreateCriteria()
                .andAppKeyEqualTo(appKey)
                .andLogicalDeleted(false).example()) > 0;
        return count;
    }

}
