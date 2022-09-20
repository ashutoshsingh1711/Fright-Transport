package com.infy.terminal.repos;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.infy.terminal.entity.ftr_terminals;

@Repository
@Transactional
public interface TerminalRepository extends JpaRepository<ftr_terminals, String> {
	
	@Query(value="select terminal_id from ftr_terminals ORDER BY terminal_id" , nativeQuery=true)
	List<String> findLastTerminalId();
	
	
	@Query("select available_capacity from ftr_terminals where terminal_id=?1")
	public Optional<Integer> findAvailableCapacityByTerminalId(String terminalId);
	
	@Modifying
	@Query("update ftr_terminals t set available_capacity=available_capacity - ?1 where terminal_id=?2")
	public void UpdateAvailableCapacity(int capacity, String terminalId);
	
	@Query("from ftr_terminals f where f.item_type=:x ")
	Optional<List<ftr_terminals>> findTerminalsByItemType(@Param("x")String itemType);
	
	@Query("from ftr_terminals f where f.terminal_id=:x ")
	Optional<ftr_terminals> findTerminalByTerminalId(@Param("x")String terminalId);
	

}
