package com.the703.dao;

import com.the703.dto.AuthDto;
import com.the703.dto.AuthListDto;
import com.the703.dto.UserDto;

@Mapper
public interface UserMapper {
	
	//public resultType id(parameterType);
	public int		join(UserDto dto);
	public int		findLogin(UserDto dto);
	public UserDto	findByUno(int uno);
	public String	findByEmail(String email);
	
	/* security */
	public int insertAuth(AuthDto dto);
	public AuthListDto readAuth(AuthDto dto);
	public UserDto findByEmailUserInfo(String email);
	
}

/*

mysql> desc authorities;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| email | varchar(50) | NO   |     | NULL    |       |
| auth  | varchar(50) | NO   |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
2 rows in set (0.00 sec)

-- insert 구문 찾기
insert into authorities(email, auth) values('#{email}', '#{auth}');

-- join 이용해서 email, bpass, auth 필드값 찾기
select u.email, u.bpass, a.auth 
from users u left join authorities a on u.email=a.email
where u.email='first@gmail.com';



*/