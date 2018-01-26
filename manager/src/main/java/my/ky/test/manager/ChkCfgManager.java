package my.ky.test.manager;

import lombok.extern.slf4j.Slf4j;
import my.ky.test.commons.enums.ChkType;
import my.ky.test.commons.enums.ErrorCode;
import my.ky.test.commons.enums.Status;
import my.ky.test.commons.exception.BusiException;
import my.ky.test.dal.mapper.ChkCfgMapper;
import my.ky.test.dal.model.ChkCfg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <ul>
 * <li>对账配置表Manager实现</li>
 * <li>User:蒯越 Date:2016/4/12 Time:9:35</li>
 * </ul>
 */
@Slf4j
@Service
public class ChkCfgManager {

    @Autowired
    private ChkCfgMapper chkCfgMapper;

    public int insert(ChkCfg chkCfg) {
        // 参数校验
//        ValidateUtil.validateChkCfg(chkCfg);
        // 唯一性校验`
        ChkCfg result = chkCfgMapper.selectOne(chkCfg);
        if (result != null) {
            throw new BusiException(ErrorCode.COMPANY_EXISTED, result.getCompanyCode());
        }
        chkCfg.setStatus(Status.CHK_CFG_OPEN.getCode());
        log.info("新增对账配置,请求参数【{}】", chkCfg);
        int rows = chkCfgMapper.insert(chkCfg);
        log.info("新增对账配置,新增行数【{}】", rows);
        return rows;
    }

    public int update(ChkCfg chkCfg) {
        /*// ID校验
        if (StringUtils.isBlank(chkCfg.getId())) {
            throw new CheckBusiException(ErrorCode.ID_NULL);
        }
        // 参数校验
        ValidateUtil.validateChkCfg(chkCfg);*/
        log.info("更新对账配置,请求参数【{}】", chkCfg);
        int rows = chkCfgMapper.update(chkCfg);
        log.info("更新对账配置,更新行数【{}】", rows);
        return rows;
    }

    public int updateStatus(ChkCfg chkCfg) {
        /*// ID校验
        if (StringUtils.isBlank(chkCfg.getId())) {
            throw new CheckBusiException(ErrorCode.ID_NULL);
        }*/
        log.info("更新对账配置状态,请求参数【{}】", chkCfg);
        int rows = chkCfgMapper.update(chkCfg);
        log.info("更新对账配置状态,更新行数【{}】", rows);
        return rows;
    }

    public List<ChkCfg> selectOpenChkCfg(ChkType chkType) {
        ChkCfg query = new ChkCfg();
        query.setChkType(chkType.getCode());
        query.setStatus(Status.CHK_CFG_OPEN.getCode());
        log.info("查询已开通的对账配置,查询条件【{}】", query);
        List<ChkCfg> chkCfgs = chkCfgMapper.selectByParams(query);
        log.info("查询已开通的对账配置,结果条数【{}】", chkCfgs.size());
        return chkCfgs;
    }

    public ChkCfg selectByCompanyCode(String companyCode) {
        /*// 校验
        ValidateUtil.validateCompanyCode(companyCode);*/
        // 查询
        ChkCfg query = new ChkCfg();
        query.setCompanyCode(companyCode);
        log.info("根据商户或支付通道代码查询,查询条件【{}】", query);
        List<ChkCfg> chkCfgs = chkCfgMapper.selectByParams(query);
        log.info("根据商户或支付通道代码查询,结果条数【{}】", chkCfgs.size());
        if (chkCfgs.size() > 0) {
            return chkCfgs.get(0);
        } else {
            return null;
        }
    }

    public ChkCfg selectById(String id) {
        ChkCfg query = new ChkCfg();
        query.setId(id);
        return chkCfgMapper.selectOne(query);
    }

    public int selectTotalCount(ChkCfg query) {
        log.info("分页查询总条数,查询条件【{}】", query);
        int i = chkCfgMapper.selectTotalCount(query);
        log.info("分页查询总条数,查询结果【{}】", i);
        return i;
    }

    public List<ChkCfg> selectPageList(ChkCfg query) {
        log.info("分页查询页面列表,查询条件【{}】", query);
        List<ChkCfg> list = chkCfgMapper.selectPageList(query);
        log.info("分页查询页面列表,结果条数【{}】", list.size());
        return list;
    }
}
