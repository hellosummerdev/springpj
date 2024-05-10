package hello.core.member;

import hello.core.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        appConfig 사용 후
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        appConfig 사용 전
//        MemberService memberService = new MemberServiceImpl();

//        스프링 사용 후
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // AppConfig에 있는 설정정보를 스프링컨테이너에 집어넣어서 관리
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
