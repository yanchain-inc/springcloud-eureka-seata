package io.seata.sample.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author kakapo911
 * @since 2022-05-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Activity extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * id编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 活动类型 0,1
     */
    private Integer activitiesType;

    private LocalDateTime createTime;

    /**
     * 序号
     */
    private String activityName;

    /**
     * 状态（1有效，0无效）
     */
    private Integer status;

    /**
     * 有效期开始时间
     */
    private LocalDateTime startTime;

    /**
     * 有效期结束时间
     */
    private LocalDateTime endTime;


}
