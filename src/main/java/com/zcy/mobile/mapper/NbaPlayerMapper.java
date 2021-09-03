package com.zcy.mobile.mapper;

import com.zcy.mobile.pojo.NbaPlayer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhongchengye
 * @create 2021-09-02 16:53
 */
@Service
public interface NbaPlayerMapper {
    List<NbaPlayer> listNbaPlayer();
}
