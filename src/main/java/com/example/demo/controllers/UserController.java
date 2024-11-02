package com.example.demo.controllers;

import com.example.demo.mappers.UserMapper;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import com.example.demo.models.UserProductsModel;
import com.example.demo.services.IUserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
// @RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("get-first-name")
    public String getFirstName() {
        return "probno Ime";
    }

//    @GetMapping("get-user-list")
//    public List<UserModel> getUserList(){
//        return UserMapper.toModelList(userService.findAll());
//    }
//
//    @GetMapping("get-user-page-list")
//    public List<UserPageModel> getUserPageList(Integer pageNumber, Integer pageSize){
//        return userRepository.findAll(PageRequest.of(pageNumber, pageSize));
//    }

    @GetMapping("get-list")
    public List<UserModel> getList() { return userService.findAll(); }

    @GetMapping("get-user-products-list")
    public List<UserProductsModel> getUserProductsList() {
        return userService.findUserProductsAll();
    }

    @GetMapping("get-page-list")
    public UserPageModel getPageList(Integer pageNumber, Integer pageSize) {
        return userService.findPagedList(PageRequest.of(pageNumber=0, pageSize=10));
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid UserModel userModel, BindingResult result) {
        return ResponseEntity.ok(userService.create(userModel));
    }

    @PostMapping("update")
    public ResponseEntity<?> update(@RequestBody @Valid UserModel userModel, BindingResult result) {
        return ResponseEntity.ok(userService.update(userModel));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(Integer userId) {
        userService.delete(userId);
        return ResponseEntity.ok("");
    }
}
