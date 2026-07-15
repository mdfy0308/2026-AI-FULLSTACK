/**
middlewares/isAuthenticated.js 로그인 인증 미들웨어
---------------------------------
로그인 후 인증된 사용자만 접근 가능한 api
인증이 안 되면 401을 반환하도록 응답
*/

function isAuthenticated(req, res, next) {
  if (req.isAuthenticated && req.isAuthenticated()) { //인증성공
        return next(); //세션 있으면 다음 단계
    }
    return res.status(401).json({ message: '로그인이 필요합니다.' });  
}

module.exports = isAuthenticated;