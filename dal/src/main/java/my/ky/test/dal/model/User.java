package my.ky.test.dal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <ul>
 * <li>用户</li>
 * <li>User:ky Date:2018/1/2 Time:16:37</li>
 * </ul>
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private Integer age;
}
