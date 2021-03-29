package com.andersenlab.web_user_tracker.repository;

import com.andersenlab.web_user_tracker.entity.UserEntity;
import com.andersenlab.web_user_tracker.exception.DataAccessException;
import com.andersenlab.web_user_tracker.jdbc.DBCPDataSource;
import com.andersenlab.web_user_tracker.mapper.RowMapper;
import lombok.RequiredArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserRepositoryJDBCPostgresImpl implements UserRepository {

    private RowMapper<UserEntity> mapper = rs -> {
        try {
            return new UserEntity(
                    rs.getLong("id"),
                    rs.getString("nick_name"),
                    rs.getString("full_name"),
                    rs.getString("email")
            );
        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
    };

    @Override
    public List<UserEntity> findAll() {
        try (
                final Connection conn = DBCPDataSource.getConnection();
                final Statement stmt = conn.createStatement();
                final ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM users WHERE removed = false LIMIT 50");
        ) {
            final List<UserEntity> result = new ArrayList<>();
            while (rs.next()) {
                final UserEntity entity = mapper.map(rs);
                System.out.println(entity.toString());
                result.add(entity);
            }
            return result;
        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        final String query = "SELECT id, nick_name, full_name, email FROM users WHERE id = ? AND removed = false";
        try (
                final Connection conn = DBCPDataSource.getConnection();
                final PreparedStatement psmt = conn.prepareStatement(query)
        ) {
            psmt.setLong(1, id);
            try (final ResultSet rs = psmt.executeQuery()) {
                return rs.next() ? Optional.of(mapper.map(rs)) : Optional.empty();
            }

        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
    }

    @Override
    public List<UserEntity> findAllOrderedBy(String arg) {
        final String query = "SELECT * FROM users WHERE removed = false ORDER BY " + arg;
        System.out.println(arg);
        try (
                final Connection conn = DBCPDataSource.getConnection();
                final Statement psmt = conn.createStatement();
        ) {
            final List<UserEntity> result = new ArrayList<>();
//            psmt.setString(1, arg);
            try (final ResultSet rs = psmt.executeQuery(query)) {
                while (rs.next()) {
                    UserEntity entity = mapper.map(rs);
                    System.out.println(entity);
                    result.add(entity);
                }
            }
            return result;
        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
    }

    @Override
    public Optional<UserEntity> findByNick(String nick) {
        final String query = "SELECT id, nick_name, full_name, email FROM users WHERE nick_name = ? AND removed = 0";
        try (
                final Connection conn = DBCPDataSource.getConnection();
                final PreparedStatement psmt = conn.prepareStatement(query)
        ) {
            psmt.setString(1, nick);
            try (final ResultSet rs = psmt.getResultSet()) {
                return rs.next() ? Optional.of(mapper.map(rs)) : Optional.empty();
            }

        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
    }

    @Override
    public UserEntity save(UserEntity entity) {
        if (entity.getId() == 0) {
            final String query = "INSERT INTO users (nick_name, full_name, email) VALUES (?,?,?)" +
                    " RETURNING id, nick_name, full_name, email, removed";
            try (
                    final Connection conn = DBCPDataSource.getConnection();
                    final PreparedStatement pstmt = conn.prepareStatement(query)
            ) {
                pstmt.setString(1, entity.getNickName());
                pstmt.setString(2, entity.getFullName());
                pstmt.setString(3, entity.getEmail());

                try (final ResultSet rs = pstmt.executeQuery()) {
                    if (!rs.next()) {
                        throw new DataAccessException();
                    }
                    System.out.println((mapper.map(rs).toString()));
                    return mapper.map(rs);
                }
            } catch (SQLException e) {
                throw new DataAccessException(e);
            }
        }

        final String query =
                "UPDATE users SET nick_name = ?, full_name = ?, email = ? WHERE id = ? " +
                        "RETURNING id, nick_name, full_name, email, removed";
        try (
                final Connection conn = DBCPDataSource.getConnection();
                final PreparedStatement pstmt = conn.prepareStatement(query)
        ) {
            pstmt.setString(1, entity.getNickName());
            pstmt.setString(2, entity.getFullName());
            pstmt.setString(3, entity.getEmail());
            pstmt.setLong(4, entity.getId());

            try (final ResultSet rs = pstmt.executeQuery()) {
                if (!rs.next()) {
                    throw new DataAccessException();
                }
                return mapper.map(rs);
            }
        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
    }

    @Override
    public boolean removeById(Long id) {
        final String update = "UPDATE users SET removed = true WHERE id = ? RETURNING removed";
        try (
                final Connection conn = DBCPDataSource.getConnection();
                final PreparedStatement pstmt = conn.prepareStatement(update)
        ) {
            pstmt.setLong(1, id);
            try (final ResultSet rs = pstmt.executeQuery()) {
                return rs.next() && rs.getBoolean("removed");
            }
        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
    }

    @Override
    public boolean existsByLogin(String login) {
        final String query = "SELECT nick_name FROM users WHERE nick_name = ?";
        try (
                final Connection conn = DBCPDataSource.getConnection();
                final PreparedStatement psmt = conn.prepareStatement(query)
        ) {
            psmt.setString(1, login);
            try (final ResultSet rs = psmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
    }
}
