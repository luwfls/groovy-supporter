package com.groovy.supporter.manager.dao;

import com.groovy.supporter.common.domain.ScriptDO;
import com.groovy.supporter.common.domain.ScriptDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScriptDOMapper {
    long countByExample(ScriptDOExample example);

    int deleteByExample(ScriptDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ScriptDO record);

    int insertSelective(@Param("record") ScriptDO record, @Param("selective") ScriptDO.Column ... selective);

    ScriptDO selectOneByExample(ScriptDOExample example);

    ScriptDO selectOneByExampleWithBLOBs(ScriptDOExample example);

    List<ScriptDO> selectByExampleWithBLOBs(ScriptDOExample example);

    List<ScriptDO> selectByExample(ScriptDOExample example);

    ScriptDO selectByPrimaryKey(Long id);

    ScriptDO selectByPrimaryKeyWithLogicalDelete(@Param("id") Long id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") ScriptDO record, @Param("example") ScriptDOExample example, @Param("selective") ScriptDO.Column ... selective);

    int updateByExampleWithBLOBs(@Param("record") ScriptDO record, @Param("example") ScriptDOExample example);

    int updateByExample(@Param("record") ScriptDO record, @Param("example") ScriptDOExample example);

    int updateByPrimaryKeySelective(@Param("record") ScriptDO record, @Param("selective") ScriptDO.Column ... selective);

    int updateByPrimaryKeyWithBLOBs(ScriptDO record);

    int updateByPrimaryKey(ScriptDO record);

    int batchInsert(@Param("list") List<ScriptDO> list);

    int batchInsertSelective(@Param("list") List<ScriptDO> list, @Param("selective") ScriptDO.Column ... selective);

    int logicalDeleteByExample(@Param("example") ScriptDOExample example);

    int logicalDeleteByPrimaryKey(Long id);

    int upsert(ScriptDO record);

    int upsertByExample(@Param("record") ScriptDO record, @Param("example") ScriptDOExample example);

    int upsertByExampleSelective(@Param("record") ScriptDO record, @Param("example") ScriptDOExample example, @Param("selective") ScriptDO.Column ... selective);

    int upsertByExampleWithBLOBs(@Param("record") ScriptDO record, @Param("example") ScriptDOExample example);

    int upsertSelective(@Param("record") ScriptDO record, @Param("selective") ScriptDO.Column ... selective);

    int upsertWithBLOBs(ScriptDO record);

    int batchUpsert(@Param("list") List<ScriptDO> list);

    int batchUpsertSelective(@Param("list") List<ScriptDO> list, @Param("selective") ScriptDO.Column ... selective);

    int batchUpsertWithBLOBs(@Param("list") List<ScriptDO> list);
}