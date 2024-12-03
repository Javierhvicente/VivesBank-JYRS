package jyrs.dev.vivesbank.users.admins.services;

import jyrs.dev.vivesbank.users.admins.dto.AdminRequestDto;
import jyrs.dev.vivesbank.users.admins.dto.AdminResponseDto;
import jyrs.dev.vivesbank.users.admins.exceptions.AdminExceptions;
import jyrs.dev.vivesbank.users.models.User;
import jyrs.dev.vivesbank.users.users.dto.UserRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.File;
import java.util.List;
import java.util.Optional;

public interface AdminService {
    Page<AdminResponseDto> getAllAdmins(Optional<String> username, Optional<Boolean> isDeleted, Pageable pageable);
    AdminResponseDto getUserByAdmin(String id);
    AdminResponseDto saveAdmin(AdminRequestDto requestDto) throws AdminExceptions.AdminAlreadyExists;
    AdminResponseDto updateAdmin(String id, AdminRequestDto user);
    void deleteAdmin(String id);
    void exportJson(File file, List<User> users);
    void importJson(File file);
}
