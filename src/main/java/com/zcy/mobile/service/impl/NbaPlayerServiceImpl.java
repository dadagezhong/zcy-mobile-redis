package com.zcy.mobile.service.impl;

import com.zcy.mobile.mapper.NbaPlayerMapper;
import com.zcy.mobile.pojo.NbaPlayer;
import com.zcy.mobile.service.NbaPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhongchengye
 * @create 2021-09-02 17:08
 */
@Service
public class NbaPlayerServiceImpl implements NbaPlayerService {

    @Autowired
    NbaPlayerMapper nbaPlayerMapper;

    @Override
    public List<NbaPlayer> ListNbaPlayer() {
        return nbaPlayerMapper.listNbaPlayer();
    }
}
