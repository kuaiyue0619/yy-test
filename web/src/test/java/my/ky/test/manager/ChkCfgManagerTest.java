package my.ky.test.manager;

import my.ky.test.BaseSpringTest;
import my.ky.test.commons.enums.ChkCycle;
import my.ky.test.commons.enums.ChkType;
import my.ky.test.commons.enums.CompanyType;
import my.ky.test.commons.enums.DependOnBankChkFlag;
import my.ky.test.commons.enums.FileMethod;
import my.ky.test.commons.enums.RefundCheckFlag;
import my.ky.test.commons.enums.Status;
import my.ky.test.dal.model.ChkCfg;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <ul>
 * <li>对账配置表测试</li>
 * <li>User:蒯越 Date:2016/4/11 Time:19:45</li>
 * </ul>
 */
public class ChkCfgManagerTest extends BaseSpringTest {

    @Autowired
    private ChkCfgManager chkCfgManager;

    @Test
    public void testInsert() {
        ChkCfg chkCfg = new ChkCfg();
        chkCfg.setCompanyCode("01310010021022000");
        chkCfg.setCompanyType(CompanyType.MCHNT.getCode());
        chkCfg.setChkType(ChkType.NOT_AUTONOMOUSLY.getCode());
        chkCfg.setFileMethod(FileMethod.FTP.getCode());
        chkCfg.setChkCycle(ChkCycle.T_PLUS_1.getCode());
        chkCfg.setFtpHost("192.168.200.54");
        chkCfg.setFtpPort(21);
        chkCfg.setFtpUser("bill");
        chkCfg.setFtpPwd("Bill@2016");
        chkCfg.setFtpRemoteDir("/jessicatest");
        chkCfg.setOperateImplClass("billPlatformOperateInterface");
        chkCfg.setRefundCheckFlag(RefundCheckFlag.PARTICIPATE_CHECK.getCode());
        chkCfg.setDependOnBankChkFlag(DependOnBankChkFlag.NO.getCode());
        chkCfg.setStatus(Status.CHK_CFG_OPEN.getCode());
        chkCfg.setOpenBy("kuaiyue");
        chkCfg.setCreatedBy("kuaiyue");
        chkCfg.setUpdatedBy("kuaiyue");
        chkCfgManager.insert(chkCfg);
    }

    @Test
    public void testSelectOpenChkCfg() {
        List<ChkCfg> list = chkCfgManager.selectOpenChkCfg(ChkType.NOT_AUTONOMOUSLY);
        System.out.println(list);
        list = chkCfgManager.selectOpenChkCfg(ChkType.NOT_AUTONOMOUSLY);
        System.out.println(list);
    }
}
