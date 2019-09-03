package com.groovy.supporter.manager.dao;

import com.groovy.supporter.common.domain.ParameterDO;
import com.groovy.supporter.common.domain.ParameterDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParameterDOMapper {
    long countByExample(ParameterDOExample example);

    int deleteByExample(ParameterDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ParameterDO record);

    int insertSelective(@Param("record") ParameterDO record, @Param("selective") ParameterDO.Column ... selective);

    ParameterDO selectOneByExample(ParameterDOExample example);

    List<ParameterDO> selectByExample(ParameterDOExample example);

    ParameterDO selectByPrimaryKey(Long id);

    ParameterDO selectByPrimaryKeyWithLogicalDelete(@Param("id") Long id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") ParameterDO record, @Param("example") ParameterDOExample example, @Param("selective") ParameterDO.Column ... selective);

    int updateByExample(@Param("record") ParameterDO record, @Param("example") ParameterDOExample example);

    int updateByPrimaryKeySelective(@Param("record") ParameterDO record, @Param("selective") ParameterDO.Column ... selective);

    int updateByPrimaryKey(ParameterDO record);

    int batchInsert(@Param("list") List<ParameterDO> list);

    int batchInsertSelective(@Param("list") List<ParameterDO> list, @Param("selective") ParameterDO.Column ... selective);

    int logicalDeleteByExample(@Param("example") ParameterDOExample example);

    int logicalDeleteByPrimaryKey(Long id);

    int upsert(ParameterDO record);

    int upsertByExample(@Param("record") ParameterDO record, @Param("example") ParameterDOExample example);

    int upsertByExampleSelective(@Param("record") ParameterDO record, @Param("example") ParameterDOExample example, @Param("selective") ParameterDO.Column ... selective);

    int upsertSelective(@Param("record") ParameterDO record, @Param("selective") ParameterDO.Column ... selective);

    int batchUpsert(@Param("list") List<ParameterDO> list);

    int batchUpsertSelective(@Param("list") List<ParameterDO> list, @Param("selective") ParameterDO.Column ... selective);
}