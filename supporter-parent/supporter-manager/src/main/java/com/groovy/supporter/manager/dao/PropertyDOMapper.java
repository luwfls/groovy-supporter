package com.groovy.supporter.manager.dao;

import com.groovy.supporter.common.domain.PropertyDO;
import com.groovy.supporter.common.domain.PropertyDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PropertyDOMapper {
    long countByExample(PropertyDOExample example);

    int deleteByExample(PropertyDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PropertyDO record);

    int insertSelective(@Param("record") PropertyDO record, @Param("selective") PropertyDO.Column ... selective);

    PropertyDO selectOneByExample(PropertyDOExample example);

    List<PropertyDO> selectByExample(PropertyDOExample example);

    PropertyDO selectByPrimaryKey(Long id);

    PropertyDO selectByPrimaryKeyWithLogicalDelete(@Param("id") Long id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") PropertyDO record, @Param("example") PropertyDOExample example, @Param("selective") PropertyDO.Column ... selective);

    int updateByExample(@Param("record") PropertyDO record, @Param("example") PropertyDOExample example);

    int updateByPrimaryKeySelective(@Param("record") PropertyDO record, @Param("selective") PropertyDO.Column ... selective);

    int updateByPrimaryKey(PropertyDO record);

    int batchInsert(@Param("list") List<PropertyDO> list);

    int batchInsertSelective(@Param("list") List<PropertyDO> list, @Param("selective") PropertyDO.Column ... selective);

    int logicalDeleteByExample(@Param("example") PropertyDOExample example);

    int logicalDeleteByPrimaryKey(Long id);

    int upsert(PropertyDO record);

    int upsertByExample(@Param("record") PropertyDO record, @Param("example") PropertyDOExample example);

    int upsertByExampleSelective(@Param("record") PropertyDO record, @Param("example") PropertyDOExample example, @Param("selective") PropertyDO.Column ... selective);

    int upsertSelective(@Param("record") PropertyDO record, @Param("selective") PropertyDO.Column ... selective);

    int batchUpsert(@Param("list") List<PropertyDO> list);

    int batchUpsertSelective(@Param("list") List<PropertyDO> list, @Param("selective") PropertyDO.Column ... selective);
}