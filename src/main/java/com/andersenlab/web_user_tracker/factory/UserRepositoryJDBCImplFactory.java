package com.andersenlab.web_user_tracker.factory;

import com.andersenlab.web_user_tracker.repository.UserRepository;
import com.andersenlab.web_user_tracker.repository.UserRepositoryJDBCPostgresImpl;

public class UserRepositoryJDBCImplFactory implements UserRepositoryFactory {

    @Override
    public UserRepository getRepository() {
        return new UserRepositoryJDBCPostgresImpl();
    }
}
