package com.groovy.supporter.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.groovy.supporter.common.domain.ScriptDO;
import com.groovy.supporter.common.vo.CommonResult;
import com.groovy.supporter.core.config.GroovySupporterConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Component
public class GroovyManagerClient {

    private String registerMethodUrl = "/api/registerMethod";
    private String registerParameterUrl = "/api/registerParameter";
    private String registerPropertyUrl = "/api/registerProperty";
    private String createGroovyScriptUrl = "/api/createGroovyScriptTemplate";
    private String listScriptUrl = "/api/listScript";
    private String checkAppKeyUrl = "/api/checkAppKey";

    @Autowired
    private GroovySupporterConfig groovySupporterConfig;


    public void registerMethod(String classSignatureMd5, List dataList) {
        try {
            HttpHeaders headers = new HttpHeaders();
            MultiValueMap<String, String> parmas = new LinkedMultiValueMap<>();
            parmas.put("classSignatureMd5", Collections.singletonList(classSignatureMd5));
            parmas.put("dataListStr", Collections.singletonList(JSON.toJSONString(dataList)));
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(parmas, headers);
            new RestTemplate().postForObject(groovySupporterConfig.getManagerServer() + registerMethodUrl, request, CommonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerParameter(String methodSignatureMd5, List dataList) {
        try {
            HttpHeaders headers = new HttpHeaders();
            MultiValueMap<String, String> parmas = new LinkedMultiValueMap<>();
            parmas.put("methodSignatureMd5", Collections.singletonList(methodSignatureMd5));
            parmas.put("dataListStr", Collections.singletonList(JSON.toJSONString(dataList)));
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(parmas, headers);
            new RestTemplate().postForObject(groovySupporterConfig.getManagerServer() + registerParameterUrl, request, CommonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerProperty(String classSignatureMd5, List dataList) {
        try {
            HttpHeaders headers = new HttpHeaders();
            MultiValueMap<String, String> parmas = new LinkedMultiValueMap<>();
            parmas.put("classSignatureMd5", Collections.singletonList(classSignatureMd5));
            parmas.put("dataListStr", Collections.singletonList(JSON.toJSONString(dataList)));
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(parmas, headers);
            new RestTemplate().postForObject(groovySupporterConfig.getManagerServer() + registerPropertyUrl, request, CommonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createGroovyScriptTemplate(String classSignatureMd5, List dataList) {
        try {
            HttpHeaders headers = new HttpHeaders();
            MultiValueMap<String, String> parmas = new LinkedMultiValueMap<>();
            parmas.put("classSignatureMd5", Collections.singletonList(classSignatureMd5));
            parmas.put("dataListStr", Collections.singletonList(JSON.toJSONString(dataList)));
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(parmas, headers);
            new RestTemplate().postForObject(groovySupporterConfig.getManagerServer() + createGroovyScriptUrl, request, CommonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ScriptDO> listScript(String appKey) {
        try {
            HttpHeaders headers = new HttpHeaders();
            MultiValueMap<String, String> parmas = new LinkedMultiValueMap<>();
            parmas.put("appKey", Collections.singletonList(appKey));
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(parmas, headers);
            String dataStr =  new RestTemplate().postForObject(groovySupporterConfig.getManagerServer() + listScriptUrl, request, String.class);
            if (StringUtils.isEmpty(dataStr)) {
                return null;
            } else {
                return JSONArray.parseArray(dataStr, ScriptDO.class);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean checkAppKey(String appKey) {
        try {
            HttpHeaders headers = new HttpHeaders();
            MultiValueMap<String, String> parmas = new LinkedMultiValueMap<>();
            parmas.put("appKey", Collections.singletonList(appKey));
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(parmas, headers);
            return  new RestTemplate().postForObject(groovySupporterConfig.getManagerServer() + checkAppKeyUrl, request, Boolean.class);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
