//1. require
const dbConfig = require('../config/db'); // user, password, connectString
const oracleDB = require('oracledb');
const bcrypt = require('bcrypt');

// 오라클 초기화
oracleDB.initOracleClient();
const options = {outFormat: oracleDB.OUT_FORMAT_OBJECT, autoCommit:true};

//2. 각 기능 sql
//2-1. create  - insert
async function createUser(email, password, nickname, mobile, mbtiTypeId, ufile) {
    let conn;
    try{ 
        conn = await oracleDB.getConnection(dbConfig); 
        const hashedPassword = await bcrypt.hash(password, 10);
        const result = await conn.execute(
            ` INSERT INTO appuser (
            APP_USER_ID, EMAIL, PASSWORD, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT
            ) VALUES (
            APPUSER_SEQ.NEXTVAL, :email, :password, :nickname, :mobile, :mbtiTypeId, :ufile, sysdate
            )`, { email, password: hashedPassword, nickname, mobile, mbtiTypeId, ufile }
            , options); // sql, 사용자 입력값, 옵션
    }catch(err){ 
        console.log(`createUser Error`, err);
        throw err;
    }finally{ 
        if(conn) await conn.close(); 
    }
}

//2-2. 사용자 조회 - email
async function findUserByEmail(email){
    let conn;
    try{ 
        conn = await oracleDB.getConnection(dbConfig);
        const result = await conn.execute(`
            SELECT APP_USER_ID, EMAIL, PASSWORD, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT
            FROM APPUSER 
            WHERE EMAIL = :email`
            , {email}
            , options); // 실행
        return result.rows[0]; // 결과 처리
    }catch(err){ 
        console.log(`findUserByEmail Error`, err);
        throw err;
    }finally{ 
        if(conn) await conn.close(); 
    }
}

//2-3. 사용자 조회 - id
async function findUserById(id){
    let conn;
    try{ 
        conn = await oracleDB.getConnection(dbConfig); 
        const result = await conn.execute(`
            SELECT APP_USER_ID, EMAIL, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT
            FROM APPUSER WHERE APP_USER_ID = :id`
            , {id}
            , options); // 실행
        return result.rows[0]; // 결과 처리
    }catch(err){ 
        console.log(`findUserById Error`, err);
        throw err;
    }finally{ 
        if(conn) await conn.close(); 
    }
}

//2-4. 로그인 - sql 빼기 pass / 로그아웃
async function verifyUser(email, password){
    const user = await findUserByEmail(email);
    if(!user) return null;

    const match = await bcrypt.compare(password, user.PASSWORD);
    if(!match) return null;
    
    return {
        id : user.APP_USER_ID,
        email : user.email,
        nickname : user.nickname
    }
}

//2-5. 전체 조회(Read All)
async function getAllUsers(){
    let conn;
    try{ 
        conn = await oracleDB.getConnection(dbConfig);
        const result = await conn.execute(`
            SELECT APP_USER_ID, EMAIL, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT
            FROM APPUSER
            ORDER BY CREATED_AT DESC`
            , {}
            , options); //실행
        return result.rows; //결과
    }catch(err){ 
        console.log(`getAllUsers Error`, err);
        throw err;
    }finally{ 
        if(conn) await conn.close(); 
    }
}
;

//2-6. 닉네임 수정
async function updateUserNickname(nickname, id){
    let conn;
    try{ 
        conn = await oracleDB.getConnection(dbConfig); 
        const result = await conn.execute(`
            UPDATE APPUSER SET NICKNAME = :nickname
            WHERE APP_USER_ID = :id`
            , {nickname, id}
            , options);
        return result; // 결과 처리
    }catch(err){ 
        console.log(`updateUserNickname Error`, err);
        throw err;
    }finally{ 
        if(conn) await conn.close(); 
    }
}

//2-7. 사용자 삭제
async function deleteUser(id){
    let conn;
    try{ 
        conn = await oracleDB.getConnection(dbConfig); 
        const result = await conn.execute(`
            DELETE FROM APPUSER
            WHERE APP_USER_ID = :id`
            , {id}
            , options);
    }catch(err){ 
        console.log(`deleteUser Error`, err);
        throw err;
    }finally{ 
        if(conn) await conn.close(); 
    }
}


//2-8. 닉네임 조회
async function findUserByNickname(nickname){
    let conn;
    
    try{ 
        conn = await oracleDB.getConnection(dbConfig);
        const result = await conn.execute(`
            SELECT APP_USER_ID, EMAIL, PASSWORD, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT
            FROM APPUSER
            WHERE NICKNAME = :nickname`
            , {nickname}
            , options);
        return result.rows[0];
    }catch(err){ 
        console.log(`findUserByNickname Error`, err);
        throw err;
    }finally{ 
        if(conn) await conn.close(); 
    }
}


// export
module.exports={ createUser, findUserByEmail, findUserById, 
                 verifyUser, getAllUsers, updateUserNickname, 
                 deleteUser, findUserByNickname };