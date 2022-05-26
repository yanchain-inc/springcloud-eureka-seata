package io.seata.sample.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.seata.sample.entity.AccountTbl;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kakapo911
 * @since 2022-05-25
 */
public interface AccountTblMapper extends BaseMapper<AccountTbl> {

    @Update("update account_tbl set money = money - #{money} where user_id = #{uid}")
    void updateMoney(@Param("money")int money,@Param("uid") String uid);
}
