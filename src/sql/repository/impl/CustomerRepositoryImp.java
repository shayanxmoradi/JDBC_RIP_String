package sql.repository.impl;

import sql.domain.BaseEntity;
import sql.domain.Customer;
import sql.repository.CustomerRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerRepositoryImp extends BaseEntityRepositoryImpl implements CustomerRepository {

    public CustomerRepositoryImp(Connection connection) {
        super(connection);
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
    public List findAll() {
        return List.of();
    }

    @Override
    protected BaseEntity mapResultSetToBaseEntity(ResultSet resultSet) throws SQLException {
        return new Customer(resultSet.getLong("id"),
                resultSet.getString("customer_name"),
                resultSet.getString("customer_street"),
                resultSet.getString("customer_city"));
    }

    @Override
    protected String getTableName() {
        return "customer";
    }

    @Override
    public Void deleteById(Long id) {
        return null;
    }

    @Override
    public long count() throws SQLException {
        return 0;
    }
}
