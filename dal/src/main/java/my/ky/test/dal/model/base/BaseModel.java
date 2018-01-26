package my.ky.test.dal.model.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <ul>
 * <li>基础实体</li>
 * <li>User:蒯越 Date:2016/4/11 Time:19:11</li>
 * </ul>
 */
@Setter
@Getter
@ToString
public class BaseModel implements Serializable {

    private static final long serialVersionUID = -3472949146990646996L;

    /**
     * 数据库主键
     */
    private String id;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 最后更新人
     */
    private String updatedBy;

    /**
     * 起始行(分页查询条件)
     */
    private int startRow;

    /**
     * 页行数(分页查询条件)
     */
    private int pageSize;
}
