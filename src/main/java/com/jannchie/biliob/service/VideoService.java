package com.jannchie.biliob.service;

import com.jannchie.biliob.exception.UserAlreadyFavoriteVideoException;
import com.jannchie.biliob.exception.VideoAlreadyFocusedException;
import com.jannchie.biliob.model.Video;
import com.jannchie.biliob.utils.Message;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/**
 * @author jannchie
 */
@Service
public interface VideoService {

    /**
     * 获得视频详情
     *
     * @param aid 视频id
     * @return 视频详情
     */
    Video getVideoDetails(Long aid);

    /**
     * 提交一个作品追踪
     *
     * @param aid 视频id
     * @return 成功观测的应答
     * @throws UserAlreadyFavoriteVideoException 用户已关注视频
     * @throws VideoAlreadyFocusedException      视频已在观测
     */
    ResponseEntity<Message> postVideoByAid(Long aid) throws UserAlreadyFavoriteVideoException, VideoAlreadyFocusedException;

    /**
     * 获取视频页
     *
     * @param aid      搜索视频id
     * @param text     搜索文本
     * @param page     页数
     * @param pagesize 页大小
     * @return 视频页
     */
    Page<Video> getVideo(Long aid, String text, Integer page, Integer pagesize);

    /**
     * 获取作者其他视频
     *
     * @param aid      视频id
     * @param mid      作者id
     * @param page     页数
     * @param pagesize 页大小
     * @return 视频切片
     */
    Slice<Video> getAuthorVideo(Long aid, Long mid, Integer page, Integer pagesize);
}
