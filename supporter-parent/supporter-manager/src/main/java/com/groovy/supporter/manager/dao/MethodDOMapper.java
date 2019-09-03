package com.groovy.supporter.manager.dao;

import com.groovy.supporter.common.domain.MethodDO;
import com.groovy.supporter.common.domain.MethodDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MethodDOMapper {
    long countByExample(MethodDOExample example);

    int deleteByExample(MethodDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MethodDO record);

    int insertSelective(@Param("record") MethodDO record, @Param("selective") MethodDO.Column ... selective);

    MethodDO selectOneByExample(MethodDOExample example);

    List<MethodDO> selectByExample(MethodDOExample example);

    MethodDO selectByPrimaryKey(Long id);

    MethodDO selectByPrimaryKeyWithLogicalDelete(@Param("id") Long id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") MethodDO record, @Param("example") MethodDOExample example, @Param("selective") MethodDO.Column ... selective);

    int updateByExample(@Param("record") MethodDO record, @Param("example") MethodDOExample example);

    int updateByPrimaryKeySelective(@Param("record") MethodDO record, @Param("selective") MethodDO.Column ... selective);

    int updateByPrimaryKey(MethodDO record);

    int batchInsert(@Param("list") List<MethodDO> list);

    int batchInsertSelective(@Param("list") List<MethodDO> list, @Param("selective") MethodDO.Column ... selective);

    int logicalDeleteByExample(@Param("example") MethodDOExample example);

    int logicalDeleteByPrimaryKey(Long id);

    int upsert(MethodDO record);

    int upsertByExample(@Param("record") MethodDO record, @Param("example") MethodDOExample example);

    int upsertByExampleSelective(@Param("record") MethodDO record, @Param("example") MethodDOExample example, @Param("selective") MethodDO.Column ... selective);

    int upsertSelective(@Param("record") MethodDO record, @Param("selective") MethodDO.Column ... selective);

    int batchUpsert(@Param("list") List<MethodDO> list);

    int batchUpsertSelective(@Param("list") List<MethodDO> list, @Param("selective") MethodDO.Column ... selective);
}