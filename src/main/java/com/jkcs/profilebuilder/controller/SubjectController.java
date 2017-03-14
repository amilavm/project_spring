package com.jkcs.profilebuilder.controller;

import com.jkcs.profilebuilder.model.SubjectDetail;
import com.jkcs.profilebuilder.repository.SubjectDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by AmilaVM on 3/12/2017.
 */
@RestController
public class SubjectController {

    private SubjectDetailRepository subjectDetailRepository;
    @Autowired
    public void setSubjectDetailRepository(SubjectDetailRepository subjectDetailRepository) {
        this.subjectDetailRepository = subjectDetailRepository;
    }

    //-------------enter subjects-----------//
    @RequestMapping(name = "/subjects", method = RequestMethod.POST)
    public ResponseEntity<Void> enterSubjects(@RequestBody SubjectDetail subjectDetail){


        if (subjectDetail.getId() == null){
            subjectDetailRepository.save(subjectDetail);
            System.out.println("entering subject "+subjectDetail.getSubjectName());
        }

        else
            System.out.println("The subject you are trying to create is already exists");

        return new ResponseEntity<Void>(HttpStatus.CREATED);

    }

    //-------------display all subjects-----------//
    @RequestMapping(name = "/subjects" , method = RequestMethod.GET)
    public ResponseEntity<List<SubjectDetail>> displayAllSubjects(){
        System.out.println("displaying all subjects");

        List<SubjectDetail> subjects = subjectDetailRepository.findAll();
        if (subjects.isEmpty()){
            return new ResponseEntity<List<SubjectDetail>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<SubjectDetail>>(subjects, HttpStatus.OK);
    }
}
