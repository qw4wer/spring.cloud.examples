package com.qw4wer.spring.cloud.nacos.examples.seata.stock.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qw4wer.spring.cloud.nacos.examples.seata.stock.entity.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StockDAO extends BaseMapper<Stock> {

}