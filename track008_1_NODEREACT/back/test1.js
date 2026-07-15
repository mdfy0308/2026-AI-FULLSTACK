const   {createUser, findUserByEmail, findUserById, 
        verifyUser, getAllUsers, updateUserNickname, 
        deleteUser, findUserByNickname} = require('./models/users');

async function runTests() {
    try {
        //1. 회원가입
        await createUser('a@a', 'a', 'alpha', '01012345678', 1, 'a.png');
        console.log('✅ createUser 성공');

        //2. 이메일로 조회
        const userByEmail = await findUserByEmail('a@a');
        console.log('✅ userByEmail 성공');
        
    } catch (err) {
        console.error('❌ 테스트중 오류 발생', err);
    }
}

runTests();

// node test1.js