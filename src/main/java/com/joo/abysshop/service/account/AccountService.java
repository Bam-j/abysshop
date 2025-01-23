package com.joo.abysshop.service.account;

import com.joo.abysshop.dto.account.AccountSignInRequest;
import com.joo.abysshop.dto.account.AccountSignInResponse;
import com.joo.abysshop.dto.account.AccountSignUpRequest;
import com.joo.abysshop.dto.account.AccountWithdrawRequest;
import com.joo.abysshop.dto.account.ChangeNicknameRequest;
import com.joo.abysshop.dto.account.ChangePasswordRequest;
import com.joo.abysshop.entity.account.AccountEntity;
import com.joo.abysshop.entity.account.SignInEntity;
import com.joo.abysshop.entity.account.SignUpEntity;
import com.joo.abysshop.entity.user.UserEntity;
import com.joo.abysshop.enums.ResultStatus;
import com.joo.abysshop.mapper.dto.ToAccountDTOMapper;
import com.joo.abysshop.mapper.entity.ToAccountEntityMapper;
import com.joo.abysshop.mapper.mybatis.AccountMapper;
import com.joo.abysshop.mapper.mybatis.UserMapper;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountMapper accountMapper;
    private final UserMapper userMapper;
    private final ToAccountDTOMapper toAccountDTOMapper;
    private final ToAccountEntityMapper toAccountEntityMapper;

    public ResultStatus signIn(AccountSignInRequest accountSignInRequest, Model model) {
        String username = accountSignInRequest.getUsername();
        Optional<AccountEntity> optionalAccountEntity = accountMapper.findByUsername(username);
        SignInEntity signInEntity;

        if (optionalAccountEntity.isEmpty()) {
            model.addAttribute("failureMessage", "존재하지 않는 계정입니다.");
            return ResultStatus.FAILURE;
        } else {
            AccountEntity accountEntity = optionalAccountEntity.get();
            signInEntity = SignInEntity.builder()
                .username(accountEntity.getUsername())
                .nickname(accountEntity.getNickname())
                .password(accountEntity.getPassword())
                .build();
        }

        AccountSignInResponse accountSignInResponse = toAccountDTOMapper.toAccountSignInResponse(
            signInEntity);
        String password = accountSignInRequest.getPassword();
        String savedPassword = accountSignInResponse.getPassword();

        if (password.equals(savedPassword)) {
            return ResultStatus.SUCCESS;
        } else {
            model.addAttribute("failureMessage", "패스워드가 일치하지 않습니다.");
            return ResultStatus.FAILURE;
        }
    }

    public ResultStatus signUp(AccountSignUpRequest accountSignUpRequest) {
        String username = accountSignUpRequest.getUsername();
        Optional<AccountEntity> optionalAccountEntity = accountMapper.findByUsername(username);

        //username 조회 결과가 존재하면 회원가입 요청 실패
        if (optionalAccountEntity.isPresent()) {
            return ResultStatus.FAILURE;
        }

        String nickname = accountSignUpRequest.getNickname();
        optionalAccountEntity = accountMapper.findByNickname(nickname);

        //nickname 조회 결과가 존재하면 회원가입 요청 실패
        if (optionalAccountEntity.isPresent()) {
            return ResultStatus.FAILURE;
        }

        SignUpEntity signUpEntity = toAccountEntityMapper.toSignUpEntity(accountSignUpRequest);
        accountMapper.insertUser(signUpEntity);

        return ResultStatus.SUCCESS;
    }

    public ResultStatus changeNickname(ChangeNicknameRequest changeNicknameRequest) {
        Long userId = changeNicknameRequest.getUserId();
        Optional<UserEntity> optionalUserEntity = userMapper.findByUserId(userId);

        if (optionalUserEntity.isEmpty()) {
            //TODO: 각 FAILURE 상황에 따른 실패 메세지 전달
            //id 조회 결과 users_table에 유저가 없음 = 잘못된 요청
            return ResultStatus.FAILURE;
        }

        UserEntity userEntity = optionalUserEntity.get();
        String oldNickname = userEntity.getNickname();
        String newNickname = changeNicknameRequest.getNewNickname();

        if (oldNickname.equals(newNickname)) {
            //바꾸려는 nickname과 현재 사용 중인 nickname이 동일함
            return ResultStatus.FAILURE;
        }

        Optional<AccountEntity> optionalAccountEntity = accountMapper.findByNickname(newNickname);

        if (optionalAccountEntity.isPresent()) {
            //바꾸려는 nickname을 가진 유저가 users_table에 존재함
            return ResultStatus.FAILURE;
        }

        accountMapper.updateNickname(userId, newNickname);
        return ResultStatus.SUCCESS;
    }

    public ResultStatus changePassword(ChangePasswordRequest changePasswordRequest) {
        Long userId = changePasswordRequest.getUserId();
        Optional<UserEntity> optionalUserEntity = userMapper.findByUserId(userId);

        if (optionalUserEntity.isEmpty()) {
            //TODO: 각 FAILURE 상황에 따른 실패 메세지 전달
            //id 조회 결과 users_table에 유저가 없음 = 잘못된 요청
            return ResultStatus.FAILURE;
        }

        UserEntity userEntity = optionalUserEntity.get();
        String oldPassword = userEntity.getPassword();
        String newPassword = changePasswordRequest.getNewPassword();

        if (oldPassword.equals(newPassword)) {
            //바꾸려는 nickname과 현재 사용 중인 nickname이 동일함
            return ResultStatus.FAILURE;
        }

        accountMapper.updatePassword(userId, newPassword);
        return ResultStatus.SUCCESS;
    }

    public ResultStatus withdraw(AccountWithdrawRequest accountWithdrawRequest) {
        Long userId = accountWithdrawRequest.getUserId();
        String password = accountWithdrawRequest.getPassword();
        Optional<UserEntity> optionalUserEntity = userMapper.findByUserId(userId);

        if (optionalUserEntity.isEmpty()) {
            //조회된 유저 없음 = 잘못된 요청
            return ResultStatus.FAILURE;
        }

        UserEntity userEntity = optionalUserEntity.get();

        if (!password.equals(userEntity.getPassword())) {
            //유저의 password와 입력된 password가 불일치함
            return ResultStatus.FAILURE;
        }

        accountMapper.deleteUser(userId);

        return ResultStatus.SUCCESS;
    }
}
