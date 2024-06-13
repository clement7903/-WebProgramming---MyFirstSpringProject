package com.embark.MyFirstSpringProject.company;

import com.embark.MyFirstSpringProject.job.Job;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Long id, Company updatedCompany);
    void createCompany(Company company);
    boolean deleteCompanyById(Long id);
    Company getCompanyById(Long id);
}
