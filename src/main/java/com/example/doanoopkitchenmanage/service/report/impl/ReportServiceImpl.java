package com.example.doanoopkitchenmanage.service.report.impl;

import com.example.doanoopkitchenmanage.model.Report;
import com.example.doanoopkitchenmanage.repository.ReportRepository;
import com.example.doanoopkitchenmanage.service.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportRepository reportRepository;

    @Override
    public Iterable<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public Optional<Report> findById(Long id) {
        return reportRepository.findById(id);
    }

    @Override
    public void save(Report report) {
        reportRepository.save(report);
    }

    @Override
    public void remove(Long id) {
        reportRepository.deleteById(id);
    }
}
