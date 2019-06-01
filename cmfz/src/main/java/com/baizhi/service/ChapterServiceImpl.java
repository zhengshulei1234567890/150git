package com.baizhi.service;

import com.baizhi.dao.ChapterMapper;
import com.baizhi.entity.Banner;
import com.baizhi.entity.Chapter;
import org.apache.commons.io.FileUtils;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService{
    @Autowired
    ChapterMapper chapterMapper;
    @Override
    public Map<String, Object> showPage(Integer page, Integer rows,String albumId) {
//准备返回客户端的数据
        Map<String, Object> maps = new HashMap<>();
        //当前页号String albumId
        maps.put("page", page);
        Integer totalCount = chapterMapper.selectTotalCount();
        //总条数
        maps.put("records", totalCount);
        //总页数
        Integer pageCount = 0;
        //总页数
        if (totalCount % rows != 0) {
            pageCount = totalCount / rows + 1;
        } else {
            pageCount = totalCount / rows;
        }
        maps.put("total", pageCount);
        //当前数据内容
        List<Chapter> employees = chapterMapper.selectByPrimaryKey(page, rows,albumId);
        maps.put("rows", employees);
        return maps;
    }
    //添加
    @Override
    public String insert(Chapter chapter) {
        String id = UUID.randomUUID().toString().replace("-", "");
        chapter.setId(id);
        chapter.setCreatedate(new Date());
        chapterMapper.insert(chapter);
        return chapter.getId();
    }
    //删除
    @Override
    public void deleteByPrimaryKey(String[] id) {
        chapterMapper.deleteByPrimaryKey(id);
    }


    //修改
    @Override
    public String updateByPrimaryKey(Chapter chapter) {
        chapterMapper.updateByPrimaryKey(chapter);
        return chapter.getId();
    }
    //上传
   @Override
    public void uploadChapter(MultipartFile path, HttpSession session, String chapterId) {
        //1.判断上传的文件夹是否存在
        String realPath = session.getServletContext().getRealPath("/upload/audio");
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        //2.获得文件真名
        String originalFilename = path.getOriginalFilename();
        //3.为了防止同一个文件上传多次发生覆盖
        String name = new Date().getTime() + "_" + originalFilename;
        try {
            path.transferTo(new File(realPath, name));
            //获得时长
            //1.读取上传完成的音频
            AudioFile read = AudioFileIO.read(new File(realPath, name));
            AudioHeader audioHeader = read.getAudioHeader();
            int trackLength = audioHeader.getTrackLength();
            String seconds = trackLength % 60 + "秒";
            String minute = trackLength / 60 + "分";
            long l = path.getSize();
            String size = l / 1024 / 1024 + "MB";
            Chapter chapter = new Chapter();
            chapter.setId(chapterId);
            chapter.setDuration(minute + seconds);
            chapter.setSize(size);
            chapter.setPath(name);
            chapter.setCreatedate(new Date());
            chapterMapper.updateByPrimaryKeySelective(chapter);
            System.out.println(chapter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void downLoadAudio(String audioName, HttpServletResponse response,HttpSession session) {
        String realPath = session.getServletContext().getRealPath("upload/audio");
        //获取音频的文件
        File file = new File(realPath, audioName);
        String s = audioName.split("_")[1];
        try {
            String encode = URLEncoder.encode(s, "UTF-8");
            response.setHeader("content-disposition","attachment;filename="+encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //设置响应头
        ServletOutputStream outputStream=null;
        try {
            outputStream = response.getOutputStream();
            FileUtils.copyFile(file,outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }


    }
}
