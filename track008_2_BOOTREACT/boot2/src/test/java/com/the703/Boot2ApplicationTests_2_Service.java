package com.the703;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.transaction.annotation.Transactional;

import com.the703.domain.DeptUser;
import com.the703.dto.UserDto.UserRequestDto;
import com.the703.dto.UserDto.UserResponseDto;
import com.the703.entity.AppUser;
import com.the703.entity.Comment;
import com.the703.entity.Hashtag;
import com.the703.entity.Image;
import com.the703.entity.Post;
import com.the703.entity.PostLike;
import com.the703.mapper.DeptUserMapper;
import com.the703.repository.AppUserRepository;
import com.the703.repository.CommentRepository;
import com.the703.repository.DeptUserRepository;
import com.the703.repository.HashtagRepository;
import com.the703.repository.ImageRepository;
import com.the703.repository.PostLikeRepository;
import com.the703.repository.PostRepository;
import com.the703.service.UserService;

@SpringBootTest
@Transactional
class Boot2ApplicationTests_2_Service {

	@Autowired UserService userService;
	
	
	
}
