package com.infy.terminal.controller;

import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.terminal.dto.TerminalDTO;
import com.infy.terminal.exception.NotFoundException;
import com.infy.terminal.service.TerminalService;

@RestController
@RequestMapping("/ftr/terminals")
@CrossOrigin()
public class TerminalController {
	
	@Autowired
	private TerminalService service;
	
	@PostMapping()
	public ResponseEntity<TerminalDTO> saveTerminal(@RequestBody TerminalDTO dto)throws NotFoundException
	{
		return service.saveTerminalDetails(dto);
	}
	
	@GetMapping()
	public ResponseEntity<List<TerminalDTO>> fetchAllTerminals() throws NotFoundException
	{
		return service.fetchTerminals();
	}
	
	@PutMapping("/{terminalId}/{newCapacity}")
	public ResponseEntity<String> updateAvailableCapacity(@PathVariable String terminalId,@PathVariable int newCapacity)throws NotFoundException
	{
		return service.updateAvailableCapacity( newCapacity, terminalId);
	}
	
	@GetMapping("/fetchTerminalsByItemType/{itemType}")
	public ResponseEntity<List<TerminalDTO>> fetchTerminalsByItemType(
			@PathVariable("itemType") @Size(min = 4, max = 30) String itemType) throws NotFoundException {

		return service.fetchTerminalsByItemType(itemType);

	}

	@GetMapping("/fetchTerminalsByTerminalId/{terminalId}")
	public ResponseEntity<TerminalDTO> fetchTerminalsByTerminalId(@PathVariable("terminalId") String terminalId)
			throws NotFoundException {

		return service.fetchTerminalsByTerminalId(terminalId);

	}

	@GetMapping("/{terminalId}")
	public ResponseEntity<String> removeTerminal(@PathVariable("terminalId") String terminalId)
			throws NotFoundException {

		return service.removeTerminal(terminalId);

	}


}
