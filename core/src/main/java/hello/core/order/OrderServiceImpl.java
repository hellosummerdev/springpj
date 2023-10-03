package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FiexedDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//    새로운 정책 적용을 위해 FiexedDiscountPolicy를 주석 처리 --> 이렇게 바꾸는 순간 OCP 위반
//    private final DiscountPolicy discountPolicy = new FiexedDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
