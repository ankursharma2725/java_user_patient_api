package com.pcm.api.service;

import com.pcm.api.dto.PmsUserDto;
import com.pcm.api.entity.PmsPatientVitals;
import com.pcm.api.entity.PmsUser;
import com.pcm.api.entity.UserType;
import com.pcm.api.repository.PmsPatientVitalsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcm.api.repository.PmsUserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PmsUserService {
    @Autowired
    private PmsUserRepository pmsUserRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<PmsUserDto> getAllData() {
        List<PmsUserDto> userDtos = pmsUserRepo.findAll()
                .stream()
                .map(user -> modelMapper.map(user, PmsUserDto.class))
                .collect(Collectors.toList());
        return userDtos;
    }

    public PmsUserDto getUserById(long id) {
        PmsUser pmsuser = pmsUserRepo.findById(id).get();
        return modelMapper.map(pmsuser, PmsUserDto.class);
    }

    public PmsUserDto insertUser(PmsUserDto userDto) {
        PmsUser user = modelMapper.map(userDto, PmsUser.class);
        user.setCreatedDate(LocalDateTime.now());
        user.setUpdatedDate(LocalDateTime.now());
        pmsUserRepo.save(user);
        return modelMapper.map(user, PmsUserDto.class);
    }

    public PmsUserDto updateUser(PmsUserDto userDto, Long id) {
        PmsUser pms = pmsUserRepo.findById(id).get();
        if(pms != null) {
            pms.setUserId(userDto.getUserId());
            pms.setFname(userDto.getFname());
            pms.setLname(userDto.getLname());
//            pms.setType(userDto.getType());
            pms.setUpdatedDate(LocalDateTime.now());
            pms.setMessage(userDto.getMessage());
            pmsUserRepo.save(pms);
            return modelMapper.map(pms, PmsUserDto.class);
        }
        return null;
    }

    public void removeUser() {
        pmsUserRepo.deleteAll();
    }

    public void removeUserById(long id) {
        pmsUserRepo.deleteById(id);
    }
}



