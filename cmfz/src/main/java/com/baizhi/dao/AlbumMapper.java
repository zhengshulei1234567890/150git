package com.baizhi.dao;

import com.baizhi.entity.Album;
import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumMapper {
    //删除
    int deleteByPrimaryKey(String[] id);
    //添加
    int insert(Album record);

    int insertSelective(Album record);
    //查询
    Album selectByPrimaryKey(String id);
    //上传修改
    int updateByPrimaryKeySelective(Album record);
    //修改
    int updateByPrimaryKey(Album record);
    //通过分页进行查询                      // 当前页号       每页显示的条数
    public List<Album> showAllByPage(@Param("page") Integer page, @Param("rows") Integer rows);
    //查询总条数
    public  Integer  selectTotalCount();
}