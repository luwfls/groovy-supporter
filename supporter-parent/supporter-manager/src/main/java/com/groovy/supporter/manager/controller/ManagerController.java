package com.groovy.supporter.manager.controller;

import com.groovy.supporter.common.GroovyScriptTypeEnum;
import com.groovy.supporter.common.domain.*;
import com.groovy.supporter.common.vo.CommonResult;
import com.groovy.supporter.manager.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("manager")
public class ManagerController {

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

    @RequestMapping("listSystem")
    public CommonResult listSystem() {
        return CommonResult.forSuccess(appDOMapper.selectByExample(AppDOExample.newAndCreateCriteria().andLogicalDeleted(false).example()));
    }

    @RequestMapping("listMethod")
    public CommonResult listMethod(String appKey) {
        return CommonResult.forSuccess(methodDOMapper.selectByExample(MethodDOExample.newAndCreateCriteria().andAppKeyEqualTo(appKey).andLogicalDeleted(false).example()));
    }

    @RequestMapping("listParameter")
    public Object listParameter(String methodSignatureMd5) {
        Map<String, Object> map = new HashMap<>();
        List<ParameterDO> methodDOS = parameterDOMapper.selectByExample(ParameterDOExample.newAndCreateCriteria().andMethodSignatureMd5EqualTo(methodSignatureMd5).andLogicalDeleted(false).example());
        map.put("total", methodDOS.size());
        map.put("rows", methodDOS);
        return map;
    }

    @RequestMapping("listProperty")
    public Object listProperty(String classMd5) {
        Map<String, Object> map = new HashMap<>();
        List<PropertyDO> propertyDOS = propertyDOMapper.selectByExample(PropertyDOExample.newAndCreateCriteria().andBeloneToClassSignatureMd5EqualTo(classMd5).andLogicalDeleted(false).example());
        map.put("total", propertyDOS.size());
        map.put("rows", propertyDOS);
        return map;
    }

    @RequestMapping("getScript")
    public CommonResult getScript(String methodMd5) {
        ScriptDO scriptDO = scriptDOMapper.selectOneByExampleWithBLOBs(ScriptDOExample.newAndCreateCriteria()
                .andMethodSignatureMd5EqualTo(methodMd5)
                .andTypeNotEqualTo(GroovyScriptTypeEnum.TEMPLATE.type)
//                .andLogicalDeleted(false)
                .example());
        if (scriptDO != null) {
            return CommonResult.forSuccess(scriptDO);
        } else {
            ScriptDO template = scriptDOMapper.selectOneByExampleWithBLOBs(ScriptDOExample.newAndCreateCriteria()
                    .andMethodSignatureMd5EqualTo(methodMd5)
                    .andTypeEqualTo(GroovyScriptTypeEnum.TEMPLATE.type)
                    .andLogicalDeleted(false)
                    .example());
            return CommonResult.forSuccess(template);
        }
    }

    @RequestMapping("saveScript")
    public CommonResult saveScript(String methodMd5, String script, Integer executeTargetMethod, Integer aspectType) {
        ScriptDO scriptDO = scriptDOMapper.selectOneByExampleWithBLOBs(ScriptDOExample.newAndCreateCriteria()
                .andMethodSignatureMd5EqualTo(methodMd5)
                .andTypeNotEqualTo(GroovyScriptTypeEnum.TEMPLATE.type)
                .andLogicalDeleted(false)
                .example());
        if (scriptDO != null) {
            scriptDO.setScript(script);
            scriptDO.setType(aspectType.byteValue());
            scriptDO.setExecuteTargetMethod(executeTargetMethod.byteValue());
            scriptDOMapper.updateByExampleSelective(scriptDO,
                    ScriptDOExample.newAndCreateCriteria()
                            .andMethodSignatureMd5EqualTo(methodMd5)
                            .andTypeNotEqualTo(GroovyScriptTypeEnum.TEMPLATE.type)
                            .andLogicalDeleted(false)
                            .example(), ScriptDO.Column.script, ScriptDO.Column.executeTargetMethod, ScriptDO.Column.type
            );
            return CommonResult.forSuccess();
        } else {
            scriptDO = scriptDOMapper.selectOneByExample(ScriptDOExample.newAndCreateCriteria()
                    .andMethodSignatureMd5EqualTo(methodMd5)
                    .andTypeEqualTo(GroovyScriptTypeEnum.TEMPLATE.type)
                    .andLogicalDeleted(false)
                    .example());

            scriptDO.setType(aspectType.byteValue());
            scriptDO.setExecuteTargetMethod(executeTargetMethod.byteValue());
            scriptDO.setScript(script);

            scriptDOMapper.insertSelective(scriptDO,
                    ScriptDO.Column.appKey,
                    ScriptDO.Column.methodSignatureMd5,
                    ScriptDO.Column.beloneToClassSignatureMd5,
                    ScriptDO.Column.type,
                    ScriptDO.Column.executeTargetMethod,
                    ScriptDO.Column.script);
            return CommonResult.forSuccess();
        }
    }

    @RequestMapping("unloadScript")
    public CommonResult unloadScript(String methodMd5) {
        ScriptDO scriptDO = scriptDOMapper.selectOneByExampleWithBLOBs(ScriptDOExample.newAndCreateCriteria()
                .andMethodSignatureMd5EqualTo(methodMd5)
                .andTypeNotEqualTo(GroovyScriptTypeEnum.TEMPLATE.type)
                .example());
        if(scriptDO!=null){
            scriptDOMapper.logicalDeleteByPrimaryKey(scriptDO.getId());
        }
        return CommonResult.forSuccess();
    }

}
