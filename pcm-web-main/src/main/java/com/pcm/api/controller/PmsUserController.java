package com.pcm.api.controller;

import com.pcm.api.dto.PmsUserDto;
import com.pcm.api.entity.PmsUser;
import com.pcm.api.service.PmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pmsuser")
public class PmsUserController {
    @Autowired
    private PmsUserService userService;

    @GetMapping("/user")
    public List<PmsUserDto> getAllData() {
        return userService.getAllData();
    }

    @GetMapping("/user/{id}")
    public PmsUserDto getUserById(@PathVariable int id) {
       return userService.getUserById(id);
    }

    @PostMapping("/cu")
    public PmsUserDto insertUser(@RequestBody PmsUserDto userDto) {
        return userService.insertUser(userDto);
    }

    @PutMapping("/uu/{id}")
    public PmsUserDto updateUser(@RequestBody PmsUserDto userDto, @PathVariable Long id) {
        return userService.updateUser(userDto, id);
    }

    @DeleteMapping("/removeAll")
    public void removeUser() {
        userService.removeUser();
    }

    @DeleteMapping("/remove/{id}")
    public void removeUserById(@PathVariable int id) {
        userService.removeUserById(id);
    }
}
