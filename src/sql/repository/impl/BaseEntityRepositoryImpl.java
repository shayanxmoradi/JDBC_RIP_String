package sql.repository.impl;

import sql.domain.BaseEntity;
import sql.repository.BaseEntityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseEntityRepositoryImpl implements BaseEntityRepository {

    public static final String FIND_ALL_QUERY_TEMPLATE = "select * from %s";
    public static final String COUNT_ALL_QUERY_TEMPLATE = "select count(*) from %s";

    public static final String FIND_BY_ID_QUERY_TEMPLATE = "select * from %s where id = ?";
    public static final String DELETE_BY_ID_QUERY_TEMPLATE = "delete from %s where id = ?";

    public static final String DELETE_ALL_QUERY_TEMPLATE = "delete from %s where id > 0";
    public static final String EXISTS_BY_ID_QUERY_TEMPLATE = "select count(*) from %s where id = ?";

    protected final Connection connection;

    public BaseEntityRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public BaseEntity save(BaseEntity entity) {
        return null;
    }

    @Override
    public BaseEntity update(BaseEntity entity) {
        return null;
    }

    @Override
    public BaseEntity delete(BaseEntity entity) {
        return null;
    }

    @Override
    public BaseEntity findById(Long id) {
        return null;
    }



    @Override
    public List findAll() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                getFindAllQuery()
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        List baseEntities = new ArrayList<>();

        while (resultSet.next()) {
            baseEntities.add(mapResultSetToBaseEntity(resultSet));
        }

        return baseEntities;
    }
    protected abstract BaseEntity mapResultSetToBaseEntity(ResultSet resultSet) throws SQLException;


    protected String getFindAllQuery() {
        return String.format(
                FIND_ALL_QUERY_TEMPLATE,
                getTableName()
        );

    }

    protected abstract String getTableName();

    @Override
    public Void deleteById(Long id) {
        return null;
    }

    @Override
    public long count() throws SQLException {
        return 0;
    }
}
