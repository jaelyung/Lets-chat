package chatting.chatting.member.domain;

//import javax.persistence.Entity;
//import javax.persistence.Id;


public class Member {

    private String memberId;
    private String memberPw;
    private String memberNm;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public String getMemberNm() {
        return memberNm;
    }

    public void setMemberNm(String memberNm) {
        this.memberNm = memberNm;
    }
}
