package sql.repository;

import sql.domain.BaseEntity;

import java.sql.SQLException;
import java.util.List;

public interface BaseEntityRepository<T extends BaseEntity> {

    T save (T  entity);
    T update (T entity);
    T delete (T entity);
    T findById(Long id);
    List<T> findAll() throws SQLException;
    Void deleteById(Long id);
    long count() throws SQLException;

}
