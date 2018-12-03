package my.ky.test.web.builder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <ul>
 * <li>模拟用户</li>
 * <li>User:ky Date:2018/8/15 Time:16:05</li>
 * </ul>
 */
@ToString
public class User {

    private String name = null;
    private Integer age = null;

    public static class Builder {

        private User user;

        public static Builder newInstence() {
            Builder builder = new Builder();
            builder.user = new User();
            return builder;
        }

        public Builder setName(String name) {
            this.user.name = name;
            return this;
        }

        public Builder setAge(Integer age) {
            this.user.age = age;
            return this;
        }

        public User build() {
            return this.user;
        }
    }

    public static void main(String[] args) {
        User user = User.Builder.newInstence().setName("yangxp").setAge(20).build();
        System.out.println(user);
    }
}
