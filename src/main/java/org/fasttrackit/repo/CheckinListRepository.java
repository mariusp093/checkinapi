package org.fasttrackit.repo;

import org.fasttrackit.model.CheckinList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface CheckinListRepository extends
        PagingAndSortingRepository<CheckinList, Long> {


    public List<CheckinList> findAgendaByName(String name);

    @Query("select a from CheckinList a where name like ?1%")
    public List<CheckinList> findAgendaWhereNameLike(String namePart);

}
