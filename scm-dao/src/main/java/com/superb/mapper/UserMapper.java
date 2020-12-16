package com.superb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.superb.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chao.gao
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    /**
     * 通过性别查询
     * @param sex
     * @return
     */
    List<UserEntity> selectUserBySex(@Param("sex") int sex);

    /**
     * 分页查询
     * @param page
     * @param user
     * @return
     */
    IPage<UserEntity> selectByPage(Page<UserEntity> page, @Param("user") UserEntity user);
}
