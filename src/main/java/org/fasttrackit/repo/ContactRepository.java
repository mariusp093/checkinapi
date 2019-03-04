package org.fasttrackit.repo;

import org.fasttrackit.model.Contact;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ContactRepository extends
        PagingAndSortingRepository<Contact, Long> {
}
