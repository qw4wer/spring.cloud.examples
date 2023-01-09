package com.qw4wer.spring.cloud.nacos.examples.seata.stock.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("stock_tbl")
public class Stock {

    private Integer id;
    private String commodityCode;
    private Integer count;

}