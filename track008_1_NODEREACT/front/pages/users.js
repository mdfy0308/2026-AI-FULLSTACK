import { useSelector, useDispatch } from "react-redux"; // STORE : 전역 상태
import { useState, useEffect } from "react"; // REACT - 변경 감지
import { useRouter } from "next/router"; // 경로 이동
import { 
    LOAD_USERS_REQUEST,
    LOG_OUT_REQUEST, 
    UPDATE_NICKNAME_REQUEST,
    DELETE_USER_REQUEST
} from "../reducers/user";


export default function UsersPage(){
    //1. 코드
    const dispatch = useDispatch(); // 1) 전역 상태-store 변화 감지
    const router = useRouter(); // 3) 경로
    const {users, me, isLoading, error} = useSelector( (state)=> state.user ); // 2) 전역상태

    //1-1.  사용자 목록 불러오기
    useEffect(()=>{
        if(!me){ router.push('/login'); }   // 로그인이 안 되어있으면, 로그인 페이지로 이동
        else{ dispatch({type: LOAD_USERS_REQUEST}); } // 사용자 목록 요청
    }, [dispatch, me, router]);

    //1-2. 로그아웃
    const onLogout = ()=>{ dispatch( {type: LOG_OUT_REQUEST} ); }

    //로그아웃 후 me가 null이 되면 로그인 페이지로
    useEffect(()=>{ if(me === null){ router.push('/login'); } }, [me, router]);

    //1-3. 유저삭제
    const onDelete = (id)=>{ dispatch({type: DELETE_USER_REQUEST, data: {id}}); }
    
    //1-4. 닉네임 수정
    const [editID, setEditId] = useState(null); // 닉네임 수정할 id
    const onEdit = (id)=>{ setEditId(id) };

    const [newNickname, setNewNickname] = useState('');
    const onUpdateNickname = (id)=>{ 
        dispatch({type: UPDATE_NICKNAME_REQUEST, data: {id, nickname:newNickname}}); 
        setEditId(null);
        setNewNickname('');
    };


    //2. view - 렌더링
    return (
        <div className="container my-4">
            <h3 className="mb-3">사용자 목록</h3>
            {/* 로딩/에러 상태 표시 */}
            {isLoading && <div className="alert alert-info">로딩 중….</div>}
            {error && <div className="alert alert-warning">{error}</div>}
            {/* 사용자 목록 테이블 */}
            <table className="table table-striped table-bordered table-hover text-center">
                <caption>사용자 목록</caption>
                <thead className="table-dark">
                    <tr>
                        <th scope="col">E-mail</th>
                        <th scope="col">Nickname</th>
                        <th scope="col">Update/Delete</th>
                    </tr>
                </thead>
                <tbody>
                    {users.map( (u)=>(<tr key={u.id}>
                        <td>{u.email}</td>
                        <td>{ editID === u.id
                            ? <input type="text" className="form-control" placeholder="새 닉네임 입력"
                            value={newNickname} onChange={(e)=> setNewNickname(e.target.value)} />
                            : (u.nickname)
                            }
                        </td>
                        <td>{ editID !== u.id
                            ? <button className="btn btn-primary btn-sm me-3" onClick={()=> onEdit(u.id)}>닉네임 수정</button>
                            : <button className="btn btn-primary btn-sm me-3" onClick={()=> onUpdateNickname(u.id)}>수정 완료</button>
                            }
                            <button className="btn btn-danger btn-sm" onClick={()=> onDelete(u.id)}>삭제</button>
                        </td>
                    </tr>) )}
                </tbody>
            </table>

            {/* 로그아웃 버튼 */}
            {me && 
                <div className="text-end">
                    <button className="btn btn-secondary" onClick={onLogout}>로그아웃</button>
                </div>
            }
        </div>
    );
}