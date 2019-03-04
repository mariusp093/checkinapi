package org.fasttrackit.repo;

import org.fasttrackit.model.Passport;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface PassportRepository extends
        PagingAndSortingRepository<Passport, Long> {
}
