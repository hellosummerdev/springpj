package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    /**
     *
     * @param member
     * @param price
     * @return 할인 대상 금액 - 할인 금액이 얼마인지
     */
    int discount(Member member, int price);

}
