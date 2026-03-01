package com.project.lms.service;

import com.project.lms.entity.Member;
import java.util.List;

public interface MemberService {

    Member addMember(Member member);

    List<Member> getAllMembers();

    Member getMemberById(Long id);

    Member updateMember(Long id, Member updated);

    void deleteMember(Long id);
}
