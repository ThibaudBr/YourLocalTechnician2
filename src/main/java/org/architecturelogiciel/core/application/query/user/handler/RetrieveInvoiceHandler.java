package org.architecturelogiciel.core.application.query.user.handler;

import org.architecturelogiciel.core.application.query.user.RetrieveUser;
import org.architecturelogiciel.core.domain.entities.user.User;
import org.architecturelogiciel.core.domain.repository.UserRepository;
import org.architecturelogiciel.core.kernel.query.QueryHandler;

import java.util.List;

public class RetrieveInvoiceHandler implements QueryHandler<RetrieveUser, List<User>> {

    private final UserRepository userRepository;

    public RetrieveInvoiceHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(RetrieveUser query) {
        return userRepository.findAllUser();
    }
}
