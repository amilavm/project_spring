package com.jkcs.profilebuilder.controller;

import com.jkcs.profilebuilder.model.JobTemplateSkillRate;
import com.jkcs.profilebuilder.model.JobVacancy;
import com.jkcs.profilebuilder.model.Skills;
import com.jkcs.profilebuilder.repository.JobTemplateSkillRate_Repository;
import com.jkcs.profilebuilder.repository.JobVacancyRepository;
import com.jkcs.profilebuilder.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by AmilaVM on 3/12/2017.
 */
@RestController
public class JobVacancyController {

    private JobVacancyRepository jobVacancyRepository;
    @Autowired
    public void setJobVacancyRepository(JobVacancyRepository jobVacancyRepository) {
        this.jobVacancyRepository = jobVacancyRepository;
    }

    private JobTemplateSkillRate_Repository jobTemplateSkillRate_repository;
    @Autowired
    public void setJobTemplateSkillRate_repository(JobTemplateSkillRate_Repository jobTemplateSkillRate_repository) {
        this.jobTemplateSkillRate_repository = jobTemplateSkillRate_repository;
    }

    private SkillsRepository skillsRepository;
    @Autowired
    public void setSkillsRepository(SkillsRepository skillsRepository) {
        this.skillsRepository = skillsRepository;
    }

    //----------create a new template for a job vacancy--------------------//
    @RequestMapping(value = "/jobVacancy" , method = RequestMethod.POST)
    public ResponseEntity<JobTemplateSkillRate> createNewTemplate(@RequestBody JobTemplateSkillRate jobTemplateSkillRate){
        System.out.println("creating a new job template including skills...");

        JobVacancy jobVacancyUnSaved = jobTemplateSkillRate.getJobvacancy();
        Skills skillsUnSaved = jobTemplateSkillRate.getSkills();

        JobVacancy jobVacancySaved = jobVacancyRepository.save(jobVacancyUnSaved);

        JobTemplateSkillRate newJobTemplateSkillRate = new JobTemplateSkillRate();
        newJobTemplateSkillRate.setJobvacancy(jobVacancySaved);
        newJobTemplateSkillRate.setSkills(skillsUnSaved);
        newJobTemplateSkillRate.setReq_rate(jobTemplateSkillRate.getReq_rate());

        jobTemplateSkillRate_repository.save(newJobTemplateSkillRate);

        return new ResponseEntity<JobTemplateSkillRate>(newJobTemplateSkillRate, HttpStatus.CREATED);
    }

    //-------------view all job templates-------------------------------//

    public ResponseEntity<List<JobTemplateSkillRate>> listAllTemplates(){
        System.out.println("list out all job templates");

        List<JobTemplateSkillRate> templates = jobTemplateSkillRate_repository.findAll();
        if (templates.isEmpty()){
            return new ResponseEntity<List<JobTemplateSkillRate>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<JobTemplateSkillRate>>(templates, HttpStatus.OK);
    }
}
