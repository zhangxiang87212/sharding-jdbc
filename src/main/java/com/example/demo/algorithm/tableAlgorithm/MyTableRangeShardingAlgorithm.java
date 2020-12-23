package com.example.demo.algorithm.tableAlgorithm;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

public class MyTableRangeShardingAlgorithm implements RangeShardingAlgorithm<Long> {

    @Override
    public Collection<String> doSharding(Collection<String> tableNames,
                                         RangeShardingValue<Long> rangeShardingValue) {

        Set<String> result = new LinkedHashSet<>();
        // between and 的起始值
        long lower = rangeShardingValue.getValueRange().lowerEndpoint();
        long upper = rangeShardingValue.getValueRange().upperEndpoint();
        // 循环范围计算分库逻辑
        for (long i = lower; i <= upper; i++) {
            for (String tableName : tableNames) {
                if (tableName.endsWith(i % tableNames.size() + "")) {
                    result.add(tableName);
                }
            }
            if (result.size() == tableNames.size()) {
                break;
            }
        }
        return result;
    }
}
