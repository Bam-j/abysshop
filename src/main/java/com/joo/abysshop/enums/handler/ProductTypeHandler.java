package com.joo.abysshop.enums.handler;

import com.joo.abysshop.enums.ProductType;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(ProductType.class)
public class ProductTypeHandler extends BaseTypeHandler<ProductType> {

    @Override
    public void setParameter(PreparedStatement ps, int i, ProductType parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.toString());
    }

    @Override
    public ProductType getResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return ProductType.valueOf(value.toUpperCase());
    }
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ProductType parameter,
        JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.name());
    }

    @Override
    public ProductType getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return ProductType.valueOf(value);
    }

    @Override
    public ProductType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return ProductType.valueOf(value);
    }

    @Override
    public ProductType getNullableResult(CallableStatement cs, int columnIndex)
        throws SQLException {
        String value = cs.getString(columnIndex);
        return ProductType.valueOf(value);
    }
}
