package com.andersenlab.web_user_tracker.factory;

import com.andersenlab.web_user_tracker.repository.UserRepository;

interface UserRepositoryFactory {
    UserRepository getRepository();
}
