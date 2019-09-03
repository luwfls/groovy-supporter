package com.groovy.supporter.manager.dao;

import com.groovy.supporter.common.domain.AppDO;
import com.groovy.supporter.common.domain.AppDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppDOMapper {
    long countByExample(AppDOExample example);

    int deleteByExample(AppDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppDO record);

    int insertSelective(@Param("record") AppDO record, @Param("selective") AppDO.Column ... selective);

    AppDO selectOneByExample(AppDOExample example);

    List<AppDO> selectByExample(AppDOExample example);

    AppDO selectByPrimaryKey(Long id);

    AppDO selectByPrimaryKeyWithLogicalDelete(@Param("id") Long id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") AppDO record, @Param("example") AppDOExample example, @Param("selective") AppDO.Column ... selective);

    int updateByExample(@Param("record") AppDO record, @Param("example") AppDOExample example);

    int updateByPrimaryKeySelective(@Param("record") AppDO record, @Param("selective") AppDO.Column ... selective);

    int updateByPrimaryKey(AppDO record);

    int batchInsert(@Param("list") List<AppDO> list);

    int batchInsertSelective(@Param("list") List<AppDO> list, @Param("selective") AppDO.Column ... selective);

    int logicalDeleteByExample(@Param("example") AppDOExample example);

    int logicalDeleteByPrimaryKey(Long id);

    int upsert(AppDO record);

    int upsertByExample(@Param("record") AppDO record, @Param("example") AppDOExample example);

    int upsertByExampleSelective(@Param("record") AppDO record, @Param("example") AppDOExample example, @Param("selective") AppDO.Column ... selective);

    int upsertSelective(@Param("record") AppDO record, @Param("selective") AppDO.Column ... selective);

    int batchUpsert(@Param("list") List<AppDO> list);

    int batchUpsertSelective(@Param("list") List<AppDO> list, @Param("selective") AppDO.Column ... selective);
}