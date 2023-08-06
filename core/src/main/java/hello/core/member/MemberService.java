package hello.core.member;

public interface MemberService {
    // 가입
    void join(Member member);
    // 아이디로 조회
    Member findMember(Long memberId);
}
