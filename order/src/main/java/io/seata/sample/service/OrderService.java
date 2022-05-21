/*
 *  Copyright 1999-2021 Seata.io Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.seata.sample.service;

import io.seata.core.context.RootContext;
import io.seata.sample.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author jimin.jm@alibaba-inc.com
 * @date 2019/06/14
 */
@Service
public class OrderService {

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(String userId, String commodityCode, Integer count) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int orderMoney = count * 10;
        jdbcTemplate.update("insert order_tbl(user_id,commodity_code,count,money) values(?,?,?,?)",
            new Object[] {userId, commodityCode, count, orderMoney});

        userFeignClient.reduce(userId, orderMoney);
        String unbind = RootContext.unbind();
        System.out.println("XID===>"+unbind);
        jdbcTemplate.update("insert order_tbl(user_id,commodity_code,count,money) values(?,?,?,?)",
                new Object[]{"U2000", "C20000", 200, 10000});
        RootContext.bind(unbind);
        throw new RuntimeException("异常-测试");

    }
}
