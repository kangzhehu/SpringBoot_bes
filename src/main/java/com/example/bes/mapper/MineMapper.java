package com.example.bes.mapper;

import com.example.bes.entity.Mine;
import com.example.bes.entity.Table;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MineMapper {

    Mine selectMineById(Integer id);

    Mine selectMineByName(String name);

    List<Mine> selectAllMine();

    List<Mine> selectMineByRegion(String region);

    List<Mine> selectMineByClassification(String classification);

    List<Mine> selectMineByProduct(String product);

    List<Mine> selectMineByProducts(List<String> products);

    List<Mine> selectByword(String word);


    List<Table> selectMineProducts(@Param("name") String name,@Param("region") String region,
                                   @Param("classification") String classification,
                                    @Param("sort") String sort,@Param("offset") int offset,@Param("limit") int limit
                                    );

    Long selectCountMine(@Param("name") String name,@Param("region") String region,
                         @Param("classification") String classification);

    int insertMine(Mine mine);

    int updateMine(Mine mine);
}
