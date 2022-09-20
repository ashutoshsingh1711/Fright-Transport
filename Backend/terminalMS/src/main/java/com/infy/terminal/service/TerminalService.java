package com.infy.terminal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infy.terminal.dto.TerminalDTO;
import com.infy.terminal.entity.ftr_terminals;
import com.infy.terminal.repos.TerminalRepository;
import com.infy.terminal.utility.Utility;

@Service
@Transactional
public class TerminalService {

	@Autowired
	private TerminalRepository repos;

	@Autowired
	private ModelMapper mapper;

	public ResponseEntity<TerminalDTO> saveTerminalDetails(TerminalDTO dto) {
		List<String> terminalId = repos.findLastTerminalId();
//		System.out.println(terminalId);
		ftr_terminals terminal = Utility.getTerminalObj(dto, terminalId);
//		System.out.println(terminal.getTerminal_id());
		repos.save(terminal);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(mapper.map(terminal, TerminalDTO.class));
	}

	public ResponseEntity<List<TerminalDTO>> fetchTerminals() {
		List<ftr_terminals> terminals = repos.findAll();

		List<TerminalDTO> dtos = new ArrayList<>();
		for (ftr_terminals terminal : terminals) {
			TerminalDTO dto = mapper.map(terminal, TerminalDTO.class);
			dtos.add(dto);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(dtos);

	}

	public ResponseEntity<String> updateAvailableCapacity(int capacity, String terminalId) {
		Optional<Integer> avaCapacity = repos.findAvailableCapacityByTerminalId(terminalId);
		if (avaCapacity.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Terminal details not found for ID:" + terminalId);
		}
		if (avaCapacity.get() < capacity)
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Given capacity is more or equal to the given capacity");
		repos.UpdateAvailableCapacity(capacity, terminalId);
		;
		return ResponseEntity.status(HttpStatus.OK)
				.body("Terminal capacity is successfully reduced for ID :" + terminalId);

	}

	public ResponseEntity<List<TerminalDTO>> fetchTerminalsByItemType(String itemType) {

		Optional<List<ftr_terminals>> terminalsOpt = repos.findTerminalsByItemType(itemType);
		if (terminalsOpt.isPresent()) {
			List<ftr_terminals> terminalsList = terminalsOpt.get();
			List<TerminalDTO> terminalsDto = (List<TerminalDTO>) terminalsList.stream().map(p -> {

				TerminalDTO dto = ftr_terminals.prepareToDto(p);
				return dto;

			}).collect(Collectors.toList());

			return ResponseEntity.status(HttpStatus.ACCEPTED).body(terminalsDto);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

	}

	public ResponseEntity<TerminalDTO> fetchTerminalsByTerminalId(String terminalId) {

		Optional<ftr_terminals> terminalsOpt = repos.findTerminalByTerminalId(terminalId);
		if (terminalsOpt.isPresent()) {
			ftr_terminals terminals = terminalsOpt.get();
			TerminalDTO terminalsDto = ftr_terminals.prepareToDto(terminals);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(terminalsDto);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

	}

	public ResponseEntity<String> removeTerminal(String terminalId) {

		Optional<ftr_terminals> terminalsOpt = repos.findTerminalByTerminalId(terminalId);
		if (terminalsOpt.isPresent()) {
			repos.deleteById(terminalId);
			
			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body("	Success:   Terminal details are deleted successfully.");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body("Fail: Terminal details not found for ID : " + terminalId);

	}

}
