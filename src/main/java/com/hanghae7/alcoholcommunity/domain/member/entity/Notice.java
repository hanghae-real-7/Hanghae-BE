package com.hanghae7.alcoholcommunity.domain.member.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name="Notice")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId;

    @Column(nullable = false)
    private Long partyId;

    @Column(nullable = false)
    private String partyTitle;

    @Column(nullable = false)
    private Boolean accepted;

    @Column(nullable = false)
    private Boolean isRead;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    private Member member;

    public Notice(Long partyId, String partyTitle, Boolean accepted, Boolean isRead, Member member){
        this.partyId = partyId;
        this.partyTitle = partyTitle;
        this.accepted = accepted;
        this.isRead = isRead;
        this.member = member;
    }

    public void updateRead(Boolean isRead){
        this.isRead = isRead;
    }
}
