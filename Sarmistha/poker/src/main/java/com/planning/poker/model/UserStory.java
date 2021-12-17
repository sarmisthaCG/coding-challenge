package com.planning.poker.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "UserStory")
public class UserStory {

	@Id
	@Column(name = "uStoryId" , nullable = false)
	private String uStoryId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "count")
	private Integer count;
	
	@Enumerated(EnumType.STRING)
    private VotingStatus votingStatus;
	
	@Column(name = "sizeOfTheStory")
	private Integer sizeOfTheStory;
	
	
	public VotingStatus getVotingStatus() {
		return votingStatus;
	}


	public void setVotingStatus(VotingStatus votingStatus) {
		this.votingStatus = votingStatus;
	}


	/*
	 * @OneToOne(fetch = FetchType.LAZY, optional = false)
	 * 
	 * @JoinColumn(name = "voteStatusId", nullable = false)
	 */
	/* @ManyToOne
    @JoinColumn(name="voteStatusId", nullable=false)
    private VoteStatus voteStatus;*/
	
	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(name="uStoryId")
	 */
//	@ManyToMany(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL,
//            mappedBy = "userStories")
	/*
	 * @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "member_userstory", joinColumns = { @JoinColumn(name =
	 * "uStoryId") }, inverseJoinColumns = { @JoinColumn(name = "memberId") })
	 * private Set<Member> members = new HashSet<Member>();
	 */
	

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="session")
    private PokerSession pokerSession;
	
	/*
	 * public Set<Member> getMembers() { return members; }
	 * 
	 * 
	 * public void setMembers(Set<Member> members) { this.members = members; }
	 */

	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="uStoryId")
	private Set<MemberUserStory> memberUstory;

	public Set<MemberUserStory> getMemberUstory() {
		return memberUstory;
	}


	public void setMemberUstory(Set<MemberUserStory> memberUstory) {
		this.memberUstory = memberUstory;
	}


	public UserStory() {
		super();
	}


	public UserStory(String uStoryId, String description) {
		super();
		this.uStoryId = uStoryId;
		this.description = description;
	}
	
	
	/*
	 * public UserStory(String uStoryId, String description, VoteStatus voteStatus)
	 * { super(); this.uStoryId = uStoryId; this.description = description;
	 * //this.voteStatus = voteStatus; }
	 */


	public UserStory(String uStoryId, String description, Integer count) {
		super();
		this.uStoryId = uStoryId;
		this.description = description;
		this.count = count;
		//this.voteStatus = voteStatus;
	}


	public String getuStoryId() {
		return uStoryId;
	}
	public void setuStoryId(String uStoryId) {
		this.uStoryId = uStoryId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/*
	 * public VoteStatus getVoteStatus() { return voteStatus; } public void
	 * setVoteStatus(VoteStatus voteStatus) { this.voteStatus = voteStatus; }
	 */


	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}

	

	public Integer getSizeOfTheStory() {
		return sizeOfTheStory;
	}


	public void setSizeOfTheStory(Integer sizeOfTheStory) {
		this.sizeOfTheStory = sizeOfTheStory;
	}


	public PokerSession getPokerSession() {
		return pokerSession;
	}


	public void setPokerSession(PokerSession pokerSession) {
		this.pokerSession = pokerSession;
	}


	/*
	 * @Override public String toString() { return "UserStory [uStoryId=" + uStoryId
	 * + ", description=" + description + ", count=" + count + ", votingStatus=" +
	 * votingStatus + ", members=" + members + ", pokerSession=" + pokerSession +
	 * "]"; }
	 */
	
	
	
}
