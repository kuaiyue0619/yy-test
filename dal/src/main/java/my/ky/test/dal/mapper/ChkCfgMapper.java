package my.ky.test.dal.mapper;


import my.ky.test.dal.model.ChkCfg;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * <ul>
 * <li>对账配置表Mapper</li>
 * <li>User:蒯越 Date:2016/4/11 Time:19:10</li>
 * </ul>
 */
//@CacheConfig(cacheNames = "chkcfg")
public interface ChkCfgMapper {

    /**
     * 新增
     *
     * @param chkCfg 对账配置
     * @return rows
     */
//    @CachePut
    int insert(ChkCfg chkCfg);

    /**
     * 更新
     *
     * @param chkCfg 对账配置
     * @return rows
     */
//    @CachePut
    int update(ChkCfg chkCfg);

    /**
     * 查询单条记录
     * 仅可通过 ID 或 代码,类型 查询
     *
     * @param query 查询条件
     * @return ChkCfg
     */
    ChkCfg selectOne(ChkCfg query);

    /**
     * 条件查询
     *
     * @param query 查询条件
     * @return List
     */
//    @Cacheable
    List<ChkCfg> selectByParams(ChkCfg query);

    /**
     * 分页查询总条数
     *
     * @param query 查询条件
     * @return int
     */
    int selectTotalCount(ChkCfg query);

    /**
     * 分页查询页面列表
     *
     * @param query 查询条件
     * @return List
     */
    List<ChkCfg> selectPageList(ChkCfg query);
}
