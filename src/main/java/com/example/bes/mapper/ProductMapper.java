package com.example.bes.mapper;

import com.example.bes.entity.Product;
import com.example.bes.entity.Table;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    Product selectProductByName(String name);

    List<Table> selectMineProducts(@Param("name") String name, @Param("region") String region,
                                   @Param("classification") String classification,
                                   @Param("sort") String sort, @Param("offset") int offset, @Param("limit") int limit
    );

    int insertProduct(Product product);

    int updateProduct(Product product);

}
