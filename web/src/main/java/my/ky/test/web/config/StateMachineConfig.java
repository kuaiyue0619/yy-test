/*
package my.ky.test.web.config;

import lombok.extern.slf4j.Slf4j;
import my.ky.test.commons.enums.Events;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;

import java.util.EnumSet;

*/
/**
 * <ul>
 * <li>状态机配置</li>
 * <li>User:ky Date:2018/2/22 Time:9:34</li>
 * </ul>
 *//*

@Slf4j
@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states
                .withStates()
                .initial(States.UNPAID)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(States.UNPAID).target(States.WAITING_FOR_RECEIVE)
                .event(Events.PAY)
                .and()
                .withExternal()
                .source(States.WAITING_FOR_RECEIVE).target(States.DONE)
                .event(Events.RECEIVE);
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
            throws Exception {
        config
                .withConfiguration()
                .listener(listener());
    }

    @Bean
    public StateMachineListener<States, Events> listener() {
        return new StateMachineListenerAdapter<States, Events>() {

            @Override
            public void transition(Transition<States, Events> transition) {
                if(transition.getTarget().getId() == States.UNPAID) {
                    logger.info("订单创建，待支付");
                    return;
                }

                if(transition.getSource().getId() == States.UNPAID
                        && transition.getTarget().getId() == States.WAITING_FOR_RECEIVE) {
                    logger.info("用户完成支付，待收货");
                    return;
                }

                if(transition.getSource().getId() == States.WAITING_FOR_RECEIVE
                        && transition.getTarget().getId() == States.DONE) {
                    logger.info("用户已收货，订单完成");
                    return;
                }
            }

        };
    }
}
*/
