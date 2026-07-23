import { useSelector, useDispatch } from 'react-redux'; // 전역 상태, 상태 알림
import { useState, useEffect } from 'react';    // 변수 상태 변경, 이벤트 변경
import { useRouter } from 'next/router';        // 경로
import { SIGN_UP_REQUEST, SIGN_UP_SUCCESS,
        CHECK_EMAIL_REQUEST, CHECK_EMAIL_SUCCESS,
        CHECK_NICKNAME_REQUEST, CHECK_NICKNAME_SUCCESS
} from '../reducers/user';

export default function JoinPage(){
    //1. 코드
    const dispatch = useDispatch();
    const router = useRouter();
    const {me, isLoading, error, signUpDone, 
        checkEmailLoading, checkEmailDone, checkEmailError, isEmailAvailable,
        checkNicknameLoading, checkNicknameDone, checkNicknameError, isNicknameAvailable
    } = useSelector( (state)=> state.user ); // 1. store : 전역 상태 감지 useSelector
    //      변수, 변수셋팅함수
    const [email, setEmail] = useState(''); // let email=''
    const [password, setPassword] = useState(''); //
    const [nickname, setNickname] = useState(''); // 3. 변수 상태 변경 - REACT DOM (useState)

    // 회원가입 요청액션 dispatch
    const onSubmit = (e)=>{
        e.preventDefault();
        
        if(!email.trim()){ alert('이메일을 입력해주세요.'); return; }
        if(!password.trim()){ alert('비밀번호를 입력해주세요.'); return; }
        if(!nickname.trim()){ alert('닉네임을 입력해주세요.'); return; }

        dispatch({type: SIGN_UP_REQUEST, data:{email, password, nickname}});
    };

    // 5. 상태변화 감지
    useEffect(()=>{
        if(signUpDone){ // 경로변경
            router.push({
                pathname: '/login',
                query: { signUpSuccess : 'true' } // 회원가입 성공여부 주소표시창줄
            });
        }
    }, [signUpDone, router]);

    // 로그인시 me가 값이 있다면
    useEffect(()=>{
        if(me) router.push('/users');
    }, [me, router]);


    // 이메일 중복검사 요청
    const onCheckEmail = (e)=>{
        e.preventDefault();
        if(!email.trim()){ alert('이메일을 입력해주세요.'); return; }
        
        dispatch({type: CHECK_EMAIL_REQUEST, data:email});
    };

    // 닉네임 중복검사 요청
    const onCheckNickname = (e)=>{
        e.preventDefault();
        if(!nickname.trim()){ alert('닉네임을 입력해주세요.'); return; }
        
        dispatch({type: CHECK_NICKNAME_REQUEST, data:nickname});
    };


    //2. view - 렌더링
    return (
        <div className="container my-4">
            <h3 className="mb-3">회원가입</h3>
            <form className="w-50 mx-auto" onSubmit={onSubmit}>
                {/* 이메일 입력 */}
                <div className="mb-3 input-group">
                    <input type="email" className="form-control" 
                    placeholder="이메일 입력" title="이메일 입력"
                    value={email}
                    onChange={(e)=>{ setEmail(e.target.value) }}
                    />
                    <button className='btn btn-sm btn-outline-secondary'
                    type='button' onClick={onCheckEmail} disabled={checkEmailLoading}>
                        {checkEmailLoading ? '확인 중...' : '중복 확인'}
                    </button>
                </div>
                {isEmailAvailable==true && <div className='text-success mb-2'>사용 가능한 이메일입니다.</div>}
                {isEmailAvailable==false && <div className='text-danger mb-2'>이미 사용중인 이메일입니다.</div>}
                {/* 비밀번호 입력 */}
                <div className="mb-3">
                    <input type="password" className="form-control"
                    placeholder="비밀번호 입력" title="비밀번호 입력"
                    value={password}
                    onChange={(e)=>{setPassword(e.target.value);}}
                    />
                </div>
                {/* 닉네임 입력 */}
                <div className="mb-3  input-group">
                    <input type="text" className="form-control"
                    placeholder="닉네임 입력" title="닉네임 입력"
                    value={nickname}
                    onChange={(e)=>{setNickname(e.target.value);}}
                    />
                    <button className='btn btn-sm btn-outline-secondary'
                    type='button' onClick={onCheckNickname} disabled={checkNicknameLoading}>
                        {checkNicknameLoading ? '확인 중...' : '중복 확인'}
                    </button>
                </div>
                {isNicknameAvailable==true && <div className='text-success mb-2'>사용 가능한 닉네임입니다.</div>}
                {isNicknameAvailable==false && <div className='text-danger mb-2'>이미 사용중인 닉네임입니다.</div>}
                {/* 버튼 입력 */}
                <div className="mb-3">
                    <button type="submit" className="btn btn-primary w-100" 
                    disabled={isLoading || !isEmailAvailable || !isNicknameAvailable}>회원가입</button>
                </div>
            </form>

            {/* 에러 메세지 */}
            {error && <div className="alert alert-warning mt-3 w-50 mx-auto text-center">{error}</div>}
        </div>
    );
}