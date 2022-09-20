package com.infy.terminal.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.infy.terminal.dto.TerminalDTO;
import com.infy.terminal.entity.ftr_terminals;

public class Utility {

	public static ftr_terminals getTerminalObj(TerminalDTO dto, List<String> termid) {

		List<Integer> arrList = new ArrayList<>();
		for (String str : termid) {
			arrList.add(Integer.parseInt(str.substring(1)));
		}
		Collections.sort(arrList);
		System.out.println(arrList);
        int termId=arrList.get(arrList.size()-1);
		String newId = "T" + (termId+1);
		ftr_terminals terminal = new ftr_terminals(newId, dto.getName(), dto.getCountry(), dto.getItem_type(),
				dto.getTerminal_description(), dto.getCapacity(), dto.getAvailable_capacity(), dto.getStatus(),
				dto.getHarborLocation());
		return terminal;
	}

}
