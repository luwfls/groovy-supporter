package com.groovy.supporter.manager.dao;

import com.groovy.supporter.common.domain.UserDO;
import com.groovy.supporter.common.domain.UserDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDOMapper {
    long countByExample(UserDOExample example);

    int deleteByExample(UserDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserDO record);

    int insertSelective(@Param("record") UserDO record, @Param("selective") UserDO.Column ... selective);

    UserDO selectOneByExample(UserDOExample example);

    List<UserDO> selectByExample(UserDOExample example);

    UserDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserDO record, @Param("example") UserDOExample example, @Param("selective") UserDO.Column ... selective);

    int updateByExample(@Param("record") UserDO record, @Param("example") UserDOExample example);

    int updateByPrimaryKeySelective(@Param("record") UserDO record, @Param("selective") UserDO.Column ... selective);

    int updateByPrimaryKey(UserDO record);

    int batchInsert(@Param("list") List<UserDO> list);

    int batchInsertSelective(@Param("list") List<UserDO> list, @Param("selective") UserDO.Column ... selective);

    int upsert(UserDO record);

    int upsertByExample(@Param("record") UserDO record, @Param("example") UserDOExample example);

    int upsertByExampleSelective(@Param("record") UserDO record, @Param("example") UserDOExample example, @Param("selective") UserDO.Column ... selective);

    int upsertSelective(@Param("record") UserDO record, @Param("selective") UserDO.Column ... selective);

    int batchUpsert(@Param("list") List<UserDO> list);

    int batchUpsertSelective(@Param("list") List<UserDO> list, @Param("selective") UserDO.Column ... selective);
}