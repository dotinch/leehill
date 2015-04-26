package me.hynd.mapper;

import me.hynd.annotation.DSDerby;
import me.hynd.model.Hill;
import org.springframework.stereotype.Repository;

/**
 * Created by H on 2015/4/25.
 */
@DSDerby
@Repository
public interface HillMapper extends BaseMapper<Hill> {

}
