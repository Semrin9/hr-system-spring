package com.hr.hrsystem.service;



import com.hr.hrsystem.dto.TransferDto;

import java.util.List;

public interface TransferService {
    public List<TransferDto> findAllTransfers();

    void delete(Integer id);
}