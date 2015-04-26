package me.hynd.service.impl;

import me.hynd.mapper.HillMapper;
import me.hynd.model.Hill;
import me.hynd.service.BaseServiceAdapter;
import me.hynd.service.HillService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by H on 2015/4/25.
 */
@Service("hillService")
public class HillServiceImpl extends BaseServiceAdapter<Hill> implements HillService  {

    @Resource
    private HillMapper hillMapper;

    @Override
    public void insert(Hill hill) {
        this.hillMapper.insert(hill);
    }

    @Override
    public int update(Hill hill) {
        return this.hillMapper.update(hill);
    }

    @Override
    public void deleteById(Serializable id) {
        this.hillMapper.deleteById(id);
    }


    @Override
    public List<Hill> findAll() {
        return this.hillMapper.findAll();
    }

    @Override
    public Hill findById(Serializable id) {
        return this.findById(id);
    }

}
